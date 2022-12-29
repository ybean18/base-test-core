package exam.test.core.assembly.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class NekcaiymatialqlxrDto {

	@JsonProperty("MEETINGSESSION") private String pno_cd;  // 회기
	@JsonProperty("CHA")            private String tno;     // 차수
	@JsonProperty("TITLE")          private String ttle;    // 제목
	@JsonProperty("MEETTING_DATE")  private String dt;      // 일자
	@JsonProperty("MEETTING_TIME")  private String tm;      // 일시
	@JsonProperty("LINK_URL")       private String lnk_url; // 링크주소
	@JsonProperty("UNIT_CD")        private String age_cd;  // 대수
	@JsonProperty("UNIT_NM")        private String unit_nm; //

	private String    cncl_div;   // 의회구분
	private String    del_yn;     // 삭제여부
	private String    dttm;       // 일시
}