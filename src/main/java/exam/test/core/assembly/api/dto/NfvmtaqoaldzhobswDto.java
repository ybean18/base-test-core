package exam.test.core.assembly.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class NfvmtaqoaldzhobswDto {

	@JsonProperty("RPT_NO")    private String rpt_no;    // 다운로드
	@JsonProperty("YEAR")      private String yyyy;      // 년도
	@JsonProperty("FILE_ID")   private String file_id;   // 파일ID
	@JsonProperty("RPT_TITLE") private String rept_ttle; // 보고서제목
	@JsonProperty("RG_DE")     private String reg_dt;    // 등록일
	@JsonProperty("UNIT_CD")   private String age_cd;    // 대별코드
	@JsonProperty("UNIT_NM")   private String age_nm;    // 대
	@JsonProperty("ASBLM_NM")  private String kor_nm;    // 의원명
	@JsonProperty("QUARTER")   private String qutr;      // 분기
	@JsonProperty("DIV_NM")    private String div_nm;    // 구분명
	
	private String mona_cd;  // 의원코드
	private String cncl_div; // 의회구분
}