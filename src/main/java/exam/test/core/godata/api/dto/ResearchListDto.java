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
public class ResearchListDto {

		@JsonProperty("research_id")              private String research_id;    // 연구ID
		@JsonProperty("research_name")            private String research_name;    // 연구ID
		@JsonProperty("organ_name")               private String organ_name;    // 연구ID
		@JsonProperty("researcher_name")          private String researcher_name;    // 연구ID
		@JsonProperty("charge_person_department") private String charge_person_department;    // 연구ID
		@JsonProperty("biz_name")                 private String biz_name;    // 연구ID
		@JsonProperty("research_date")            private String research_date;    // 연구ID

		@JsonProperty("issued_year")              private String issued_yy;      // 발행년도
		@JsonProperty("report_open_yn")           private String report_open_yn; // 원문공개여부
		@JsonProperty("research")                 private List<ResearchList> researchList;

	@Getter
	@Setter
	@ToString
	public static class ResearchList{

		// 여기만 변경
		@JsonProperty("research_id")              private String research_id;    // 연구ID
		@JsonProperty("issued_year")              private String issued_yy;      // 발행년도
		@JsonProperty("report_open_yn")           private String report_open_yn; // 원문공개여부

	}

	private List<AcroCommonFileRes> fileList;
}