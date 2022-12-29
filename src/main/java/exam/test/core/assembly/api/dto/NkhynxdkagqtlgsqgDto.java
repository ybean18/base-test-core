package exam.test.core.assembly.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class NkhynxdkagqtlgsqgDto {

	@JsonProperty("WRITE_DATE")   private String wrt_dt;        // 작성일
	@JsonProperty("NOTICE_TITLE") private String ttle;          // 제목
	@JsonProperty("DEPT_NAME")    private String dept_nm;       // 부서명
	@JsonProperty("NOTICE_NM")    private String div_nm;        // 구분명
	@JsonProperty("PDF_FILE_URL") private String atch_file_url; // 첨부파일url
	@JsonProperty("CONTENT")      private String cont;          // 내용

	private String cncl_div;       // 의회구분
	private String sch_ono;        // 일정순번
}