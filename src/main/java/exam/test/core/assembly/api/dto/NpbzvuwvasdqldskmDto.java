package exam.test.core.assembly.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class NpbzvuwvasdqldskmDto {

	@JsonProperty("TAKING_DATE") private String intv_dt;  // 회견일
	@JsonProperty("OPEN_TIME")   private String intv_tm;  // 회견시각
	@JsonProperty("TITLE")       private String ttle;     // 제목
	@JsonProperty("PERSON")      private String speaker;  // 발언자
	@JsonProperty("REC_TIME")    private String play_tm;  // 재생시간
	@JsonProperty("LINK_URL")    private String link_url; // 영상 바로보기

	private String cncl_div; // 의회구분
	private String age_cd;   // 대수코드
	private long   ono;      // 순번
}