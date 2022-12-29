package exam.test.core.assembly.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class NojepdqqaweusdfbiDto {

	@JsonProperty("HG_NM")             private String hg_nm;             // 의원
	@JsonProperty("HJ_NM")             private String hj_nm;             // 한자명
	@JsonProperty("POLY_NM")           private String poly_nm;           // 정당
	@JsonProperty("ORIG_NM")           private String orig_nm;           // 선거구
	@JsonProperty("MEMBER_NO")         private String mona_no;           // 의원번호
	@JsonProperty("POLY_CD")           private String poly_cd;           // 소속정당코드
	@JsonProperty("ORIG_CD")           private String orig_cd;           // 선거구코드
	@JsonProperty("VOTE_DATE")         private String dcd_dt;            // 의결일자
	@JsonProperty("BILL_NO")           private String bill_no;           // 의안번호
	@JsonProperty("BILL_NAME")         private String bill_name;         // 의안명
	@JsonProperty("BILL_ID")           private String bill_id;           // 의안ID
	@JsonProperty("LAW_TITLE")         private String law_title;         // 법률명
	@JsonProperty("CURR_COMMITTEE")    private String curr_committee;    // 소관위원회
	@JsonProperty("RESULT_VOTE_MOD")   private String vote_rslt;         // 표결결과
	@JsonProperty("DEPT_CD")           private String dept_cd;           // 부서코드(사용안함)
	@JsonProperty("CURR_COMMITTEE_ID") private String curr_committee_id; // 소관위코드
	@JsonProperty("DISP_ORDER")        private String disp_order;        // 표시정렬순서
	@JsonProperty("BILL_URL")          private String bill_url;          // 의안URL
	@JsonProperty("BILL_NAME_URL")     private String bill_name_url;     // 의안링크
	@JsonProperty("SESSION_CD")        private String session_cd;        // 회기
	@JsonProperty("CURRENTS_CD")       private String currents_cd;       // 차수
	@JsonProperty("AGE")               private String age;               // 대수
	@JsonProperty("MONA_CD")           private String mona_cd;           // 국회의원코드

	private String abil_apply_dscd_bill_list; // 대안반영폐기의안목록
}