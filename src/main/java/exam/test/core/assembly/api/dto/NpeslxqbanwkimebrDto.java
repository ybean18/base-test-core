package exam.test.core.assembly.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class NpeslxqbanwkimebrDto {

	@JsonProperty("CT1")              private String age;     // 대수
	@JsonProperty("CT2")              private String pno_cd;  // 회
	@JsonProperty("CT3")              private String tno;     // 차
	@JsonProperty("TAKING_DATE")      private String mt_dt;   // 회의일자
	@JsonProperty("TITLE")            private String mt_ttle; // 회의제목
	@JsonProperty("ESSENTIAL_PERSON") private String speaker; // 발언자
	@JsonProperty("REC_TIME")         private String play_tm; // 재생시간
	@JsonProperty("LINK_URL")         private String lnk_url; // 링크주소

	private String cncl_div; // 의회구분
	private String age_cd;   // 대수코드
	private long   ono;      // 순번	
}