package exam.test.prism.core.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PrismApiRes {

	@JsonProperty("numOfRows")  private String numOfRows;
	@JsonProperty("pageNo")     private String pageNo;
	@JsonProperty("totalCount") private String totalCount;
	@JsonProperty("start_date") private String start_date;
	@JsonProperty("end_date")   private String end_date;
	@JsonProperty("resultMsg")   private String resultMsg;
	@JsonProperty("resultCode")   private String resultCode;

	@JsonProperty("research") private List<ResearchListItem> researchList;

@Getter
@Setter
@ToString
public static class ResearchListItem {

	// 여기만 변경
	@JsonProperty("research_id")              private String research_id;              // 과제ID
	@JsonProperty("research_name")            private String research_name;            // 과제명
	@JsonProperty("organ_name")               private String organ_name;               // 기관명
	@JsonProperty("researcher_name")          private String researcher_name;          // 책임연구원
	@JsonProperty("charge_person_department") private String charge_person_department; // 담당부서
	@JsonProperty("biz_name")                 private String biz_name;                 // 주제
	@JsonProperty("research_date")            private String research_date;            // 사업연도
	@JsonProperty("issued_year")              private String issued_year;              // 발행연도
	@JsonProperty("report_open_yn")           private String report_open_yn;           // 원문공개여부
	@JsonProperty("super_biz_name")           private String super_biz_name;           // 정부 분류

}
}