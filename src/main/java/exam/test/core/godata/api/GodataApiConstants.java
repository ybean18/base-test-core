package exam.test.core.godata.api;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GodataApiConstants {

	public static final String API_URL                = "http://apis.data.go.kr/";
	public static final String API_KEY                = "rXWKtbUrLS341ctG94RUK5c1ui25OhFH9y1e5qXgdMWQOJOPM7MdJ0BnMiCAxSraj8LhBFbn8mSlTmVDzzX8Zg%3D%3D";         // TO-BE
//	public static final String API_KEY                = "qif4QNTh7KnVrrctBGKAE%2BAVxWCWgBOqVa7XSWz5TSJelHw%2FFCMqoyQiK%2FScX2B9%2F1OoubiiAJ7jJVVOorUkmQ%3D%3D"; // AS-IS
	public static final String API_PINDEX             = "1";
	public static final String API_PSIZE              = "1000";
	public static final String API_STARTDATE          = "";
	public static final String API_ENDDATE            = "";
	public static final String API_RESEARCHID         = "";
	public static final int    API_MAX_IN_MEMORY_SIZE = 1024 * 1024 * 16;

	public static final String DTO_PATTERN = "exam.test.core.godata.api.dto.{0}Dto";

	public static final Map<String, String> API_DEFAULT_PARAM_MAP = Collections.unmodifiableMap(new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put("serviceKey", API_KEY);
			put("pageNo",     API_PINDEX);
			put("numOfRows",  API_PSIZE);
			put("start_date", API_STARTDATE);
			put("end_date",   API_ENDDATE);
			put("research_id",API_RESEARCHID);
			
		}
	});
}