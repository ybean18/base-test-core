package exam.test.opensearch.core.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exam.test.opensearch.core.api.dto.OpensearchApiReq;

public class OpensearchApiUtils {

	@SuppressWarnings("unchecked")
	public static void convertBillFilter(OpensearchApiReq opensearchApiReq, Map<String, Object> filterMap) {

		if (filterMap == null) {
			return;
		}

		// 제안자구분
		if ((List<String>) filterMap.get("ppse_mna_div_list") != null && ((List<String>) filterMap.get("ppse_mna_div_list")).size() > 0) {

			List<String> ppse_mna_div_list = new ArrayList<>();
			ppse_mna_div_list = (List<String>) filterMap.get("ppse_mna_div_list");

			// 제안자
			for (int i = 0; i < ppse_mna_div_list.size(); i++) {

				if ("G01".equals(ppse_mna_div_list.get(i))) {

					// 대표발의의 경우 의안기준 공동발의이므로 치환한다.
					ppse_mna_div_list.set(i, "G03");
					opensearchApiReq.setPpsr((String) filterMap.get("ppse_kor_nm"));

				} else if ("G02".equals(ppse_mna_div_list.get(i))) {
					opensearchApiReq.setPpsr((String) filterMap.get("ppse_kor_nm"));

				} else if ("G03".equals(ppse_mna_div_list.get(i))) {
					opensearchApiReq.setCo_ppsr((String) filterMap.get("ppse_kor_nm"));
				}
			}

			// 제안구분
			opensearchApiReq.setSgtn_div(ppse_mna_div_list);

		} else {

			// 제안구분
			opensearchApiReq.setSgtn_div((List<String>) filterMap.get("ppse_mna_div_list"));

			// 제안자
			opensearchApiReq.setCo_ppsr((String) filterMap.get("ppse_kor_nm"));
		}

		// 제안대수
		if (filterMap.get("ppse_age") != null && ((List<String>) filterMap.get("ppse_age")).size() > 0) {
			opensearchApiReq.setPpse_age(new HashMap<String, Object>());
			opensearchApiReq.getPpse_age().put("start", ((List<String>) filterMap.get("ppse_age")).get(0));
			opensearchApiReq.getPpse_age().put("end",   ((List<String>) filterMap.get("ppse_age")).get(0));
		}

		// 본회의 처리회기
		opensearchApiReq.setDcd_pno(new HashMap<String, Object>());
		opensearchApiReq.getDcd_pno().put("start", (String) filterMap.get("pnion_sta_pno"));
		opensearchApiReq.getDcd_pno().put("end",   (String) filterMap.get("pnion_end_pno"));

		// 본회의 처리일자
		opensearchApiReq.setDcd_dt(new HashMap<String, Object>());
		opensearchApiReq.getDcd_dt().put("start", (String) filterMap.get("pnion_sta_dt"));
		opensearchApiReq.getDcd_dt().put("end",   (String) filterMap.get("pnion_end_dt"));

		// 제안회기
		opensearchApiReq.setPpse_pno(new HashMap<String, Object>());
		opensearchApiReq.getPpse_pno().put("start", (String) filterMap.get("ppse_sta_pno"));
		opensearchApiReq.getPpse_pno().put("end",   (String) filterMap.get("ppse_end_pno"));

		// 제안일자
		opensearchApiReq.setPpse_dt(new HashMap<String, Object>());
		opensearchApiReq.getPpse_dt().put("start", (String) filterMap.get("ppse_sta_dt"));
		opensearchApiReq.getPpse_dt().put("end",   (String) filterMap.get("ppse_end_dt"));

		// 회부일자
		opensearchApiReq.setCmte_send_dt(new HashMap<String, Object>());
		opensearchApiReq.getCmte_send_dt().put("start", (String) filterMap.get("wdrw_sta_dt"));
		opensearchApiReq.getCmte_send_dt().put("end",   (String) filterMap.get("wdrw_end_dt"));

		// 회의일자 (현재 요건 없음)

		// 의안종류
		if ("bsBill".equals((String)filterMap.get("menu_path"))) {

			if ((List<String>) filterMap.get("bill_type") == null || ((List<String>) filterMap.get("bill_type")).size() == 0) {

				List<String> billTypeList = new ArrayList<>(); 
				billTypeList.add("B02"); // 예산안
				billTypeList.add("B03"); // 결산
				
				opensearchApiReq.setBill_type(billTypeList);
			} else {
				opensearchApiReq.setBill_type(((List<String>) filterMap.get("bill_type")));
			}

		} else {
			opensearchApiReq.setBill_type(((List<String>) filterMap.get("bill_type")));
		}

		// 의안진행상태
		opensearchApiReq.setProg_stat((List<String>) filterMap.get("exm_prog_stat_list"));

		// 소관위원회
		opensearchApiReq.setJdt_cmte_no((List<String>) filterMap.get("cmte_no_list"));

		// 제안종류
		opensearchApiReq.setPpsr_div((List<String>) filterMap.get("ppse_div_list"));

		// 본회의처리결과
		opensearchApiReq.setDcd_rslt((List<String>) filterMap.get("pnion_rslt_list"));

		// 소관위처리결과
		opensearchApiReq.setCmte_proc_rslt((List<String>) filterMap.get("cmte_rslt_list"));

		// 비용추계서유무
		if (filterMap.get("csd_div_list") != null && ((List<String>) filterMap.get("csd_div_list")).size() > 0) {
			opensearchApiReq.setCsd_div(((List<String>) filterMap.get("csd_div_list")).get(0));
		}

		// 본회의 수정안 여부
		if (filterMap.get("pnion_amdmt_yn") != null) {
			boolean pnion_amdmt_yn = (boolean)filterMap.get("pnion_amdmt_yn");
			
			if (pnion_amdmt_yn) {
				opensearchApiReq.setAmdmt_dt(String.valueOf(pnion_amdmt_yn));
			}
		}

		// 분석의안여부
		if (filterMap.get("analyzed_bill") != null) {
			boolean analyzed_bill_yn = (boolean)filterMap.get("analyzed_bill");
			
			if (analyzed_bill_yn) {
				opensearchApiReq.setAnalyzed_bill(String.valueOf(analyzed_bill_yn));
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static void convertMnaFilter(OpensearchApiReq opensearchApiReq, Map<String, Object> filterMap) {

		if (filterMap == null) {
			return;
		}

		// 제안대수
		opensearchApiReq.setHistory(((List<String>) filterMap.get("ppse_age")).get(0));
		
		// 정당코드
		if (filterMap.get("pparty_list") != null && ((List<String>) filterMap.get("pparty_list")).size() > 0) {
			opensearchApiReq.setPparty_cd(((List<String>) filterMap.get("pparty_list")).get(0));
		}

		// 선수
		if (filterMap.get("eno_list") != null && ((List<String>) filterMap.get("eno_list")).size() > 0) {
			String eno = ((List<String>) filterMap.get("eno_list")).get(0);
			opensearchApiReq.setEno(eno.substring(5));
		}

		// 선거구구분
		if (filterMap.get("eno_div_list") != null && ((List<String>) filterMap.get("eno_div_list")).size() > 0) {
			String eno_div = ((List<String>) filterMap.get("eno_div_list")).get(0);

			if ("021011".equals(eno_div)) {
				eno_div = "지역구";

			} else if ("021017".equals(eno_div)) {
				eno_div = "비례대표";
			
			} else if ("021018".equals(eno_div)) {
				eno_div = "전국구";

			} else if ("021019".equals(eno_div)) {
				eno_div = "통일주체국민회의";
			}

			opensearchApiReq.setElctdist_div(eno_div);
		}

		// 위원회번호
		opensearchApiReq.setCmte_no((List<String>) filterMap.get("cmte_no_list"));
	}

	@SuppressWarnings("unchecked")
	public static void convertNewsFilter(OpensearchApiReq opensearchApiReq, Map<String, Object> filterMap) {

		if (filterMap == null) {
			return;
		}

		// 언론사코드
		opensearchApiReq.setMcom_cd((List<String>) filterMap.get("mcom_cd_list"));
		
		// 분류코드
		opensearchApiReq.setCategory((List<String>) filterMap.get("category_list"));

		// 발행일자
		opensearchApiReq.setIssu_dt((String) filterMap.get("issu_dt"));
	}
	
	
	public static void convertRelatedNewsFilter(OpensearchApiReq opensearchApiReq, Map<String, Object> filterMap) {

		if (filterMap == null) {
			return;
		}

		// 의원이름
		if (filterMap.get("name") != null) {
			opensearchApiReq.setName((String)filterMap.get("name"));
		}

		// 날짜
		if (filterMap.get("date") != null) {
			opensearchApiReq.setDate((String)filterMap.get("date"));
		}

		// 요청 검색 결과 크기
		if (filterMap.get("size") != null) {
			opensearchApiReq.setSize(Long.parseLong(filterMap.get("size").toString()));
		} else {
			opensearchApiReq.setSize(20);
		}

		// 요청 검색 시작 위치
		if (filterMap.get("start") != null) {
			opensearchApiReq.setStart(Long.parseLong(filterMap.get("start").toString()));
		} else {
			opensearchApiReq.setStart(0);
		}
	}

	public static void convertRelatedBillNewsFilter(OpensearchApiReq opensearchApiReq, Map<String, Object> filterMap) {

		if (filterMap == null) {
			return;
		}

		// 요청 검색 결과 크기
		if (filterMap.get("size") != null) {
			opensearchApiReq.setSize(Long.parseLong(filterMap.get("size").toString()));
		} else {
			opensearchApiReq.setSize(20);
		}

		// 요청 검색 시작 위치
		if (filterMap.get("start") != null) {
			opensearchApiReq.setStart(Long.parseLong(filterMap.get("start").toString()));
		} else {
			opensearchApiReq.setStart(0);
		}

		// 대표발의자명
		if (filterMap.get("ppsr") != null) {
			opensearchApiReq.setPpsr((String)filterMap.get("ppsr"));
		}

		// 의안명
		if (filterMap.get("law_nm") != null) {
			opensearchApiReq.setLaw_nm((String)filterMap.get("law_nm"));
		}
	}

	public static void convertRelatedSocialFilter(OpensearchApiReq opensearchApiReq, Map<String, Object> filterMap) {

		if (filterMap == null) {
			return;
		}

		// 요청 검색 시작 위치
		if (filterMap.get("date_range") != null) {
			opensearchApiReq.setDate_range((String)filterMap.get("date_range"));
		}

		// 인물명
		if (filterMap.get("people_nm") != null) {
			opensearchApiReq.setPeople_nm((String)filterMap.get("people_nm"));
		}

		// 의안명
		if (filterMap.get("law_nm") != null) {
			opensearchApiReq.setLaw_nm((String)filterMap.get("law_nm"));
		}
	}

	@SuppressWarnings("unchecked")
	public static void convertPrcFilter(OpensearchApiReq opensearchApiReq, Map<String, Object> filterMap) {

		if (filterMap == null) {
			return;
		}

		if (filterMap.get("mt_type") != null) {
			opensearchApiReq.setMt_type((String)filterMap.get("mt_type"));
		}

		// 제안대수
		opensearchApiReq.setAge_cd(new HashMap<String, Object>());
		if (filterMap.get("sta_age_cd") != null) {
			opensearchApiReq.getAge_cd().put("start", (String) filterMap.get("sta_age_cd"));
		}
		if (filterMap.get("end_age_cd") != null) {
			opensearchApiReq.getAge_cd().put("end",   (String) filterMap.get("end_age_cd"));
		}

		// 회기코드
		opensearchApiReq.setPno_cd(new HashMap<String, Object>());
		if (filterMap.get("sta_pno_cd") != null) {
			opensearchApiReq.getPno_cd().put("start", (String) filterMap.get("sta_pno_cd"));
		}
		if (filterMap.get("end_pno_cd") != null) {
			opensearchApiReq.getPno_cd().put("end",   (String) filterMap.get("end_pno_cd"));
		}
		// 위원회번호
		if (filterMap.get("cmte_no") != null) {
			opensearchApiReq.setPrc_cmte_no((String)filterMap.get("cmte_no"));
		}
		// 요청 검색 결과 크기
//		if (filterMap.get("size") != null) {
//			opensearchApiReq.setSize(Long.parseLong(filterMap.get("size").toString()));
//		} else {
//			opensearchApiReq.setSize(10);
//		}
	}

	@SuppressWarnings("unchecked")
	public static void convertRptFilter(OpensearchApiReq opensearchApiReq, Map<String, Object> filterMap) {

		if (filterMap == null) {
			return;
		}

		if(filterMap.get("policy_div_list") != null & ( (List<String>) filterMap.get("policy_div_list")).size() > 0) {
			opensearchApiReq.setPolicy_div((List<String>) filterMap.get("policy_div_list"));
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void convertLawFilter(OpensearchApiReq opensearchApiReq, Map<String, Object> filterMap) {

		if (filterMap == null) {
			return;
		}

		if(filterMap.get("tol_div_list") != null & ( (List<String>) filterMap.get("tol_div_list")).size() > 0) {
			opensearchApiReq.setTol_div_cd((List<String>) filterMap.get("tol_div_list"));
		}
		if(filterMap.get("dept_no_list") != null & ( (List<String>) filterMap.get("dept_no_list")).size() > 0) {
			opensearchApiReq.setDept_no((List<String>) filterMap.get("dept_no_list"));
		}
	}
}