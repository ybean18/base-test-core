package exam.test.core.assembly.api.service;

import java.time.Duration;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import exam.test.core.assembly.api.AssemblyApiUtils;
import exam.test.core.common.AcroCommonApiRes;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

@Component
public class AssemblyApi {

	@Autowired
	private WebClient assemblyApiClient;

	public AcroCommonApiRes get(String apiCode, Map<String, String> paramMap) {

		Mono<String> response = call(apiCode, paramMap);

		return AssemblyApiUtils.convertResponseToAcroCommonApiRes(apiCode, response, paramMap);
	}

	private Mono<String> call(String apiCode, Map<String, String> paramMap) {

		Mono<String> response = assemblyApiClient.get()
				.uri(uriBuilder -> uriBuilder
						.path("/{API_CODE}")
						.queryParams(AssemblyApiUtils.buildQueryParams(paramMap))
						.build(apiCode))
				.retrieve()
				.bodyToMono(String.class)
				.retryWhen(Retry.fixedDelay(3, Duration.ofSeconds(1)));

		return response;
	}
}