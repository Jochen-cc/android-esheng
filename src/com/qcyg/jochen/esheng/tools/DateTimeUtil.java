package com.qcyg.jochen.esheng.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateTimeUtil {
    public static final String LOCAL_SHORT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String LOCAL_SHORT_DATE_MD = "yyyy-M-d";
    public static final String LOCAL_LONG_DATE_FORMAT  = "yyyy-MM-dd HH:mm:ss";
    public static final String STANDARD_LONG_DATE_FORMAT  = "yyyy/MM/dd HH:mm:ss";
    public static final String STANDARD_SHORT_DATE_FORMAT = "yyyy/MM/dd";
    
    public static final String LOCAL_MID_LONG_DATE_FORMAT  = "yyyy-MM-dd HH:mm";
    
    public static Date getCurrentDate() {
        return new Date(System.currentTimeMillis());
    }
    
    public static String getShortFormat(Date date) {
        if (date == null) {
    	    return null;
        }
        return getFormatString(date, LOCAL_SHORT_DATE_FORMAT);
    }
    
    public static String getLongFormat(Date date) {
        if (date == null) {
    	    return null;
        }
        return getFormatString(date, LOCAL_LONG_DATE_FORMAT);
    }
    
    public static String getFormatString(Date date, String dateFormat) {
        if (date == null 
    	    || StringUtil.isEmpty(dateFormat)) {
    	    return null;
        }
    
        return new SimpleDateFormat(dateFormat, Locale.getDefault()).format(date);
    }
    
    public static String convertMdToMMdd(String dateFormat){
    	DateFormat formatter = new SimpleDateFormat("yyyy-M-d", Locale.getDefault());
    	Date date = null;
		try {
			date = (Date)formatter.parse(dateFormat);
		} catch (ParseException e) {
			e.printStackTrace();
		}

    	formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    	return formatter.format(date);
    }
    
    public static DateFormat getGMTDateFormat() {
    	DateFormat dateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", Locale.ENGLISH);
    	dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    	return dateFormat;
    }
    
    public static Date parse(String dateString, String dateFormat) {
        if (StringUtil.isEmpty(dateString) 
      	    || StringUtil.isEmpty(dateFormat)) {
            return null;
        }
    
        SimpleDateFormat format = new SimpleDateFormat(dateFormat, Locale.getDefault());
        Date date = null;
        try {
            date = format.parse(dateString);
        } catch (Exception ex) {
        }
    
        return date;
    }
    
    public static Date parseMidLongFormat(String dateString) {
        return parse(dateString, LOCAL_MID_LONG_DATE_FORMAT);
    }
    
    public static Date parseShortFormat(String dateString) {
        return parse(dateString, LOCAL_SHORT_DATE_FORMAT);
    }
    
    public static Date parseLongFormat(String dateString) {
        return parse(dateString, LOCAL_LONG_DATE_FORMAT);
    }
    
    /**
     * modify the <code>date</code> with <code>offset</code> days <p>
     * 根据offset的值，修改date日期，当为正的时，获得offset天后的日期，当为负时，获得|offset|天前的日期;
     * @param date
     * @param offset negative value return abs(offset) days before date, 
     *               positive value return offset days after date
     * @return date after modified
     */
    public static Date offsetDay(Date date, int offset) {
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  
        calendar.set(Calendar.DAY_OF_YEAR, (calendar.get(Calendar.DAY_OF_YEAR) + offset));  
        return calendar.getTime();
    }
    
    public static Date offsetHour(Date date, int offset) {
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  
        calendar.set(Calendar.HOUR_OF_DAY, (calendar.get(Calendar.HOUR_OF_DAY) + offset));  
        return calendar.getTime();
    }
 
    public static Date offsetMinute(Date date, int offset) {
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  
        calendar.set(Calendar.MINUTE, (calendar.get(Calendar.MINUTE) + offset));  
        return calendar.getTime();
    }

    public static Date offsetSecond(Date date, int offset) {
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  
        calendar.set(Calendar.SECOND, (calendar.get(Calendar.SECOND) + offset));  
        return calendar.getTime();
    }
    
    public static Date convertToShortHour(Date date) {
    	if (date == null) {
    		return null;
    	}
    	
    	Calendar calendar = Calendar.getInstance(); 
    	calendar.setTime(date);
    	calendar.set(Calendar.MINUTE, 0);
    	calendar.set(Calendar.SECOND, 0);
    	calendar.set(Calendar.MILLISECOND, 0);
    	
    	return calendar.getTime();
    }
    
    public static Date convertToShortDate(Date date) {
    	if (date == null) {
    		return null;
    	}
    	
    	Calendar calendar = Calendar.getInstance(); 
    	calendar.setTime(date);
    	calendar.set(Calendar.HOUR_OF_DAY, 0);
    	calendar.set(Calendar.MINUTE, 0);
    	calendar.set(Calendar.SECOND, 0);
    	calendar.set(Calendar.MILLISECOND, 0);
    	
    	return calendar.getTime();
    }
    
    public static Date convertToShortWeek(Date date) {
    	if (date == null) {
    		return null;
    	}
    	
    	Calendar calendar = Calendar.getInstance(); 
    	calendar.setTime(date);
    	calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
    	calendar.set(Calendar.HOUR_OF_DAY, 0);
    	calendar.set(Calendar.MINUTE, 0);
    	calendar.set(Calendar.SECOND, 0);
    	calendar.set(Calendar.MILLISECOND, 0);
    	
    	return calendar.getTime();
    }
    
    public static Date convertToShortMonth(Date date) {
    	if (date == null) {
    		return null;
    	}
    	
    	Calendar calendar = Calendar.getInstance(); 
    	calendar.setTime(date);
    	calendar.set(Calendar.DAY_OF_MONTH, 1);
    	calendar.set(Calendar.HOUR_OF_DAY, 0);
    	calendar.set(Calendar.MINUTE, 0);
    	calendar.set(Calendar.SECOND, 0);
    	calendar.set(Calendar.MILLISECOND, 0);
    	
    	return calendar.getTime();
    }
    
    public static Date convertToShortYear(Date date) {
    	if (date == null) {
    		return null;
    	}
    	
    	Calendar calendar = Calendar.getInstance(); 
    	calendar.setTime(date);
    	calendar.set(Calendar.MONTH, Calendar.JANUARY);
    	calendar.set(Calendar.DAY_OF_MONTH, 1);
    	calendar.set(Calendar.HOUR_OF_DAY, 0);
    	calendar.set(Calendar.MINUTE, 0);
    	calendar.set(Calendar.SECOND, 0);
    	calendar.set(Calendar.MILLISECOND, 0);
    	
    	return calendar.getTime();
    }

    public static String TimeStamp2Date(String timestampString){  
    	  Long timestamp = Long.parseLong(timestampString)*1000;  
    	  String date = new java.text.SimpleDateFormat("yyyy/MM/dd", Locale.getDefault()).format(new java.util.Date(timestamp));  
    	  return date;  
    	} 
    public static String TimeStamp2Date(String timestampString,String format){ 
    	DateFormat formatter = new SimpleDateFormat(format, Locale.getDefault());
  	  Long timestamp = Long.parseLong(timestampString)*1000;  
  	  String date = formatter.format(new java.util.Date(timestamp));  
  	  return date;  
  	} 
    public static Boolean isToday(String timestampString)
    {
    	Calendar calendar = Calendar.getInstance();
    	String strDate = TimeStamp2Date(timestampString);
    	if(calendar.get(Calendar.YEAR)==Integer.valueOf(strDate.substring(0, 4))
    			&&calendar.get(Calendar.MONTH)==Integer.valueOf(strDate.substring(5, 7))-1
    					&&calendar.get(Calendar.DAY_OF_MONTH)==Integer.valueOf(strDate.substring(8, 10)))
    					{
    						return true;
    					}
				    	else {
							return false;
						}
    }
    
    public static String parseDate(String strDate) //"yyyy/MM/dd"
    {  
    	if(StringUtil.isEmpty(strDate)) return "";
    	if(strDate.length()<10) return "";
    	String date=strDate.substring(8,10).toString()+" ";
    	if("01".equals(strDate.substring(5,7).toString()))
    	{
    		date+="一";
    	}
    	if("02".equals(strDate.substring(5,7).toString()))
    	{
    		date+="二";
    	}
    	if("03".equals(strDate.substring(5,7).toString()))
    	{
    		date+="三";
    	}
    	if("04".equals(strDate.substring(5,7).toString()))
    	{
    		date+="四";
    	}
    	if("05".equals(strDate.substring(5,7).toString()))
    	{
    		date+="五";
    	}
    	if("06".equals(strDate.substring(5,7).toString()))
    	{
    		date+="六";
    	}
    	if("07".equals(strDate.substring(5,7).toString()))
    	{
    		date+="七";
    	}
    	if("08".equals(strDate.substring(5,7).toString()))
    	{
    		date+="八";
    	}
    	if("09".equals(strDate.substring(5,7).toString()))
    	{
    		date+="九";
    	}
    	if("10".equals(strDate.substring(5,7).toString()))
    	{
    		date+="十";
    	}
    	if("11".equals(strDate.substring(5,7).toString()))
    	{
    		date+="十一";
    	}
    	if("12".equals(strDate.substring(5,7).toString()))
    	{
    		date+="十二";
    	}
    	date+="月";
  	  return date;  
  	} 
}

