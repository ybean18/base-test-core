package exam.test.core.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AcroCommonApiRes {

	private AcroCommonApiResHeader header;
	private AcroCommonApiResData   data;
	private AcroCommonApiResError  error;
}