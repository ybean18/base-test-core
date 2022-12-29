package exam.test.core.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AcroCommonFileRes {
	private String file_div;        // 파일구분
	private long   file_ono;        // 파일순번
	private String file_sply_path;  // 파일제공경로
	private String file_save_path;  // 파일저장경로
	private String orgn_file_nm;    // 원본파일명
	private String save_file_nm;    // 저장파일명
	private String ext;             // 확장자
}
