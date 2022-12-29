package exam.test.core.assembly.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class NktulghcadyhmiqxiDto {

	@JsonProperty("DEPT_CD")     private String cmte_cd;     // 위원회코드
	@JsonProperty("DEPT_NM")     private String cov_cmte_nm; // 위원회명
	@JsonProperty("JOB_RES_NM")  private String job_res_nm;  // 구성
	@JsonProperty("HG_NM")       private String kor_nm;      // 위원명
	@JsonProperty("ORIG_NM")     private String elctdist;    // 선거구
	@JsonProperty("POLY_NM")     private String poly_nm;     // 정당
	@JsonProperty("ASSEM_TEL")   private String tel_no;      // 전화번호
	@JsonProperty("ASSEM_EMAIL") private String email;       // 이메일
	@JsonProperty("HJ_NM")       private String chn_nm;      // 위원명(한자)
	@JsonProperty("ROOM_NO")     private String room_no;     // 호실
	@JsonProperty("STAFF")       private String aide;        // 보좌관
	@JsonProperty("SECRETARY")   private String scof;        // 비서관
	@JsonProperty("SECRETARY2")  private String secre;       // 비서
	@JsonProperty("MONA_CD")     private String mona_cd;     // 국회의원코드

	private String cov_cmte_no;  // 위원회번호
	private String position_div; // 포지션구분
}