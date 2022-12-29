package exam.test.file.core.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import exam.test.file.core.dto.ComFileMoveReq;
import exam.test.file.core.dto.ComFileMoveRes;

@Component
public class FileApi {

	@Autowired
	private WebClient fileApiClient;

	@SuppressWarnings("unchecked")
	public ComFileMoveRes moveFile(ComFileMoveReq comFileMoveReq) {

		Map<String, Object> map = fileApiClient.post()
				.uri("/com/file/move")
				.bodyValue(comFileMoveReq)
				.retrieve()
				.bodyToMono(Map.class)
				.block();

		Map<String, Object> data = (Map<String, Object>) map.get("data");
		boolean result = (boolean) data.get("success");

		ComFileMoveRes comFileMoveRes = new ComFileMoveRes();
		comFileMoveRes.setSuccess(result);

		return comFileMoveRes;
	}
}