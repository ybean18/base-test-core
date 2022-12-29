package exam.test.core.assembly.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class NhedurlwawoquyxwnDto {

	@JsonProperty("SCHEDULEDATE") private String dt;   // 일자
	@JsonProperty("SCHEDULETIME") private String tm;   // 시간
	@JsonProperty("CONTENTS")     private String cont; // 내용

	private String cncl_div;     // 의회구분
	private String sch_ono;      // 일정순번
}