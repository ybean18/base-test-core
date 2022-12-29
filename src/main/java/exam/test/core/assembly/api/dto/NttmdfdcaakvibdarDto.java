package exam.test.core.assembly.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class NttmdfdcaakvibdarDto {

	@JsonProperty("UNIT_CD")        private String age_cd;         // 대수코드
	@JsonProperty("HR_DEPT_CD")     private String cmte_cd;        // 위원회코드
	@JsonProperty("SESS")           private String pno_cd;         // 회기코드
	@JsonProperty("TITLE")          private String mt_sch_div;     // 회의일정구분
	@JsonProperty("DEGREE")         private String tno;            // 차수
	@JsonProperty("MEETING_DATE")   private String mt_dt;          // 회의일자
	@JsonProperty("MEETING_TIME")   private String mt_tm;          // 회의시간
	@JsonProperty("LINK_URL2")      private String detl_url;       // 상세_URL
	@JsonProperty("COMMITTEE_NAME") private String cov_cmte_nm;    // 위원회명
	@JsonProperty("UNIT_NM")        private String unit_nm;        // 

	private String cncl_div;       // 의회구분
	private String sch_ono;        // 일정순번
	private String ttle;           // 제목
	private String cov_cmte_no;
	private String cmte_no;
}	