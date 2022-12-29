package exam.test.opensearch.core.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import exam.test.opensearch.core.api.dto.OpensearchApiReq;
import exam.test.opensearch.core.api.dto.OpensearchApiRes;

@Component
public class OpensearchApi {

	@Autowired
	private WebClient opensearchApiClient;

	public OpensearchApiRes call(String uri, OpensearchApiReq opensearchApiReq) {

		OpensearchApiRes response = opensearchApiClient.post()
				.uri(uri)
				.bodyValue(opensearchApiReq)
				.retrieve()
				.bodyToMono(OpensearchApiRes.class)
				.block();

		return response;
	}
}