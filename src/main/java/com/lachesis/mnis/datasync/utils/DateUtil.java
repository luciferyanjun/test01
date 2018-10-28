package com.lachesis.mnis.datasync.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 日期处理工具类
 * @author xin.chen
 *
 */
public class DateUtil {
	private static final Calendar calendar;
	private static final Pattern ymdPattern;
	static {
		calendar = GregorianCalendar.getInstance();
		ymdPattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
	}
	private DateUtil() {}
	public static final String DATE_FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT_ALL = "yyyy-MM-dd HH:mm:ss.SSS";
	public static final String DATE_FORMAT_YMD = "yyyy-MM-dd";
	public static final String DATE_FORMAT_HMS = "HH:mm:ss";
	public static final String DATE_FORMAT_HM = "HH:mm";
	public static final String DATE_FORMAT_YMDHM = "yyyy-MM-dd HH:mm";
	public static final String DATE_FORMAT_YMDHMS = "yyyyMMddHHmmss";
	public static final long ONEDAYMILLS =3600000*24;
	public static final int WEEKDAYS = 7;
	
	/**
	 * 从完整的时间截取精确到分的时间
	 * @param fullDateStr
	 * @return
	 */
	public static String getDateToByLen(String fullDateStr, int length) {
		return fullDateStr == null ? 
				null : 
					(fullDateStr.length() >= length ? fullDateStr.substring(0, length) : fullDateStr);
	}
	
	/**
	 * 返回指定年度的所有周。List中包含的是String[2]对象
	 * string[0]本周的开始日期,string[1]是本周的结束日期。
	 * 日期的格式为YYYY-MM-DD
	 * 每年的第一个周，必须包含星期一且是完整的七天。
	 * 例如：2009年的第一个周开始日期为2009-01-05，结束日期为2009-01-11。
	 * 星期一在哪一年，那么包含这个星期的周就是哪一年的周。
	 * 例如：2008-12-29是星期一，2009-01-04是星期日，哪么这个周就是2008年度的最后一个周。
	 * @param year 格式 YYYY  ，必须大于1900年度 小于9999年 
	 * @return 
	 * @ 
	 */
	public static List<String[]> getWeeksByYear(final int year) {
		int weeks = getWeekNumByYear(year);
		List<String[]> result = new ArrayList<String[]>(weeks);
		for(int i=1;i<=weeks;i++){
			String[] tempWeek = new String[2];
			tempWeek[0] = getYearWeekOfDay(year,i,Calendar.SUNDAY);
			tempWeek[1] = getYearWeekOfDay (year,i,Calendar.SATURDAY);
			result.add(tempWeek);
		}
		return result;
	}
	/**
	 * 上一周
	 * @param year
	 * @param week
	 * @return
	 * @
	 */
	public static int[] getPreWeekByWeek(int year,int week) {
		int[] result = new int[2];
		if(week==1){
			result[1] = year - 1;
			result[0] = getWeekNumByYear(year);
		}else{
			result[0] = week - 1;
		}
		result[0] = week;
		result[1] = year;
		return result;
	}
	/**
	 * 下一周
	 * @param year
	 * @param week
	 * @return
	 * @
	 */
	public static int[] getNextWeekByWeek(int year,int week) {
		int[] result = new int[2];
		int weeks = getWeekNumByYear(year);
		if(week==weeks){
			result[1] = year+1;
			result[0] = 1;
		}else {
			result[0] = week+1;
		}
		return result;
	}

	/**
	 * 计算指定年度共有多少个周。(从周一开始)
	 * @param year 
	 * @return 
	 * @ 
	 */
	public static int getWeekNumByYear(final int year) {
		return getWeekNumByYear(year,Calendar.MONDAY);
	}

	/**
	 * 计算指定年度共有多少个周。
	 * @param year 
	 * @return 
	 * @ 
	 */
	public static int getWeekNumByYear(final int year, int time) {
		//每年至少有52个周 ，最多有53个周。
		int result = 52;
		int sIndex = 4;
		String date = getYearWeekOfDay(year,53, time);
		//判断年度是否相符，如果相符说明有53个周。
		if(date.substring(0, sIndex).equals(year+"")){ 
			result = 53;
		}
		return result;
	}
	/**
	 * 日期转换为制定格式字符串
	 * @param time
	 * @param format
	 * @return
	 */
	public static String formatDateToString(Date time,String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(time);
	}
	/**
	 * 字符串转换为制定格式日期
	 * @param date
	 * @param format
	 * @return
	 * @throws java.text.ParseException
	 * @
	 */
	public static Date formatStringToDate(String date,String format) throws ParseException  {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(date);
	}
	/**
	 * 计算某年某周内的指定日期(从周一开始)
	 * @param yearNum
	 * @param weekNum
	 * @param week
	 * @return
	 * @
	 */
	public static String getYearWeekOfDay(int yearNum,int weekNum,int week)   {
		return getYearWeekOfDay(yearNum,weekNum,week,Calendar.MONDAY);
	}

