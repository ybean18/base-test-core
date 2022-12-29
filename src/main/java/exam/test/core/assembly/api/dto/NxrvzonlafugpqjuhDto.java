package exam.test.core.assembly.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class NxrvzonlafugpqjuhDto {

	@JsonProperty("CMT_DIV_CD")     private String cmt_div_cd;     // 위원회구분코드
	@JsonProperty("CMT_DIV_NM")     private String cmt_div_nm;     // 위원회구분
	@JsonProperty("HR_DEPT_CD")     private String cmte_cd   ;     // 위원회코드
	@JsonProperty("COMMITTEE_NAME") private String cov_cmte_nm;    // 위원회
	@JsonProperty("HG_NM")          private String kor_nm;         // 위원장
	@JsonProperty("HG_NM_LIST")     private String kor_nm_list;    // 간사
	@JsonProperty("LIMIT_CNT")      private String limit_cnt;      // 위원정수
	@JsonProperty("CURR_CNT")       private String curr_cnt;       // 현원
	@JsonProperty("POLY99_CNT")     private String poly99_cnt;     // 비교섭단체위원수
	@JsonProperty("POLY_CNT")       private String poly_cnt;       // 교섭단체위원수
	
	private String position_div;  // 포지션구분
	private String cov_cmte_no;   // 위원회번호
	private String mona_cd;       // 국회의원코드
	private String cov_pparty_cd; // 정당코드
	private String cov_pparty_nm; // 정당명
}