package exam.test.prism.core.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import exam.test.prism.core.api.PrismApiLists;
import exam.test.prism.core.api.dto.PrismApiRes;

@Component
public class PrismApi {

	@Autowired
	private WebClient prismApiClient;

	public PrismApiRes call(PrismApiLists prismList, String pageNo, String start_date, String end_date, String serviceKey, String numOfRows) throws Exception {

		// queryParams
		MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
		queryParams.add("pageNo",     pageNo);
		queryParams.add("start_date", start_date);
		queryParams.add("end_date",   end_date);
		queryParams.add("serviceKey",   serviceKey);
		queryParams.add("numOfRows",   numOfRows);

		// call
		return prismApiClient.get()
				.uri(uriBuilder -> uriBuilder
						.path("/{SERVICE_CODE}/{SERVICE_NAME}/{OPERATION_NAME}")
						.queryParams(queryParams)
						.build(PrismApiLists.findByApiCode(prismList.apiCode()).serviceCode(),PrismApiLists.findByApiCode(prismList.apiCode()).serviceName(), PrismApiLists.findByApiCode(prismList.apiCode()).apiCode()))
				.retrieve()
				.bodyToMono(PrismApiRes.class)
				.block();
	}
}