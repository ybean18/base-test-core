package exam.test.core.assembly.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class NyioaasianxlkcqxsDto {

	@JsonProperty("ARTICLE_TITLE") private String ttle;       // 제목
	@JsonProperty("CATEGORY_NM")   private String age_nm;     // 대수명
	@JsonProperty("ETC_CHAR7")     private String kor_nm;     // 국회의원명
	@JsonProperty("ETC_CHAR12")    private String host_place; // 개최장소
	@JsonProperty("LINK_URL")      private String detl_url;   // 상세보기URL
	@JsonProperty("ETC_CHAR1")     private String host_dt;    // 개최일
	@JsonProperty("ETC_CHAR2")     private String host_tm;    // 개최시
	
	private String mona_cd;   // 의원코드
	private String host_dttm; // 개최일시
	private String age_cd;    // 대수코드
}