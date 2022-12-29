package exam.test.core.assembly.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class NneiozjtawpqhaidqDto {

	@JsonProperty("ARTICLE_TITLE") private String ttle;           // 제목
	@JsonProperty("DT")            private String dttm;           // 일시
	@JsonProperty("ETC_CHAR11")    private String place;          // 장소
	@JsonProperty("ARTICLE_TEXT")  private String cont;           // 내용
	@JsonProperty("LINK_URL")      private String lnk_url;        // 연결url
	@JsonProperty("ATTACH_URL")    private String atch_file_url;  // 첨부파일url
	@JsonProperty("CATEGORY_NM")   private String div_nm;         // 구분명

	private String cncl_div;    // 의회구분
	private String event_ono;   // 행사순번
}