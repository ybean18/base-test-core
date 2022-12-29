package exam.test.core.assembly.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class NcrwiahparxrpodcvDto {

	@JsonProperty("REGDAESU")                 private String regdaesu;                 // 대수
	@JsonProperty("REPORT_TITLE")             private String report_title;             // 보고서명
	@JsonProperty("YEAR")                     private String year;                     // 연도
	@JsonProperty("RE_NAME")                  private String re_name;                  // 연구단체명
	@JsonProperty("PDF_DOWN_URL")             private String pdf_down_url;             // PDF_DOWN_URL
	@JsonProperty("REPORT_CLASSIFICATION_NM") private String report_classification_nm; // 보고서분류
}