package exam.test.core.assembly.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 국회의원 인적사항
@Getter
@Setter
@ToString
public class NwvrqwxyaytdsfvhuDto {

	@JsonProperty("HG_NM")        private String kor_nm;              // 이름
	@JsonProperty("HJ_NM")        private String chn_nm;              // 한자명
	@JsonProperty("ENG_NM")       private String eng_nm;              // 영문명칭
	@JsonProperty("BTH_GBN_NM")   private String cov_birthday_div_nm; // 음/양력
	@JsonProperty("BTH_DATE")     private String birthday;            // 생년월일
	@JsonProperty("JOB_RES_NM")   private String job_res_nm;          // 직책명
	@JsonProperty("POLY_NM")      private String cov_pparty_nm;       // 정당명
	@JsonProperty("ORIG_NM")      private String elctdist;            // 선거구
	@JsonProperty("ELECT_GBN_NM") private String elctdist_div;        // 선거구구분
	@JsonProperty("CMIT_NM")      private String cov_cmte_nm;         // 대표위원회명
	@JsonProperty("CMITS")        private String cmits;               // 소속위원회목록
	@JsonProperty("REELE_GBN_NM") private String ree_yn;              // 재선
	@JsonProperty("UNITS")        private String units;               // 당선
	@JsonProperty("SEX_GBN_NM")   private String cov_gender_nm;       // 성별
	@JsonProperty("TEL_NO")       private String tel_no;              // 전화번호
	@JsonProperty("E_MAIL")       private String email;               // 이메일
	@JsonProperty("HOMEPAGE")     private String home_page;           // 홈페이지
	@JsonProperty("STAFF")        private String aide;                // 보좌관
	@JsonProperty("SECRETARY")    private String scof;                // 비서관
	@JsonProperty("SECRETARY2")   private String secre;               // 비서
	@JsonProperty("MONA_CD")      private String mona_cd;             // 국회의원코드
	@JsonProperty("MEM_TITLE")    private String profile;             // 약력
	@JsonProperty("ASSEM_ADDR")   private String office_rmno;         // 사무실호실

	private String eno;                 // 선수
	private String age_cd;              // 대수코드
	private String cncl_div;            // 의회구분
	private String cov_pparty_cd;       // 정당코드
	private String cov_cmte_no;         // 대표위원회번호
	private String cov_birthday_div_cd; // 음/양력
	private String cov_gender_cd;       // 성별
	private String kywd;                // 키워드
	private long   kywd_ono;            // 키워드번호

}