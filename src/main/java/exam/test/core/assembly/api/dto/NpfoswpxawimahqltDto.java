package exam.test.core.assembly.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class NpfoswpxawimahqltDto {

	@JsonProperty("ARTICLE_TITLE") private String ttle;            // 제목
	@JsonProperty("RE_DT")         private String watch_rsrv_term; // 관람예약
	@JsonProperty("DT")            private String dttm;            // 일시
	@JsonProperty("ETC_CHAR11")    private String place;           // 장소
	@JsonProperty("LINK_URL")      private String lnk_url;         // 연결url

	private String cncl_div;    // 의회구분
	private String sch_ono;     // 일정순번
	private String perf_div;    // 공연구분
}