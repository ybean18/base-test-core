package exam.test.core.godata.api.service;

import java.time.Duration;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import exam.test.core.common.AcroCommonApiRes;
import exam.test.core.godata.api.GodataApiLists;
import exam.test.core.godata.api.GodataApiUtils;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

@Component
public class GodataApi {

	@Autowired
	private WebClient godataApiClient;

	public AcroCommonApiRes get(String apiCode, Map<String, String> paramMap) {

		Mono<String> response = call(apiCode, paramMap);

		return GodataApiUtils.convertResponseToAcroCommonApiRes(apiCode, response, paramMap);
	}

	private Mono<String> call(String apiCode, Map<String, String> paramMap) {

		Mono<String> response = godataApiClient.get()
				.uri(uriBuilder -> uriBuilder
						.path("/{SERVICE_CODE}/{SERVICE_NAME}/{OPERATION_NAME}")
						.queryParams(GodataApiUtils.buildQueryParams(paramMap))
						.build(GodataApiLists.findByApiCode(apiCode).serviceCode(),GodataApiLists.findByApiCode(apiCode).serviceName(), GodataApiLists.findByApiCode(apiCode).apiCode()))
				.retrieve()
				.bodyToMono(String.class)
				.retryWhen(Retry.fixedDelay(3, Duration.ofSeconds(1)));

		return response;
	}
}