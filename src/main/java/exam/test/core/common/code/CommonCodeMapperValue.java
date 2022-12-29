package exam.test.core.common.code;

import lombok.Getter;

@Getter
public class CommonCodeMapperValue {
	private String comCd;
	private String comCdNm;
	
	public CommonCodeMapperValue(CommonCodeMapperType commonCodeMapperType) {
		comCd = commonCodeMapperType.comCd();
		comCdNm = commonCodeMapperType.comCdNm();
	}

}