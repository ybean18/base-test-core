package exam.test.core.assembly.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class NfcoioopazrwmjrgsDto {

	@JsonProperty("TITLE")       private String ttle;           // 제목
	@JsonProperty("LINK")        private String monarm_url;     // 의원실링크
	@JsonProperty("DESCRIPTION") private String expl;           // 설명
	@JsonProperty("SDATE")       private String host_dt;        // 개최일
	@JsonProperty("STIME")       private String host_tm;        // 개최시간
	@JsonProperty("NAME")        private String host_org;       // 주최기관
	@JsonProperty("LOCATION")    private String host_place;     // 개최장소

	private String cncl_div;       // 의회구분
	private String seminar_ono;        // 일정순번
	private String cov_cmte_no;
	private String cmte_no;
	private String age_cd;
}