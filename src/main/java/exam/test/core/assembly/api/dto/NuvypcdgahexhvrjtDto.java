package exam.test.core.assembly.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class NuvypcdgahexhvrjtDto {

	@JsonProperty("DAE_NUM")    private String age;            // 대수
	@JsonProperty("SES_NUM")    private String pno_cd;         // 회기
	@JsonProperty("DEGREE_NUM") private String tno;            // 차수
	@JsonProperty("COMM_NAME")  private String cov_cmte_nm;    // 위원회
	@JsonProperty("CONF_DATE")  private String mt_dt;          // 회의일
	@JsonProperty("BILL_URL")   private String item_sight_url; // 안건보기
	@JsonProperty("CLASS_NAME") private String mt_type;        // 회의종류

	private String cncl_div;    // 의회구분
	private String age_cd;      // 대수코드
	private long   ono;         // 순번
	private String cov_cmte_no; // 위원회번호
	private String mona_no;     // 의원번호
	private String cmte_cd;     // 위원회코드
	private String cmte_eng_nm; // 위원회영문명
}