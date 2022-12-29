package exam.test.core.assembly.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class NmfcjtvmajsbhhckfDto {

	@JsonProperty("TITLE")           private String ttle;           // 제목
	@JsonProperty("PUBLISHER")       private String issu_plce;      // 발행처
	@JsonProperty("DETAIL_VIEW_URL") private String detl_sight_url; // 상세보기URL
	@JsonProperty("UPDATE_DT")       private String upd_dttm;       // 수정일
	@JsonProperty("PUBLISH_DT")      private String issu_yyyy;      // 발행년
	
	private String cncl_div;      // 의회구분
	private String age_cd;        // 대수코드
	private long   ono;           // 순번
	private String rept_div;      // 보고서구분
	private long   age;           // 대수
	private String issu_start_dt; // 발행년시작일자
}