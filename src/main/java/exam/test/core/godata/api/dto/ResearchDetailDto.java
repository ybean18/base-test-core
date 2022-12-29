package exam.test.core.godata.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import exam.test.core.common.AcroCommonFileRes;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResearchDetailDto {

		@JsonProperty("research_id") private String research_id;            // 연구ID

		                                          private String file_div;       // 파일구분코드
		                                          private int    file_ono;       // 파일순번
		@JsonProperty("file_type")                private String file_div_nm;    // 파일구분명
		@JsonProperty("file_url")                 private String file_sply_path; // 파일제공경로
		                                          private String file_save_path; // 파일저장경로
		@JsonProperty("file_size")                private String file_size;  // 원본파일명
		@JsonProperty("file_name")                private String orgn_file_nm;  // 원본파일명
		                                          private String save_file_nm;   // 저장파일명
		                                          private String ext;            // 확장자
//		@JsonProperty("resultCode")   private String resultCode;    // 연구ID
//		@JsonProperty("resultMsg")   private String resultMsg;    // 연구ID
//
//		
//		@JsonProperty("research")   private ResearchDetailList researchDetailList;
//		@JsonProperty("contract")   private ContractList contractList;
//		@JsonProperty("url") 		private List<?> reportInfoList;
//		@JsonProperty("use")        private UseList useList;
//		@JsonProperty("kogl")       private KoglList koglList;

		@JsonProperty("research_name")            private String research_nm;            // 연구명
		@JsonProperty("research_start_date")      private String research_sta_dt;        // 연구시작일자
		@JsonProperty("research_end_date")        private String research_end_dt;        // 연구종료일자
		@JsonProperty("issued_year")              private String issued_yy;              // 발행년도
		@JsonProperty("report_open_yn")           private String report_open_yn;         // 원문공개여부
		@JsonProperty("organ_name")               private String charge_organ_nm;        // 담당기관명
		@JsonProperty("charge_person_department") private String charge_dept_nm;         // 담당부서명
		@JsonProperty("charge_person_phoneNo")    private String charge_tel_no;          // 담당전화번호
		@JsonProperty("brm_biz_id")               private String biz_category_id;        // 주제
		@JsonProperty("brm_biz_name")             private String biz_category_nm;        // 사업연도
		@JsonProperty("research_outline")         private String research_outline_cont;  // 연구개요
		@JsonProperty("research_organ_id")        private String contract_organ_id;      // 계약기관ID
		@JsonProperty("research_organ_type_name") private String contract_organ_nm;      // 계약기관명
		@JsonProperty("researcher_name")          private String contract_researcher_nm; // 계약수행연구원명
		@JsonProperty("contract_date")            private String contract_dt;            // 계약일자
		@JsonProperty("contract_type_name")       private String contract_type_nm;       // 계약방식명
		@JsonProperty("contract_cost")            private String    contract_amt;           // 계약금액
		@JsonProperty("kogl_open_yn")             private String kogl_open_yn;           // 공공누리동의여부
		@JsonProperty("kogl_content")             private String kogl_cont;              // 공공누리정보내용
		
	@Getter
	@Setter
	@ToString
	public static class ResearchDetailList{

		// 여기만 변경
		@JsonProperty("research_name")            private String research_nm;            // 연구명
		@JsonProperty("research_start_date")      private String research_sta_dt;        // 연구시작일자
		@JsonProperty("research_end_date")        private String research_end_dt;        // 연구종료일자
		@JsonProperty("organ_name")               private String charge_organ_nm;        // 담당기관명
		@JsonProperty("charge_person_department") private String charge_dept_nm;         // 담당부서명
		@JsonProperty("charge_person_phoneNo")    private String charge_tel_no;          // 담당전화번호
		@JsonProperty("brm_biz_id")               private String biz_category_id;        // 주제
		@JsonProperty("brm_biz_name")             private String biz_category_nm;        // 사업연도
		@JsonProperty("research_outline")         private String research_outline_cont;  // 연구개요

	}
	
	@Getter
	@Setter
	@ToString
	public static class ContractList{

		// 여기만 변경
		@JsonProperty("research_id")              private String research_id;            // 연구ID
		@JsonProperty("research_organ_id")        private String contract_organ_id;    // 연구ID
		@JsonProperty("research_organ_type_name") private String contract_organ_nm;      // 발행년도
		@JsonProperty("researcher_name")          private String contract_researcher_nm; // 원문공개여부
		@JsonProperty("contract_date")            private String contract_dt; // 원문공개여부
		@JsonProperty("contract_type_name")       private String contract_type_nm; // 원문공개여부
		@JsonProperty("contract_cost")            private String contract_amt; // 원문공개여부

	}
	
	@Getter
	@Setter
	@ToString
	public static class ReportInfoList{
		@JsonProperty("research_id")              private String research_id;            // 연구ID
			@JsonProperty("file_url")  private String file_sply_path;    // 연구ID
			@JsonProperty("file_type") private String file_div_nm;    // 연구ID
			@JsonProperty("file_name") private String organ_file_nm;    // 연구ID
			@JsonProperty("file_size") private String file_size;    // 연구ID

	}
	
	@Getter
	@Setter
	@ToString
	public static class UseList{
		@JsonProperty("research_id")              private String research_id;            // 연구ID
		@JsonProperty("file_url")  private String file_sply_path;    // 연구ID
		@JsonProperty("file_type") private String file_div_nm;    // 연구ID
		@JsonProperty("file_name") private String organ_file_nm;    // 연구ID
		@JsonProperty("file_size") private String file_size;    // 연구ID

	}
	
	@Getter
	@Setter
	@ToString
	public static class KoglList{

		// 여기만 변경
		@JsonProperty("research_id")              private String research_id;            // 연구ID
		@JsonProperty("kogl_open_yn")             private String kogl_open_yn;           // 공공누리동의여부
		@JsonProperty("kogl_content")             private String kogl_cont;              // 공공누리정보내용

	}

	@Getter
	@Setter
	@ToString
	public static class ResearchFileList{

		// 여기만 변경
		@JsonProperty("research_id")              private String research_id;    // 연구ID
		                                          private String file_div;       // 파일구분코드
		                                          private int    file_ono;       // 파일순번
		@JsonProperty("file_type")                private String file_div_nm;    // 파일구분명
		@JsonProperty("file_url")                 private String file_sply_path; // 파일제공경로
		                                          private String file_save_path; // 파일저장경로
		@JsonProperty("file_name")                private String orgn_file_nm;  // 원본파일명
		                                          private String save_file_nm;   // 저장파일명
		                                          private String ext;            // 확장자
		@JsonProperty("file_size")                private String file_size;  // 원본파일명
	}

	private List<AcroCommonFileRes> fileList;
}