package exam.test.core.assembly.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Configuration
public class AssemblyApiClientConfig {

	@Bean("assemblyApiClient")
	public WebClient AssemblyApiClient() {

		final ExchangeStrategies strategies = ExchangeStrategies.builder()
				.codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(AssemblyApiConstants.API_MAX_IN_MEMORY_SIZE))
				.build();

		return WebClient
				.builder()
				.baseUrl(AssemblyApiConstants.API_URL)
				.exchangeStrategies(strategies)
				.filters(exchangeFilterFunctions -> {
					exchangeFilterFunctions.add(logRequest());
					exchangeFilterFunctions.add(logResponse());
				})
				.build();
	}

	private static ExchangeFilterFunction logRequest() {
		return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
			log.info("Request: {} {}", clientRequest.method(), clientRequest.url());
			clientRequest.headers().forEach((name, values) -> values.forEach(value -> log.info("{}={}", name, value)));
			return Mono.just(clientRequest);
		});
	}

	private static ExchangeFilterFunction logResponse() {
		return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
			log.info("Response status: {}", clientResponse.statusCode());
			clientResponse.headers().asHttpHeaders().forEach((name, values) -> values.forEach(value -> log.info("{}={}", name, value)));
			return Mono.just(clientResponse);
		});
	}
}