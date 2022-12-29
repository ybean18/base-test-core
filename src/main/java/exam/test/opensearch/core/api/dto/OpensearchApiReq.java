package exam.test.opensearch.core.api.dto;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OpensearchApiReq {

	// 공통
	private long   start; // 요청 검색 시작 위치
	private long   size;  // 요청 검색 결과 크기
	private String sort;  // 검색 정렬 기준(정확도순 : accuracy, 최신순 : recency, 가나다순 : alphabet)
	private String query; // 검색 결과 수

	// 의안
	private String              ppsr;           // 제안자(대표발의,1인발의)
	private String              co_ppsr;        // 제안자(공동발의)
	private List<String>        sgtn_div;       // 제안자발의구분
	private Map<String, Object> ppse_age;       // 제안대수
	private Map<String, Object> dcd_pno;        // 본회의 처리회기
	private Map<String, Object> dcd_dt;         // 본회의 처리일자
	private Map<String, Object> ppse_pno;       // 제안회기
	private Map<String, Object> ppse_dt;        // 제안일자
	private Map<String, Object> cmte_send_dt;   // 회부일자
	private Map<String, Object> cmte_proc_dt;   // 소관위회의일자
	private List<String>        cmte_proc_rslt; // 소관위회의결과
	private List<String>        bill_type;      // 의안종류
	private List<String>        prog_stat;      // 의안진행상태
	private List<String>        jdt_cmte_no;    // 소관위원회
	private List<String>        ppsr_div;       // 제안종류
	private List<String>        dcd_rslt;       // 본회의 처리결과
	private String              csd_div;        // 비용추계서유무
	private String              amdmt_dt;       // 본회의 수정안 여부
	private String              analyzed_bill;  // 분석의안여부

	// 인물
	private String              history;        // 대수
	private String              pparty_cd;      // 정당코드
	private String              eno;            // 선수
	private String              elctdist_div;   // 선거구구분
	private List<String>        cmte_no;        // 위원회번호

	// 뉴스
	private List<String>        mcom_cd;        // 언론사코드
	private List<String>        category;       // 분류코드
	private String              issu_dt;        // 발행일자
	
	// 인물관련 뉴스
	private String              name;           // 검색 인물
	private String              date;           // 해당 날짜
	
	// 의안관련 뉴스
	private String              law_nm;         // 의안명
	
	// 소셜데이터 검색
	private String              people_nm;      // 인물명
	private String              date_range;     // 검색시간기간(1d, 1w, 1M, 미포함시 전체)
	
	// 회의록 검색
	private String              mt_type;        // 회의구분
	private Map<String, Object> age_cd;         // 대수코드
	private Map<String, Object> pno_cd;         // 회기코드
	private String              prc_cmte_no;    // 위원회번호

	// 정책데이터 검색
	private List<String>        policy_div;     // 정책구분
	
	// 법령데이터 검색
	private List<String>        tol_div_cd;  // 법종구분
	private List<String>        dept_no;     // 부처번호
}