package exam.test.core.assembly.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import exam.test.core.common.AcroCommonFileRes;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class NyapimeoaczouxzhbDto {

	@JsonProperty ("PDFFILEURL") private String detl_url;   // PDF파일URL
	@JsonProperty ("VIEWERURL")  private String viewer_url; // 뷰어URL
	@JsonProperty ("BOOKNM")     private String ttle;       // 자료명
	@JsonProperty ("INSERTDT")   private String reg_dt;     // 등록일자

	private String policy_div;      // 정책구분
	private long   policy_ono;      // 정책순번
	private String data_collect_no; // 데이터수집번호
	private String data_id;         // 데이터ID
	private String div_cd;          // 구분코드
	private String div_nm;          // 구분명
	private String rsch_ognzt_nm;   // 연구단체명
	private String dept_nm;         // 부서명
	private String field;           // 분야
	private String issu_plce;       // 발행처
	private String author;          // 저자
	private String publisher;       // 출판사
	private String planner;         // 기획자
	private String pannel;          // 패널
	private String cncl_div;        // 의회구분
	private String age_cd;          // 대수코드
	private String qutr;            // 분기
	private String org_cd;          // 기관코드
	private String org_nm;          // 기관명
	private String upd_dt;          // 수정일자
	private String issu_yyyy;       // 발행년도
	private String pbct_dt;         // 발간일자
	private String host_dt;         // 개최일자
	private String rsch_act_yyyy;   // 연구활동년도
	private String rsch_leader;     // 연구 책임자  
	private String wrt_dt;          // 작성일

	private List<AcroCommonFileRes> fileList;

}