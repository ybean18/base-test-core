package exam.test.core.assembly.api;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AssemblyApiConstants {

	public static final String API_URL                = "https://open.assembly.go.kr/portal/openapi";
	public static final String API_KEY                = "341005d066434a8a915c4d0772d8fc65";
	public static final String API_TYPE               = "json";
	public static final String API_PINDEX             = "1";
	public static final String API_PSIZE              = "100";
	public static final int    API_MAX_IN_MEMORY_SIZE = 1024 * 1024 * 16;

	public static final String DTO_PATTERN = "kr.co.ihopper.acro.core.assembly.api.dto.{0}Dto";

	public static final Map<String, String> API_DEFAULT_PARAM_MAP = Collections.unmodifiableMap(new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put("KEY",    API_KEY);
			put("Type",   API_TYPE);
			put("pIndex", API_PINDEX);
			put("pSize",  API_PSIZE);
		}
	});
}