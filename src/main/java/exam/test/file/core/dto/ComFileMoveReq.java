package exam.test.file.core.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ComFileMoveReq {

	private String srcFileName;
	private String dstFilePath;
	private String dstFileName;
}