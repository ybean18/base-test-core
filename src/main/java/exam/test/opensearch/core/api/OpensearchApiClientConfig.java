package exam.test.opensearch.core.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.netty.handler.logging.LogLevel;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.logging.AdvancedByteBufFormat;

@Configuration
public class OpensearchApiClientConfig {

	@Value("${test.url.opensearch}")
	private String ihopperUrlOpensearch;
	
	@Bean("opensearchApiClient")
	public WebClient OpensearchApiClient() throws Exception {

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

		final ExchangeStrategies strategies = ExchangeStrategies.builder()
				.codecs(codecs -> {
						codecs.defaultCodecs().maxInMemorySize(OpensearchApiConstants.API_MAX_IN_MEMORY_SIZE);
						codecs.defaultCodecs().jackson2JsonEncoder(new Jackson2JsonEncoder(objectMapper, MediaType.APPLICATION_JSON));
				})
				.build();

		final SslContext context = SslContextBuilder.forClient().trustManager(InsecureTrustManagerFactory.INSTANCE).build();

		final HttpClient httpClient = HttpClient.create()
				.wiretap(this.getClass().getCanonicalName(), LogLevel.INFO, AdvancedByteBufFormat.TEXTUAL)
				.secure(t -> t.sslContext(context));

		return WebClient
				.builder()
				.clientConnector(new ReactorClientHttpConnector(httpClient))
				.baseUrl(ihopperUrlOpensearch)
				.exchangeStrategies(strategies)
				.build();
	}
}