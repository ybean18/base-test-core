package exam.test.core.assembly.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 국회의원 인적사항
@Getter
@Setter
@ToString
public class NfzegpkvaclgtscxtDto {

	@JsonProperty("HG_NM")           private String kor_nm;    // 의원이름(한글)
	@JsonProperty("HJ_NM")           private String chn_nm;    // 의원이름(한자)
	@JsonProperty("FRTO_DATE")       private String act_term;  // 활동기간
	@JsonProperty("PROFILE_SJ")      private String mona_hist; // 의원이력
	@JsonProperty("MONA_CD")         private String mona_cd;   // 국회의원코드
	@JsonProperty("PROFILE_UNIT_CD") private String age_cd;    // 대수코드
	@JsonProperty("PROFILE_UNIT_NM") private String age_nm;    // 대수
	
	private String start_dt; // 활동기간 시작일자
	private String end_dt;   // 활동기간 종료일자
	private long   hist_ono; // 이력순번
}