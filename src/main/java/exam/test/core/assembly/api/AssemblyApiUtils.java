package exam.test.core.assembly.api;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.type.TypeFactory;

import exam.test.core.common.AcroCommonApiRes;
import exam.test.core.common.AcroCommonApiResError;
import exam.test.core.common.AcroCommonApiResHeader;
import reactor.core.publisher.Mono;

public class AssemblyApiUtils {

	public static MultiValueMap<String, String> buildQueryParams(Map<String, String> paramMap) {

		MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();

		// app default params
		for (Entry<String, String> item : AssemblyApiConstants.API_DEFAULT_PARAM_MAP.entrySet()) {
			queryParams.add(item.getKey(), item.getValue());
		}

		// add api params
		for (Entry<String, String> item : paramMap.entrySet()) {

			if (queryParams.get(item.getKey()) == null) {
				queryParams.add(item.getKey(), item.getValue());
			} else {
				queryParams.replace(item.getKey(), new ArrayList<>(Arrays.asList(item.getValue())));
			}
		}

		return queryParams;
	}

	public static AcroCommonApiRes convertResponseToAcroCommonApiRes(String apiCode, Mono<String> response, Map<String, String> paramMap) {

		AcroCommonApiRes acroCommonApiRes = new AcroCommonApiRes();

		String body = response.block();

		ObjectMapper objectMapper = new ObjectMapper();

		JsonNode  rootNode   = null;
		JsonNode  headerNode = null;
		ArrayNode dataNode   = null;
		JsonNode  errorNode  = null;

		try {
			rootNode = objectMapper.readTree(body).get(apiCode);

			// error
			if (rootNode == null) {

				errorNode = objectMapper.readTree(body).get("RESULT");

				AcroCommonApiResError acroCommonApiError = new AcroCommonApiResError();
				acroCommonApiError.setCode(errorNode.get("CODE").textValue());
				acroCommonApiError.setMessage(errorNode.get("MESSAGE").textValue());

				acroCommonApiRes.setError(acroCommonApiError);

				return acroCommonApiRes;
			}

			if (rootNode.get(0).get("row") == null) {
				headerNode = rootNode.get(0);
				dataNode   = (ArrayNode) rootNode.get(1).get("row");
			} else {
				headerNode = rootNode.get(1);
				dataNode   = (ArrayNode) rootNode.get(0).get("row");
			}

			// header
			JsonNode headerChildNode1;
			JsonNode headerChildNode2;

			if (headerNode.get("head").get(0).get("RESULT") == null) {
				headerChildNode1 = headerNode.get("head").get(0);
				headerChildNode2 = headerNode.get("head").get(1);
			} else {
				headerChildNode1 = headerNode.get("head").get(1);
				headerChildNode2 = headerNode.get("head").get(0);
			}

			AcroCommonApiResHeader acroCommonApiResHeader = new AcroCommonApiResHeader();
			acroCommonApiResHeader.setApiCode(apiCode);
			acroCommonApiResHeader.setApiName(AssemblyApiLists.findByApiCode(apiCode).apiName());
			acroCommonApiResHeader.setCode(headerChildNode2.get("RESULT").get("CODE").textValue());
			acroCommonApiResHeader.setMessage(headerChildNode2.get("RESULT").get("MESSAGE").textValue());
			acroCommonApiResHeader.setList_total_count(headerChildNode1.get("list_total_count").intValue());
			acroCommonApiRes.setHeader(acroCommonApiResHeader);

			// data
			Class<?> clazz = Class.forName(getDtoClassName(apiCode));
			List<?>  list  = objectMapper.convertValue(dataNode, TypeFactory.defaultInstance().constructCollectionType(List.class, clazz));
//			acroCommonApiRes.setData(list);

			// pagination
			buildPagination(acroCommonApiRes, paramMap);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return acroCommonApiRes;
	}

	private static String getDtoClassName(String apiCode) {
		return MessageFormat.format(AssemblyApiConstants.DTO_PATTERN, StringUtils.capitalize(apiCode));
	}

	private static void buildPagination(AcroCommonApiRes acroCommonApiRes, Map<String, String> paramMap) {

		int pSize  = Integer.parseInt(AssemblyApiConstants.API_PSIZE);
		int pIndex = 1;

		if (paramMap != null && paramMap.get("pIndex") != null) {
			pIndex = Integer.parseInt(paramMap.get("pIndex"));
		}

		AcroCommonApiResHeader acroCommonApiResHeader = acroCommonApiRes.getHeader();
		acroCommonApiResHeader.setPSize(pSize);
		acroCommonApiResHeader.setPIndex(pIndex);

		if (acroCommonApiResHeader.getList_total_count() > pSize * pIndex) {
			acroCommonApiResHeader.setHasNextPIndex(true);
			acroCommonApiResHeader.setNextPIndex(pIndex + 1);
		}
	}
}