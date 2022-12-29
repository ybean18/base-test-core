package exam.test.core.common;

import java.util.List;

import exam.test.core.godata.api.dto.ResearchDetailDto;
import exam.test.core.godata.api.dto.ResearchDetailDto.ContractList;
import exam.test.core.godata.api.dto.ResearchDetailDto.KoglList;
import exam.test.core.godata.api.dto.ResearchDetailDto.ResearchDetailList;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AcroCommonApiResData {

	private List<?> researchList;
	private ResearchDetailList researchDetailList;
	private ContractList contractList;
	private ResearchDetailDto researchDetailDto;
	private List<?> useList;
	private List<?> repoInfoList;
	private KoglList koglList;
	private String research_id;
	private List<?> researchFileList;
}