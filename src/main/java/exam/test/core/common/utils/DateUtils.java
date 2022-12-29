package exam.test.core.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * <pre>
 * @Package : kr.co.ihopper.acro.core.common.utils
 * @fileName: DateUtils.java
 * </pre>
 * 
 * @Company : cginside
 * @Author  : User
 * @Date    : 2022. 5. 30. 오전 10:48:02
 * 
 */

@Component
public class DateUtils {

	/** 
	 * <pre>
	 * 간략 : getToday(String pattern)
	 * 상세 : 오늘 날짜를 입력받은 (패턴)을 적용하여 반환 
	 * </pre>
	 * @param pattern : 년월일구분 pattern "" 허용 
	 * @return 입력받은 패턴이 적용된 오늘날짜 yyyyMMdd
	 */
	public String getToday(String pattern) {

		Date date_of_today = new Date();

		SimpleDateFormat format = new SimpleDateFormat("yyyy" + pattern + "MM" + pattern + "dd");

		String today= format.format(date_of_today);

		return today;
	}
	
	/** 
	 * <pre>
	 * 간략 : getFormatDate(String date)
	 * 상세 : 입력받은 날짜를 입력받은 Pattern으로 변환하여 리턴한다. 
	 * </pre>
	 * @param date    : 일자 ex)20220822 
	 *        pattern : 년월일구분 pattern "" 허용 
	 * @return dateFormat
	 */
	public String getFormatDate(String date, String pattern) {

		String dateFormat = "";

		if (date == null || !StringUtils.hasText(date) || date.length() != 8) {
			return date;
		}

		SimpleDateFormat preformat = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat format    = new SimpleDateFormat("yyyy" + pattern + "MM" + pattern + "dd");

		try {

			Date d = preformat.parse(date);

			dateFormat = format.format(d);

		} catch (Exception e) {

			return date;
		}

		return dateFormat;
	}
	
	/** 
	 * <pre>
	 * 간략 : getFormatDttm(String  dttm)
	 * 상세 : 입력받은 일시를 YYYY-MM-DD HH:MM 형태로 리턴한다. 
	 * </pre>
	 * @param dttm    : 일시 ex)202208221400 
	 * @return dttmFormat
	 */
	public String getFormatDttm(String dttm) {

		String dttmFormat = "";

		if (dttm == null || !StringUtils.hasText(dttm) || dttm.length() != 12) {
			return dttm;
		}

		SimpleDateFormat preformat = new SimpleDateFormat("yyyyMMddHHmm");
		SimpleDateFormat format    = new SimpleDateFormat("yyyy-MM-dd hh:mm");

		try {

			Date date = preformat.parse(dttm);

			dttmFormat = format.format(date);

		} catch (Exception e) {

			return dttm;
		}

		return dttmFormat;
	}

	/** 
	 * <pre>
	 * 간략 : getTodayNow()
	 * 상세 : 현재 년월일시분초를 문자열로 반환
	 * </pre>
	 * @return 현재 년월일시분초
	 */
	public String getTodayNow() {

		Date date_of_today = new Date();

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");

		String todayNow = format.format(date_of_today);

		return todayNow;
	}
	
	/** 
	 * <pre>
	 * 간략 : getTodayNowDttm()
	 * 상세 : 현재 년월일 반환
	 * </pre>
	 * @return 현재 년월일
	 */
	public String getTodayNowDttm() {

		Date date_of_today = new Date();

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

		String todayNow = format.format(date_of_today);

		return todayNow;
	}
}