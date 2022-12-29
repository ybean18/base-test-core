package exam.test.core.assembly.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class NumwhtqhavaqssfleDto {

	@JsonProperty("REGDAESU")      private String age;              // 대수
	@JsonProperty("RE_TOPIC_NAME") private String field;            // 분야별
	@JsonProperty("RE_NAME")       private String rsch_ognzt;       // 연구단체
	@JsonProperty("RE_OBJECTIVE")  private String re_objective;     // 연구목적
	@JsonProperty("MAIN_MEM")      private String rpsnt_mona_nm;    // 대표의원
	@JsonProperty("RE_MEM")        private String rsch_leader_mona; // 연구책임의원
	@JsonProperty("OBJ_MEM")       private String cmps_mona;        // 구성의원
	@JsonProperty("MEMBER_CNT")    private String member_cnt;       // 구성인원
	@JsonProperty("LINK_URL")      private String link_url;         // 링크주소
	
	private String cncl_div;      // 의회구분
	private String rpsnt_mona_cd; // 대표의원코드
	private String kor_nm;        // 한글명
	private String age_cd;        // 대수코드
}