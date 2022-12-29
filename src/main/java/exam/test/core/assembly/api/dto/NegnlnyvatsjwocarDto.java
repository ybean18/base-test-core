package exam.test.core.assembly.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class NegnlnyvatsjwocarDto {

	@JsonProperty("HG_NM")   private String kor_nm;       // 이름
	@JsonProperty("T_URL")   private String twitter_url;  // 트위터 URL
	@JsonProperty("F_URL")   private String facebook_url; // 페이스북 URL
	@JsonProperty("Y_URL")   private String youtube_url;  // 유튜브 URL
	@JsonProperty("B_URL")   private String blog_url;     // 블로그 URL
	@JsonProperty("MONA_CD") private String mona_cd;      // 국회의원코드
}