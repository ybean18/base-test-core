package exam.test.core.common.code;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum CommonCodeLists implements CommonCodeMapperType {
	
	C001_01("01", "의정보고서"),
	C001_02("02", "정책자료집");
	
	private final String comCd;
	private final String comCdNm;
	private static final Map<String, String> CODE_MAP = Collections.unmodifiableMap(
			Stream.of(values()).collect(Collectors.toMap(CommonCodeLists::name, CommonCodeLists::name)));

	CommonCodeLists(String comCd, String comCdNm) {
		this.comCd = comCd;
		this.comCdNm = comCdNm;
	}

	@Override
	public String comCd() {
		return this.comCd;
	}

	@Override
	public String comCdNm() {
		return this.comCdNm;
	}

	public static CommonCodeLists findByComCd(String comCd) {
		return Arrays.stream(values())
				.filter(value -> value.comCd.equals(comCd))
				.findAny()
				.orElse(null);
	}
	
	public static CommonCodeLists of(final String catCd) {
		return CommonCodeLists.valueOf(CODE_MAP.get(catCd));
	}
	
//	public boolean check(String code){
//		return cdList.stream().anyMatch(cdList -> cdList.equals(code));
//	}

}