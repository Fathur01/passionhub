package com.fwd.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.fwd.ws.WebServiceEndPointSetting;

public class DateUtils {

	@SuppressWarnings("unused")
	@Autowired
	private static WebServiceEndPointSetting setting;

//	private static final String BUSINESS_DATE = "27/07/2015";
	private static final String EMPTY_DATE = "01/01/1900";
	private static final String DATE_FORMAT = "dd/MM/yyyy";	//** format for WS input
	private static final String DATETIME_FORMAT = "dd/MM/yyyy hh:mm:ss";	//** format for WS input
	public static Date emptyDate() {

		try {
			return toDate(EMPTY_DATE);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static Date toDateTime(String datStr) throws ParseException {
		if (StringUtils.isBlank(datStr)) {
			return null;
		}

		return toDate(datStr, DATETIME_FORMAT);
	}


	public static Date dateTimeNow() {
		
		Calendar cal = Calendar.getInstance();
		Date _todayDate = cal.getTime();
		
		return _todayDate;
	}
	
//	public static Date businessDate() {
//		
//		try {
//			return toDate(BUSINESS_DATE, "dd/MM/yyyy");
//		} catch (ParseException e) {
//			Calendar cal = Calendar.getInstance();
//			Date _todayDate = cal.getTime();
//			
//			return _todayDate;
//		}
//	}
	
	public static Date toDate(String dateStr) throws ParseException {

		if (StringUtils.isBlank(dateStr)) {
			return null;
		}

		return toDate(dateStr, DATE_FORMAT);
	}
	
	public static Date toDateWithZeroTime(Date dat) throws ParseException {

		if (dat == null) {
			return null;
		}

		return toDate(formatDate(dat, DATE_FORMAT), DATE_FORMAT);
	}

	public static boolean isDate(String datStr) {
		if (StringUtils.isBlank(datStr)) {
			return false;
		}
		try {
			toDate(datStr, DATE_FORMAT);
			return true;
		} catch (ParseException ex) {
			return false;
		}
	}

	public static boolean isPastDate(String datStr) throws ParseException {
		if (!isDate(datStr)) {
			return false;
		} else {
			return isPastDate(toDate(datStr));
		}
	}

	public static boolean isPastDate(Date dat) {
		if (dat == null) {
			return false;
		}

		Calendar now = Calendar.getInstance();
		Calendar dob = Calendar.getInstance();
		dob.setTime(dat);

		if (now.after(dob)) {
			return true;
		} else {
			return false;
		}
	}

	public static Integer getAge(String datStr) throws ParseException {
		if (!isDate(datStr)) {
			return null;
		} else {
			return getAge(toDate(datStr), null);
		}
	}

	public static Integer getAge(Date dat, Date compareDate) {
		if (dat == null) {
			return null;
		} else {
			Calendar now = Calendar.getInstance();
			if (compareDate != null){
				now.setTime(compareDate);
			}

			Calendar dob = Calendar.getInstance();
			dob.setTime(dat);

			int age = now.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

			if ((dob.get(Calendar.MONTH) > now.get(Calendar.MONTH)) || (dob.get(Calendar.MONTH) == now.get(Calendar.MONTH) && dob.get(Calendar.DAY_OF_MONTH) > now.get(Calendar.DAY_OF_MONTH))) {
				age--;
			}
			if (age < 0){
				return null;
			}else{
				return age;
			}
		}
	}

	public static boolean isAge18OrAbove(String datStr) throws ParseException {
		Integer age = getAge(datStr);
		return isAge18OrAbove(age);
	}

	public static boolean isAge18OrAbove(Date dat) {
		Integer age = getAge(dat, null);
		return isAge18OrAbove(age);
	}

	private static boolean isAge18OrAbove(Integer age) {
		if (age != null && age >= 18) {
			return true;
		} else {
			return false;
		}
	}

	/* generic functions */
	public static int dayDifference(Date date1, Date date2) {
		long diff = date2.getTime() - date1.getTime();
		return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

	}
	
	public static String formatDate(Date dat) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
		return simpleDateFormat.format(dat);
	}

	public static String formatDate(Date dat, String dateFormat) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		return simpleDateFormat.format(dat);
	}

	public static Date toDate(String datStr, String dateFormat) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		// By default, SimpleDateFormat.setLenient() is set to true, you should
		// always turn it off to make your date validation more strictly.
		formatter.setLenient(false);

		Date date = formatter.parse(datStr);
		return date;
	}

	public static String formatDate(String dateStr, String dateFormatFr, String dateFormatTo) {

		if (StringUtils.isBlank(dateStr)) {
			return "";
		}

		DateFormat fromFormat = new SimpleDateFormat(dateFormatFr);
		fromFormat.setLenient(false);
		DateFormat toFormat = new SimpleDateFormat(dateFormatTo);
		toFormat.setLenient(false);
		Date date = new Date();
		try {
			date = fromFormat.parse(dateStr);
		} catch (ParseException e) {

			e.printStackTrace();
		}

		return toFormat.format(date);
	}
	
	public static Date addYear(Date date, int years) {

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, years); // number of days to add
		return c.getTime();

	}
	
	public static Date addDate(Date date, int days) {

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, days); // number of days to add
		return c.getTime();

	}
	
	public static Date addHours(Date date, int hours) {

		if (date != null) {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.HOUR, hours); // number of days to add
			return c.getTime();
		} else { 
			return date;
		}

	}
	
	
	public static Date toStartOfYear(int year) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.set(Calendar.YEAR, year);
	    calendar.set(Calendar.DAY_OF_YEAR, 0);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    return calendar.getTime();
	}

	public static Date toEndOfYear(int year) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.set(Calendar.YEAR, year + 1);
	    calendar.set(Calendar.DAY_OF_YEAR, 0);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND,-1);
	    return calendar.getTime();
	}
	
	
	public static Date convertLongToDate(Long longDOB) {
		Date dobCon = null;
		if(longDOB!=0){
			dobCon = new Date(longDOB);
			if (DateUtils.emptyDate().equals(dobCon))
				dobCon= null ;
		}
		return dobCon;
	}
	
	
}
