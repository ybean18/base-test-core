package exam.test.core.assembly.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class NbqbmccpamsvwebknDto {

	@JsonProperty("TITLE")            private String ttle;            // 제목
	@JsonProperty("SEMINAR_DIV_CODE") private String div;             // 구분
	@JsonProperty("HOST_DT")          private String host_dttm;       // 개최일시
	@JsonProperty("HOST_PLACE_NAME")  private String place;           // 장소
	@JsonProperty("HOST_INS_NAME")    private String host;            // 주최
	@JsonProperty("ATTENDANCE_NAME1") private String prstn_pers;      // 발제자
	@JsonProperty("ATTENDANCE_NAME2") private String dscsn_pers;      // 토론자
	@JsonProperty("DETAIL_VIEW_URL")  private String detl_sight_url;  // 상세보기URL
	
	private String cncl_div;      // 의회구분
	private String age_cd;        // 대수코드
	private long   ono;           // 순번
	private String host_start_dt; // 개최일자
}