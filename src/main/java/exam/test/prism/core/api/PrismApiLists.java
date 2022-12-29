package exam.test.prism.core.api;

import java.util.Arrays;

public enum PrismApiLists {

	RESEARCHLIST("1741000","prism","getResearchList", "행정안전부_정책연구 과제정보 > 정책연구 기관별 과제 목록");
	
	private final String serviceCode;
	private final String serviceName;
	private final String apiCode;
	private final String apiName;

	PrismApiLists(String serviceCode, String serviceName, String apiCode, String apiName) {
		this.serviceCode = serviceCode;
		this.serviceName = serviceName;
		this.apiCode = apiCode;
		this.apiName = apiName;
	}
	
	public String serviceCode() {
		return this.serviceCode;
	}

	public String serviceName() {
		return this.serviceName;
	}
	public String apiCode() {
		return this.apiCode;
	}

	public String apiName() {
		return this.apiName;
	}

	public static PrismApiLists findByApiCode(String apiCode) {
		return Arrays.stream(values())
				.filter(value -> value.apiCode.equals(apiCode))
				.findAny()
				.orElse(null);
	}
}