	/**
	 * 计算某年某周内的指定日期
	 * @param yearNum
	 * @param weekNum
	 * @param week
	 * @return
	 * @
	 */
	public static String getYearWeekOfDay(int yearNum,int weekNum,int week, int time) {
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(time);
		cal.set(Calendar.DAY_OF_WEEK, week);
		cal.setMinimalDaysInFirstWeek(WEEKDAYS);
		cal.set(Calendar.YEAR, yearNum);
		cal.set(Calendar.WEEK_OF_YEAR, weekNum);
		return formatDateToString(cal.getTime(),DATE_FORMAT_YMD);
	}

	/**
	 * 获取指定日期星期几
	 * @param datetime
	 * @throws java.text.ParseException
	 * @
	 */
	public static int getWeekOfDate(String datetime) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setMinimalDaysInFirstWeek(WEEKDAYS);
		Date date = formatStringToDate(datetime,DATE_FORMAT_YMD);
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK);

	}

	/**
	 * 计算某年某周内的所有日期(从周一开始 为每周的第一天)
	 * @param yearNum
	 * @param weekNum
	 * @return
	 * @
	 */
	public static String[] getYearWeekOfDays(int yearNum,int weekNum) {
		return getYearWeekOfDays(yearNum,weekNum,Calendar.MONDAY);
	}

	/**
	 * 计算某年某周内的所有日期
	 * @param yearNum
	 * @param weekNum
	 * @return
	 * @
	 */
	public static String[] getYearWeekOfDays(int yearNum,int weekNum, int time) {
		String[] strs = new String[WEEKDAYS];
		int weeks = time;
		for (int i=0;i<strs.length;i++) {
			if(i > 0&&weeks < WEEKDAYS){
				weeks ++;
			}else if(i>0&&weeks==WEEKDAYS){
				weeks = 1;
			}
			strs[i] = getYearWeekOfDay(yearNum,weekNum, weeks, time);
		}
		return strs;
	}



	private static int calculateDays(Date startDate, Date endDate){
		return (int)( (endDate.getTime()-startDate.getTime())/ONEDAYMILLS );
	}

	public static int getDaysGapOfDates(Date startDate, Date endDate){
		int date = 0;
		if(startDate !=null && endDate !=null){
			date = calculateDays(startDate,endDate);
		}
		return date;
	}

	/**
	 * 计算两个日期之间的年份差距
	 * @param firstDate
	 * @param secondDate
	 * @return
	 */

	public static int getYearGapOfDates(Date firstDate, Date secondDate) {
		if (firstDate == null || secondDate == null) {
			return 0;
		}
		calendar.setTime(firstDate);
		int firstYear = calendar.get(Calendar.YEAR);
		calendar.setTime(secondDate);
		int secondYear = calendar.get(Calendar.YEAR);
		return secondYear - firstYear;
	}

	/**
	 * 计算两个日期之间的月份差距
	 * @param firstDate
	 * @param secondDate
	 * @return
	 */
	public static int getMonthGapOfDates(Date firstDate, Date secondDate) {
		if (firstDate == null || secondDate == null)
			return 0;
		return (int)( (secondDate.getTime()-firstDate.getTime())/ONEDAYMILLS/30);

	}

	/**
	 * 计算是否包含当前日期
	 * @param dates
	 * @return
	 */
	public static boolean isContainCurrent(List<String> dates){
		boolean flag = false;
		SimpleDateFormat fmt = new SimpleDateFormat(DATE_FORMAT_YMD);
		Date date = new Date();
		String dateStr = fmt.format(date);
		for (int i = 0; i < dates.size(); i++) {
			if(dateStr.equals(dates.get(i))){
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * 获取一天的0点和23点59分的时间 如果传入null，则两个端点时间都为null
	 *
	 * @param day
	 *            : yyyy-MM-dd
	 * @return
	 * @throws java.text.ParseException
	 */
	public static String[] getTimeEndPoints(String day) throws ParseException {
		String[] endPoints = new String[2];
		if (day != null && ymdPattern.matcher(day).matches()) {
			endPoints[0] = day + " 00:00:00";
			endPoints[1] = day + " 23:59:59";
		}
		return endPoints;
	}
}	

