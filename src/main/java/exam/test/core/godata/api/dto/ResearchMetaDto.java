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
public class ResearchMetaDto {

		@JsonProperty("numOfRows")  private String numOfRows;
		@JsonProperty("pageNo")     private String pageNo;
		@JsonProperty("totalCount") private String totalCount;
		@JsonProperty("start_date") private String start_date;
		@JsonProperty("end_date")   private String end_date;
		@JsonProperty("resultMsg")  private String resultMsg;
		@JsonProperty("resultCode") private String resultCode;

		@JsonProperty("reportInfo") private List<ReportInfoList> reportInfoList;

	@Getter
	@Setter
	@ToString
	public static class ReportInfoList{

		// 여기만 변경
		@JsonProperty("research_id")              private String research_id;    // 연구ID
		@JsonProperty("issued_year")              private String issued_yy;      // 발행년도
		@JsonProperty("report_open_yn")           private String report_open_yn; // 원문공개여부

	}
}