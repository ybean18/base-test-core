package exam.test.opensearch.core.api.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OpensearchApiRes {

	private String           search_time;  // 검색 소요시간
	private String           start;        // 요청 검색 시작 위치
	private String           size;         // 요청 검색 결과 크기
	private String           total_counts; // 검색 결과 수
	private List<Hit>        hits;         // 검색결과목록
	private List<AllMnaNews> data;         // 오늘의인물검색결과목록

	@Getter
	@Setter
	@ToString
	public static class Hit {

		private String index; // 인덱스명 (igp_bill, igp_news, igp_mna)
		private String id;    // 문서 ID (bill_id, news_id, mona_cd 대응)
		private Data   data;  // 검색결과데이터

		private String policy_div; // 정책구분
		private String policy_ono; // 정책순번
	}

	@Getter
	@Setter
	@ToString
	public static class Data {

		private String       ttle;             // 의안, 뉴스 제목 (의안명, 뉴스제목, 법령명, 회의명, 정책명, 입법예고명)
		private String       txt;              // 의안, 뉴스 본문
		private String       bill_no;          // 의안 의안 번호
		private String       bill_type;        // 의안 분류
		private String       ppsr;             // 의안 제안자명
		private String       ppse_dt;          // 의안 제안일자
		private String       prog_stat;        // 의안 의안진행상태
		private String       pcmt_dt;          // 의안 의안 공포일자
		private String       pcmt_no;          // 의안 공포번호
		private String       jdt_cmte_no;      // 의안 소관위원회
		private String       anal_rslt_cd;     // 의안 아폴로 예측결과
		private String       dcd_rslt;         // 본회의 결과(의결)
		private String       rptr_nm;          // 뉴스 기자명
		private String       mcom_cd;          // 뉴스 언론사코드
		private String       issu_dttm;        // 뉴스 발행일자
		private List<String> category;         // 뉴스 뉴스 카테고리 리스트
		private String       kor_nm;           // 인물 한글이름
		private String       chn_nm;           // 인물 한자이름
		private String       eno;              // 인물 선수
		private String       elctdist;         // 인물 선거구
		private List<String> history;          // 인물 대수이력
		private String       pparty_cd;        // 인물 정당코드
		private String       pparty_nm;        // 인물 정당명
		private String       pic_save_path;    // 인물 의원 사진 저장경로
		private String       ppse_bill_cnt;    // 인물 대표발의안 건수
		private String       cmte_nm;          // 인물 소속위원회
		private String       imptt_dt;         // 법령 시행일자
		private String       tol_div;          // 법령 법종구분
		private String       srevision_div_nm; // 법령 제개정구분
		private List<String> dept_nm_list;     // 법령 소관부처 리스트
		private String       mt_type;          // 회의록 회의구분
		private String       mt_dt;            // 회의록 회의일자
		private String       video_prcd_url;   // 회의록 영상회의록 링크
		private String       apdx_url;         // 부록 링크
		private String       prsv_apdx_url;    // 보존부록 링크
		private List<String> files;            // 파일 목록
		private String       policy_div;       // 정책(보고서) 정책구분
		private String       policy_ono;       // 정책(보고서) 정책순번
		private String       wrt_dt;           // 정책(보고서) 작성일자
		private String       policy_div_nm;    // 정책(보고서) 정책구분명
		private String       viewer_url;       // 정책(보고서) 페이지 링크
		private List<String> file_save_path;   // 정책(보고서) 파일저장경로
		private List<String> file_save_path_list; // 정책(보고서) 파일저장경로
		private String       law_lgst_form;    // 입법예고 입법 범위
		private String       dept_nm;          // 입법예고 소관부처
		private String       end_dt;           // 입법예고 종료일자
		private String       sta_dt;           // 입법예고 시작일자
		private String       ancm_dt;          // 입법예고 공고일자
		private String       ancm_no;          // 입법예고 공고번호
	}

	@Getter
	@Setter
	@ToString
	public static class AllMnaNews {

		private String mona_cd;    // 의원코드
		private String news_count; // 기사량
	}
}