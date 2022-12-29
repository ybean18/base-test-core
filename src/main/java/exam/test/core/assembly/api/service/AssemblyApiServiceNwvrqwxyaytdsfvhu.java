package exam.test.core.assembly.api.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import exam.test.core.assembly.api.AssemblyApiUtils;
import reactor.core.publisher.Mono;

/******************************************************************************/
/******************************************************************************/
/******************************************************************************/
/** 삭제 예정                                                                **/
/******************************************************************************/
/******************************************************************************/
/******************************************************************************/
// 국회의원 인적사항
@Service("nwvrqwxyaytdsfvhu")
public class AssemblyApiServiceNwvrqwxyaytdsfvhu implements AssemblyApiService {

	@Autowired
	private WebClient assemblyApiClient;

	private final String API_NAME = "nwvrqwxyaytdsfvhu";

	@Override
	public Mono<String> call(Map<String, String> paramMap) {

		Mono<String> response = assemblyApiClient.get()
				.uri(uriBuilder -> uriBuilder
						.path("{API_NAME}")
						.queryParams(AssemblyApiUtils.buildQueryParams(paramMap))
						.build(API_NAME))
				.retrieve()
				.bodyToMono(String.class);

		return response;
	}
}