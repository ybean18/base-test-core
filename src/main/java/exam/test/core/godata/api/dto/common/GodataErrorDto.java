package exam.test.core.godata.api.dto.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GodataErrorDto {

	private GodataErrorHeaderDto godataErrorHeaderDto;

	@Getter
	@Setter
	@ToString
	public static class GodataErrorHeaderDto {
		private String errMsg;
		private String returnAuthMsg;
		private String returnReasonCode;
	}
}