package exam.test.core.assembly.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NyzrglyvagmrypezqDto {

	@JsonProperty("HG_NM")           private String kor_nm;     // 의원이름(한글)
	@JsonProperty("HJ_NM")           private String chn_nm;     // 의원이름(한자)
	@JsonProperty("FRTO_DATE")       private String ftro_date;  // 활동기간
	@JsonProperty("PROFILE_SJ")      private String profile_sj; // 위원회 경력
	@JsonProperty("MONA_CD")         private String mona_cd;    // 국회의원코드
	@JsonProperty("PROFILE_UNIT_CD") private String age_cd;     // 경력대수코드
	@JsonProperty("PROFILE_UNIT_NM") private String age_nm;     // 경력대수

	private String cncl_div;    // 의회구분
	private String sta_dt;      // 경력시작일자
	private String end_dt;      // 경력종료일자
	private String cov_cmte_nm; // 위원회명
	private String cov_cmte_no; // 위원회번호
	private String cmte_dvd;    // 위원회구분
	private String cmte_cd;     // 위원회코드
	private String cmte_eng_nm; // 위원회영문명
	
	
}
