package exam.test.core.common;

import java.util.List;

import exam.test.core.godata.api.dto.ResearchDetailDto.ContractList;
import exam.test.core.godata.api.dto.ResearchDetailDto.KoglList;
import exam.test.core.godata.api.dto.ResearchDetailDto.ResearchDetailList;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AcroCommonApiResHeader {

	private String  apiCode;
	private String  research;
	private String  apiName;
	private String  code;
	private String  message;
	private String  research_id;
	private int     list_total_count;
	private int     pSize;
	private int     pIndex;
	private int     nextPIndex;
	private boolean hasNextPIndex;
	
}