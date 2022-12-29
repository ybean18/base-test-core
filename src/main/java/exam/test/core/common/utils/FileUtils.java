package exam.test.core.common.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import exam.test.core.common.AcroCommonFileRes;
import exam.test.core.common.constants.AcroCommonConstants;
import lombok.val;
import reactor.core.publisher.Mono;

/**
 * <pre>
 * @Package : kr.co.ihopper.acro.core.common.utils
 * @fileName: FileUtils.java
 * </pre>
 * 
 * @Company : cginside
 * @Author  : User
 * @Date    : 2022. 5. 30. 오전 10:47:46
 * 
 */
public class FileUtils {

	/** 
	 * <pre>
	 * 간략 : fileDownLoadFromUrl(String url, String directory, String fileDiv, int fifleOno)
	 * 상세 : url, directory, fileDiv, fifleOno 를 입력 받아 파일테이블의 공통응답형식으로 반환
	 * </pre>
	 * @param url                : 파일을 다운로드 받을 URL 
	 * @param directory          : 2 Step 분류(IGP 개발가이드 20220525.pptx 10p 참조)
	 * @param fileDiv            : 공통코드 003 파일구분에 따른 분류
	 * @param fifleOno           : 파일순번(max+1)
	 * @return AcroCommonFileRes
	 */
	public static List<AcroCommonFileRes> fileDownLoadFromUrl(String url, String secondDirectory, String fileDiv, long fileOno, String fileKey) {

		List<AcroCommonFileRes> resultList = new ArrayList<AcroCommonFileRes>();

		String fileName    = "";
		String directory   = "";
		String newFileName = "";
		String location    = "";
		String arrUrls[]   = null;

		if (url.indexOf(",") > -1 && (url.replaceAll(" ","")).indexOf(",http") > -1 ) {
			arrUrls    = url.split(",");
		} else {
			arrUrls    = new String[1];
			arrUrls[0] = url;
		}

		for (String splitUrl:arrUrls) {
			AcroCommonFileRes result = new AcroCommonFileRes();

			ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
					.codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(-1)) // to unlimited memory size
					.build();

			WebClient client = WebClient.builder()
				.baseUrl(splitUrl)
				.exchangeStrategies(exchangeStrategies)
				.build();

			try {
				ResponseSpec responseSpec = client.get().retrieve();
				Mono<DataBuffer> dataBufferFlux = responseSpec.bodyToMono(DataBuffer.class);

				List<String> locations = responseSpec.toBodilessEntity().block().getHeaders().get(HttpHeaders.LOCATION);
				if (locations != null) {
					location = locations.toString();
				}

				if (location != null && !"".equals(location)) {
					location = location.replace("[", "").replace("]", "");
					result = fileDownload(splitUrl, location, secondDirectory, fileDiv, fileOno, fileKey);
					fileOno++;
					resultList.add(result);
				} else {
					fileName = getFileName(splitUrl, responseSpec);

					if (null != fileName && !"".equals(fileName)) {
						directory = filePathCombination(secondDirectory, fileDiv, fileName);
						File folder = new File(directory);

						// 폴더가 존재하지 않을경우 생성
						if (!folder.exists()) {
							try {
								folder.mkdirs();
							} catch (Exception e) {
								e.printStackTrace();
								// TODO: handle exception
							}
						}

						newFileName = getNewFileName(secondDirectory, fileDiv, fileName, fileOno, fileKey);
						String strPath = directory + "/" +newFileName;
						Path path = Paths.get(strPath);
						DataBufferUtils.write(dataBufferFlux, path, StandardOpenOption.CREATE).share().block();

						result.setFile_div(fileDiv);
						result.setOrgn_file_nm(fileName);
						result.setSave_file_nm(newFileName);
						result.setFile_save_path(directory);
						result.setFile_sply_path(splitUrl);
						result.setExt(getExtension(fileName));
						result.setFile_ono(fileOno);
						fileOno++;
						resultList.add(result);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return resultList;
	}

	public static AcroCommonFileRes fileDownload(String fileUrl, String url, String secondDirectory, String fileDiv, long fileOno, String fileKey) {
		AcroCommonFileRes result = new AcroCommonFileRes();

		String fileName    = "";
		String newFileName = "";
		String directory   = "";
		ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
				.codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(-1)) // to unlimited memory size
				.build();

		WebClient client = WebClient.builder()
			.baseUrl(url)
			.exchangeStrategies(exchangeStrategies)
			.build();

		try {
			ResponseSpec responseSpec = client.get().retrieve();
			Mono<DataBuffer> dataBufferFlux = responseSpec.bodyToMono(DataBuffer.class);
			fileName = getFileName(url, responseSpec);

			if (null != fileName && !"".equals(fileName)) {
				directory = filePathCombination(secondDirectory, fileDiv, fileName);

				File folder = new File(directory);

				// 폴더가 존재하지 않을경우 생성
				if (!folder.exists()) {
					try {
						folder.mkdirs();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				newFileName = getNewFileName(secondDirectory, fileDiv, fileName, fileOno, fileKey);
				String strPath = directory + "/" +newFileName;
				Path path = Paths.get(strPath);
				DataBufferUtils.write(dataBufferFlux, path, StandardOpenOption.CREATE).share().block();

			} else {
				throw new IOException();
			}

		} catch (Exception e) {

		}

		result.setFile_div(fileDiv);
		result.setOrgn_file_nm(fileName);
		result.setSave_file_nm(newFileName);
		result.setFile_save_path(directory);
		result.setFile_sply_path(fileUrl);
		result.setExt(getExtension(fileName));
		result.setFile_ono(fileOno);
		return result;
	}
	/** 
	 * <pre>
	 * 간략 : filePathCombination(String directory, String fileDiv, String fileName)
	 * 상세 : 입력받은 변수들을 조합하여 저장될 파일경로를 반환해준다
	 * </pre>
	 * @param directory : 2 Step의 분류
	 * @param fileDiv   : 3 Step의 파일구분
	 * @param fileName  : 파일명
	 * @return ihopper/files/입력받은경로/확장자명/현재년/현재월/현재일
	 */
	public static String filePathCombination(String directory, String fileDiv, String fileName) {

		String result = "";

		result = (new StringBuffer()).append(AcroCommonConstants.DEFAULT_FILE_PATH)
									 .append(directory)
									 .append("/")
									 .append(!"".equals(fileDiv) ? (fileDiv+ ("/")) : "").toString();

		return result;
	}

	/** 
	 * <pre>
	 * 간략 : getFileName(String url, ResponseSpec responseSpec)
	 * 상세 : 응답객체 헤더에서 파일명을 가져온다
	 * </pre>
	 * @param url          : URL에 파일명이 있을 경우 차선순위로 파일명 추출
	 * @param responseSpec : URL에 파일명이 없을 경우 우선으로 HEADER - CONTENT_DISPOSITION 에서 추출
	 * @return 추출된파일명
	 */
	public static String getFileName(String url, ResponseSpec responseSpec) {

		String fileName           = "";
		String contentDisposition = "";

		try {
			HttpHeaders headers = responseSpec.toBodilessEntity().block().getHeaders();
			ContentDisposition contentDispositionHeader =  headers.getContentDisposition();

			if (url.indexOf("https://clik.nanet.go.kr") > -1) {
				fileName = url.substring((url.indexOf("title=") + 6), url.indexOf("&query"));
				fileName = URLDecoder.decode(fileName, "UTF-8").replace("UTF-8''", "");
				fileName = URLDecoder.decode(fileName, "UTF-8").replace("UTF-8''", "");
				fileName = URLDecoder.decode(fileName, "UTF-8").replace("UTF-8''", "");
				fileName = fileName + url.substring(url.lastIndexOf(".") - 1, url.length());

				System.out.println("filename : " + fileName);
			} else {
				if (contentDispositionHeader != null) {
					contentDisposition = contentDispositionHeader.toString();

					// 자치법규처럼 Content-Dispostion을 못가져오는 케이스인경우 추가방어로직 적용
					if (contentDisposition.indexOf("filename") < 0 && contentDisposition.indexOf("fileName") < 0) {

						List<String> contentDispostionList = headers.get("Content-Disposition");

						if (contentDispostionList != null && contentDispostionList.size() > 0) {
							contentDisposition = contentDispostionList.get(0);
						}
					}

					for (String cd : contentDisposition.split(";", 2)) {

						if ((cd.replaceAll(" ","")).startsWith("fileName") || (cd.replaceAll(" ","")).startsWith("filename")) {
							fileName = cd.substring(cd.indexOf('=') + 1).replaceAll(" ","").replaceAll("\"", "");
							fileName = fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1);
							if (fileName.charAt(fileName.length()-1) == ']') {
								fileName = fileName.substring(0,fileName.length()-1);
							}
						}
					}
				}

				if (null == fileName || "".equals(fileName) || fileName.indexOf(".") < 0 ) {
					if (url.indexOf("filename") > 0 || url.indexOf("fileName") > 0) {
						String strUrl = url.substring((url.toLowerCase()).indexOf("filename"), url.length());
						fileName = strUrl.substring(strUrl.indexOf('=') + 1).replaceAll(" ","").replace("\"", "");
						fileName = fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1);
						if (fileName.charAt(fileName.length()-1) == ']') {
							fileName = fileName.substring(0,fileName.length()-1);
						}
					} else {
						val uri  = new URL(url);
						fileName = new File(uri.getPath()).getName();
					}
				}
			}

			// DB저장용 파일명, 여기서 파일명 생성해서 넣어 줄것, 한글 호환문제 발생 
			// 파일명에 'UTF-8' 문자 포함되어 들어오는 데이터 'UTF-8' 문자 제거
			fileName = URLDecoder.decode(fileName, "UTF-8").replace("UTF-8''", "");

		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

		if (url.indexOf("https://clik.nanet.go.kr") < 0) {
			String lastStr = fileName.substring(fileName.length() -1, fileName.length());
			if ( ";".equals(lastStr)) {
				fileName = fileName.substring(0, fileName.length() -1);
			}
		}

		return fileName;
	}

	/** 
	 * <pre>
	 * 간략 : getExtension(String fileName)
	 * 상세 : 입력받은 문자열에서 확장자를 추출한다.
	 * </pre>
	 * @param fileName : 확장자를 추출할 파일명.확장자
	 * @return 추출된 확장자명 
	 */
	public static String getExtension(String fileName) {
		String result = "";
		result = fileName.substring(fileName.lastIndexOf(".") + 1 , fileName.length());
		return result;
	}

	/** 
	 * <pre>
	 * 간략 : getNewFileName(String fileName)
	 * 상세 : 서버저장용 파일명 생성 yyyymmdd24miss 형식의 신규 파일명 생성 후 리턴
	 * </pre>
	 * @param fileName : 확장자를 추출하기 위한 파일명
	 * @return 신규생성된파일명
	 */
	public static String getNewFileName(String directory, String fileDiv, String fileName, long fileOno, String fileKey) {

		String result = "";
		try {

			directory = directory.replaceAll("/", "_");

			StringJoiner sj = new StringJoiner("_");

			if (fileDiv != null && !"".equals(fileDiv)) {

				// 인물사진인 경우 의원코드로만 파일명을 생성하도록 추가
				if ("mna".equals(directory) && "photo".equals(fileDiv)) {
					sj.add(fileName.substring(0, fileName.lastIndexOf(".")));

				} else {
					sj.add(directory)
					  .add(fileDiv)
					  .add(fileKey)
					  .add(String.valueOf(fileOno));
				}

			} else {
				sj.add(directory)
				  .add(fileKey)
				  .add(String.valueOf(fileOno));
			}

			result = sj.toString() +"." + getExtension(fileName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
}
