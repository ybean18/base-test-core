package exam.test.core.assembly.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 역대 국회 선거일, 의원정수, 임기정보
@Getter
@Setter
@ToString
public class NokivirranikoinnkDto {

	@JsonProperty("ERACO")        private String age;              // 대수
	@JsonProperty("GCL_ELEC_DIV") private String age_elctdist_div; // 대별선거구분
	@JsonProperty("ELEC_DE")      private String elct_dt;          // 선거일
	@JsonProperty("ASBLM_PSNUM")  private String mona_fno;         // 의원정수
	@JsonProperty("TERM_BG")      private String stm_sta_dt;       // 임기시작
	@JsonProperty("TERM_ED")      private String stm_end_dt;       // 임기종료
	@JsonProperty("PROD")         private String term;             // 기간
	@JsonProperty("RMK")          private String rmrk;             // 비고

	private String age_cd;      //대수코드
	private String age_nm;      //대수명
	private String pub_data_cd; //공공데이터코드
}