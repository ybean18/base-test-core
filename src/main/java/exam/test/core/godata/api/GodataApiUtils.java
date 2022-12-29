package exam.test.core.godata.api;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
import exam.test.core.common.AcroCommonApiResData;
import exam.test.core.common.AcroCommonApiResError;
import exam.test.core.common.AcroCommonApiResHeader;
import exam.test.core.godata.api.dto.ResearchDetailDto;
import reactor.core.publisher.Mono;

public class GodataApiUtils {

	public static MultiValueMap<String, String> buildQueryParams(Map<String, String> paramMap) {

		MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();

		// app default params
		for (Entry<String, String> item : GodataApiConstants.API_DEFAULT_PARAM_MAP.entrySet()) {
			queryParams.add(item.getKey(), item.getValue());
		}

		// add api params
		for (Entry<String, String> item : paramMap.entrySet()) {

			if (queryParams.get(item.getKey()) == null) {

				try {
					queryParams.add(item.getKey(), URLEncoder.encode(item.getValue(), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// ignore
				}

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

		JsonNode  researchNode       = null;
		JsonNode  researchDetailNode = null;
		JsonNode  contractNode   = null;
		JsonNode  reportInfoNode = null;
		JsonNode  useNode        = null;
		JsonNode  koglNode       = null;
		JsonNode  researchIdNode = null;
		
		JsonNode  headerNode = null;
		JsonNode  errorNode = null;
		JsonNode  errorMsgNode           = null;
		JsonNode  errorCdNode           = null;
		
		
		ArrayNode researchArrayNode   = null;
		ArrayNode reportInfoArrayNode = null;
		ArrayNode useArrayNode        = null;
		
		Map<String,String> researchDetailMap = null;
		Map<String,String> contractMap = null;
		Map<String,String> KoglMap = null;

		ArrayList use = null;
		ArrayList repo = null;

		try {
			try {

			//error
			if(objectMapper.readTree(body).get("<cmmMsgHeader>") != null) {

				AcroCommonApiResError acroCommonApiError = new AcroCommonApiResError();
				if(errorMsgNode != null) {
					errorMsgNode   = objectMapper.readTree(body).get("returnAuthMsg");
					acroCommonApiError.setCode(errorCdNode.textValue());
					}

					if(errorCdNode != null) {
					errorCdNode   = objectMapper.readTree(body).get("returnReasonCode");
					acroCommonApiError.setMessage(errorMsgNode.textValue());
					}

				acroCommonApiRes.setError(acroCommonApiError);

				return acroCommonApiRes;

			}

			if(objectMapper.readTree(body).get("research_id")!=null) {
				researchIdNode  = objectMapper.readTree(body).get("research_id");
				}

			if(objectMapper.readTree(body).get("research")!= null) {
				if(objectMapper.readTree(body).get("research").isArray()) {
					researchNode   = objectMapper.readTree(body).get("research");
					researchArrayNode   = (ArrayNode) researchNode;
				}else {
				researchDetailNode = objectMapper.readTree(body).get("research");
				researchDetailMap = objectMapper.convertValue(researchDetailNode, Map.class);
				}
			}

			if(objectMapper.readTree(body).get("contract")!=null) {
				contractNode   = objectMapper.readTree(body).get("contract");
				contractMap = objectMapper.convertValue(contractNode, Map.class);
				researchDetailMap.putAll(contractMap);
			}

			if(objectMapper.readTree(body).get("kogl")!= null) {
				if(objectMapper.readTree(body).get("kogl").textValue() == null) {
					koglNode       = objectMapper.readTree(body).get("kogl");
					KoglMap = objectMapper.convertValue(koglNode, Map.class);
					researchDetailMap.putAll(KoglMap);
				}
			}

			if(objectMapper.readTree(body).get("reportInfo")!=null) {
				reportInfoNode = objectMapper.readTree(body).get("reportInfo").get("url");
					if(reportInfoNode != null) {
						if(reportInfoNode.isArray()) {
							reportInfoArrayNode = (ArrayNode) reportInfoNode;
							repo = objectMapper.convertValue(reportInfoArrayNode, ArrayList.class);
							}
						}
					
					if(objectMapper.readTree(body).get("use")!= null ) {
						useNode        = objectMapper.readTree(body).get("use");
						if(useNode.isArray()) {
						useArrayNode        = (ArrayNode) useNode;
						use = objectMapper.convertValue(useArrayNode, ArrayList.class);
						repo.addAll(use);
						}
					}
					
			}else {
				if(objectMapper.readTree(body).get("use")!= null ) {
					useNode        = objectMapper.readTree(body).get("use");
					if(useNode.isArray()) {
					useArrayNode        = (ArrayNode) useNode;
					repo = objectMapper.convertValue(useArrayNode, ArrayList.class);
//					repo.addAll(use);
						}
					}
			}





			headerNode     = objectMapper.readTree(body).get("totalCount");

			}catch(Exception e){
				e.printStackTrace();
			}

			



			
			
			// header
			AcroCommonApiResHeader acroCommonApiResHeader = new AcroCommonApiResHeader();
			acroCommonApiResHeader.setApiCode(apiCode);
			acroCommonApiResHeader.setApiName(GodataApiLists.findByApiCode(apiCode).apiName());
			if(headerNode != null) {
			acroCommonApiResHeader.setList_total_count(headerNode.intValue());
			}
			acroCommonApiRes.setHeader(acroCommonApiResHeader);

			// data
			AcroCommonApiResData acroCommonApiResData = new AcroCommonApiResData();
			Class<?> clazz = Class.forName(getDtoClassName(apiCode));
			List<?>            researchList       = objectMapper.convertValue(researchArrayNode, TypeFactory.defaultInstance().constructCollectionType(List.class, clazz));
			List<?>            researchFileList   = objectMapper.convertValue(repo, TypeFactory.defaultInstance().constructCollectionType(List.class,clazz));
			ResearchDetailDto  researchDetailList = objectMapper.convertValue(researchDetailMap, TypeFactory.defaultInstance().constructType(ResearchDetailDto.class));

			if(researchIdNode != null) {
			acroCommonApiResData.setResearch_id(researchIdNode.textValue());
			}
			acroCommonApiResData.setResearchList(researchList);			acroCommonApiResData.setResearchDetailDto(researchDetailList);			acroCommonApiResData.setResearchFileList(researchFileList);
			acroCommonApiRes.setData(acroCommonApiResData);

			// pagination
			buildPagination(acroCommonApiRes, paramMap);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return acroCommonApiRes;
	}

	private static String getDtoClassName(String apiCode) {
		return MessageFormat.format(GodataApiConstants.DTO_PATTERN, StringUtils.capitalize(apiCode.replace("get", "")));
	}

	private static void buildPagination(AcroCommonApiRes acroCommonApiRes, Map<String, String> paramMap) {

		int pSize  = Integer.parseInt(GodataApiConstants.API_PSIZE);
		int pIndex = 1;

		if (paramMap != null && paramMap.get("pageNo") != null) {
			pIndex = Integer.parseInt(paramMap.get("pageNo"));
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