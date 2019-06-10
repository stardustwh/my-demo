package test;

/*import framework.utils.TimeTools;*/

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {
	
	//获取系统当前时间
	//获取系统当前年份

	public static Date getCurrentDay(){
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}
	public static int getYear(){
		Calendar calendar = Calendar.getInstance() ;
		return calendar.get(Calendar.YEAR);
	}
	
	//获取系统当前年份的第一个月(yyyy年mm月)
	public static String getFirstMonthOfYear(){
		Calendar calendar = Calendar.getInstance() ;
		calendar.set(Calendar.MONTH,0);
		return new SimpleDateFormat("yyyy年MM月").format(calendar.getTime());
	}
	
	//获取系统当前年份的第一个月(yyyymm月)
	public static String getFirstMonthOfYear1(){
		Calendar calendar = Calendar.getInstance() ;
		calendar.set(Calendar.MONTH,0);
		return new SimpleDateFormat("yyyyMM").format(calendar.getTime());
	}
	
	//获取系统当前年月份(yyyy年mm月dd日)
	public static String getNowDayMonthYear(){
		Calendar calendar = Calendar.getInstance() ;
		return new SimpleDateFormat("yyyy年MM月dd日").format(calendar.getTime());
	}	
	
	public static String getDateString(String date){
		Calendar calendar = Calendar.getInstance();     
    	calendar.set(Calendar.YEAR, Integer.parseInt(date.split("-")[0]));     
    	calendar.set(Calendar.MONTH, Integer.parseInt(date.split("-")[1])-1);     
    	calendar.set(Calendar.DAY_OF_MONTH,Integer.parseInt(date.split("-")[2]));
		return new SimpleDateFormat("yyyy年MM月dd日").format(calendar.getTime());
	}

	public static Date getDateTimeFromString(String str){
		LocalDateTime localDateTime = LocalDateTime.parse(str, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		return  new Date(localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli());
	}
	//获取系统当前年月份(yyyy年mm月)
	public static String getMonthOfYear(){
		Calendar calendar = Calendar.getInstance() ;
		return new SimpleDateFormat("yyyy年MM月").format(calendar.getTime());
	}
	
	//获取系统当前日期(yyyy-MM-dd)
	public static String getCurrentDayString(){
		Calendar calendar = Calendar.getInstance() ;
		return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
	}

	//获取系统当前日期(yyyy-MM-dd HH:mm:ss)
	public static String getCurrentDayAllString(){
		Calendar calendar = Calendar.getInstance() ;
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
	}
	
	//获取系统当前年份
	public static int getMonth(){
		Calendar calendar = Calendar.getInstance() ;
		return calendar.get(Calendar.MONTH);
	}
		
	//获取系统当前年份
	public static int getDay(){
		Calendar calendar = Calendar.getInstance() ;
		return calendar.get(Calendar.DATE);
	}
	
	//获取系统上一个月
	public static Date getPreMonth(){
		Calendar calendar = Calendar.getInstance() ;
		calendar.add(Calendar.MONTH, -1);
		return calendar.getTime();
	}
	//获取系统上一个月
	public static String getPreMonthStr(){
		Calendar calendar = Calendar.getInstance() ;
		calendar.add(Calendar.MONTH, -1);
		return new SimpleDateFormat("yyyyMM").format(calendar.getTime());
	}
	//获取系统上一个月
	public static String getPreMonthStr(int i){
		Calendar calendar = Calendar.getInstance() ;
		calendar.add(Calendar.MONTH, -(i));
		SimpleDateFormat format =  new SimpleDateFormat("yyyyMM");
		return format.format(calendar.getTime());
	}
	
	//获取系统上某个月
	public static String getPreMonthStr0(int i){
		Calendar calendar = Calendar.getInstance() ;
		calendar.add(Calendar.DAY_OF_MONTH, -(i));
		SimpleDateFormat format =  new SimpleDateFormat("yyyyMMdd");
		return format.format(calendar.getTime());
	}	
	
	//获取系统上一个月
	public static String getPreMonthStr1(int i){
		Calendar calendar = Calendar.getInstance() ;
		calendar.add(Calendar.MONTH, -(i));
		SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM");
		return format.format(calendar.getTime());
	}
	
	//获取系统上一个月
	public static String getPreMonthStrFormat(int i){
		Calendar calendar = Calendar.getInstance() ;
		calendar.add(Calendar.MONTH, -(i));
		SimpleDateFormat format =  new SimpleDateFormat("yyyy年MM月");
		return format.format(calendar.getTime());
	}
	
	//获取系统当前时间
	public static String getMonthStr(){
		Calendar calendar = Calendar.getInstance() ;
		SimpleDateFormat format =  new SimpleDateFormat("yyyyMM");
		return format.format(calendar.getTime());
	}
	
	//获取系统当前时间
	public static String getMonthStr1(){
		Calendar calendar = Calendar.getInstance() ;
		SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM");
		return format.format(calendar.getTime());
	}
	
	//获取系统当前时间
	public static String getDayStr(){
		Calendar calendar = Calendar.getInstance() ;
		SimpleDateFormat format =  new SimpleDateFormat("dd");
		return format.format(calendar.getTime());
	}
	
	//获取系统当前时间
	public static String getNextDayStr(String date){
		Calendar calendar = Calendar.getInstance();     
    	calendar.set(Calendar.YEAR, Integer.parseInt(date.split("-")[0]));     
    	calendar.set(Calendar.MONTH, Integer.parseInt(date.split("-")[1])-1);     
    	calendar.set(Calendar.DAY_OF_MONTH,Integer.parseInt(date.split("-")[2])+1); 
		SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");
		return format.format(calendar.getTime());
	}
	
	/**
     * 返回指定日期的月的第一天
     *
     * @return
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR),
                     calendar.get(Calendar.MONTH), 1);
        return calendar.getTime();
    }
    
    // 获取前一天
 	public static String getCurrentPreDay(int i) {
 		Calendar calendar = Calendar.getInstance();
 		calendar.add(Calendar.DATE, -i); // 得到前一天
 		Date date = calendar.getTime();
 		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
 		return df.format(date);
 	}
	
	/**
     * 返回指定日期的月的第一天
     *
     * @return
     */
    public static String getFirstDayOfMonthStr(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR),
                     calendar.get(Calendar.MONTH), 1);
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");
		return format.format(calendar.getTime());
    }
    
    /**
     * 返回指定日期的月的第一天
     *
     * @return
     */
    public static String getFirstDayOfMonthStr() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR),
                     calendar.get(Calendar.MONTH), 1);
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");
		return format.format(calendar.getTime());
    }

    /**
     * 返回指定年月的月的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getFirstDayOfMonth(Integer year, Integer month) {
    	Calendar calendar = Calendar.getInstance();     
    	calendar.set(Calendar.YEAR, year);     
    	calendar.set(Calendar.MONTH, month-1);     
    	calendar.set(Calendar.DAY_OF_MONTH,calendar.getMinimum(Calendar.DATE)); 
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

	/**
	 * 返回时间戳
	 *
	 * @return
	 */
	public static int getTimeStemp() {
		SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		int timeStemp = 0;
		try {
			Date date1 = calendar.getTime();
			Date date2 = simpleDateFormat.parse("1970-01-01 08:00:00");
			long l = date1.getTime() - date2.getTime() > 0 ? date1.getTime()- date2.getTime() : date2.getTime() - date1.getTime();
			timeStemp = (int) (l/1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return timeStemp;
	}
    
    /**
     * 返回指定年月的月的第一天毫描述
     *
     * @param year
     * @param month
     * @return
     */
    public static long getFirstDayOfMonthLong(Integer year, Integer month) {
    	Calendar calendar = Calendar.getInstance();     
    	calendar.set(Calendar.YEAR, year);     
    	calendar.set(Calendar.MONTH, month-1);     
    	calendar.set(Calendar.DAY_OF_MONTH,calendar.getMinimum(Calendar.DATE)); 
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime().getTime();
    }
    
    /**
     * 返回指定年月的月的第一天毫描述
     *
     * @param year
     * @param month
     * @return
     */
    public static int getFirstDayOfMonthInt(Integer year, Integer month) {
    	Calendar calendar = Calendar.getInstance();     
    	calendar.set(Calendar.YEAR, year);     
    	calendar.set(Calendar.MONTH, month-1);     
    	calendar.set(Calendar.DAY_OF_MONTH,calendar.getMinimum(Calendar.DATE)); 
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        String strTime = calendar.getTime().getTime() + "";  
        strTime = strTime.substring(0, 10);  
        return Integer.parseInt(strTime);
    }
    
    /**
     * 返回指定年月的月的第一天毫描述
     *
     * @return
     */
    public static int getFirstDayOfMonthInt(String date) {
    	Calendar calendar = Calendar.getInstance();     
    	calendar.set(Calendar.YEAR, Integer.parseInt(date.split("-")[0]));     
    	calendar.set(Calendar.MONTH, Integer.parseInt(date.split("-")[1])-1);     
    	calendar.set(Calendar.DAY_OF_MONTH,Integer.parseInt(date.split("-")[2])); 
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        String strTime = calendar.getTime().getTime() + "";  
        strTime = strTime.substring(0, 10);  
        return Integer.parseInt(strTime);
    }

    /**
     * 返回指定日期的月的最后一天
     *
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR),
                     calendar.get(Calendar.MONTH), 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.getTime();
    }
    
    /**
     * 返回指定日期的月的最后一天
     *
     * @return
     */
    public static String getLastDayOfMonthStr(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR),
                     calendar.get(Calendar.MONTH), 1);
        calendar.roll(Calendar.DATE, -1);
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");
        return format.format(calendar.getTime());
    }

    /**
     * 返回指定年月的月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getLastDayOfMonth(Integer year, Integer month) {
    	Calendar calendar = Calendar.getInstance();     
    	calendar.set(Calendar.YEAR, year);     
    	calendar.set(Calendar.MONTH, month-1);     
    	calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DATE)); 
    	calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }
    
    /**
     * 返回指定年月的月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static long getLastDayOfMonthLong(Integer year, Integer month) {
    	Calendar calendar = Calendar.getInstance();     
    	calendar.set(Calendar.YEAR, year);     
    	calendar.set(Calendar.MONTH, month-1);     
    	calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DATE)); 
    	calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime().getTime();
    }
    
    /**
     * 返回指定年月的月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static int getLastDayOfMonthInt(Integer year, Integer month) {
    	Calendar calendar = Calendar.getInstance();     
    	calendar.set(Calendar.YEAR, year);     
    	calendar.set(Calendar.MONTH, month-1);     
    	calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DATE)); 
    	calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        String strTime = calendar.getTime().getTime() + "";  
        strTime = strTime.substring(0, 10);  
        return Integer.parseInt(strTime);
    }
    
    /**
     * 返回指定年月的月的最后一天
     *
     * @return
     */
    public static int getLastDayOfMonthInt(String date) {
    	Calendar calendar = Calendar.getInstance();     
    	calendar.set(Calendar.YEAR, Integer.parseInt(date.split("-")[0]));     
    	calendar.set(Calendar.MONTH, Integer.parseInt(date.split("-")[1])-1);     
    	calendar.set(Calendar.DAY_OF_MONTH,Integer.parseInt(date.split("-")[2])); 
    	calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        String strTime = calendar.getTime().getTime() + "";  
        strTime = strTime.substring(0, 10);  
        return Integer.parseInt(strTime);
    }
    
    /***
     * 获取下一个月
     * @param year
     * @param month
     * @return
     */
    public static Date getNextMonth(int year,int month){
    	Calendar calendar = Calendar.getInstance();     
    	calendar.set(Calendar.YEAR, year);     
    	calendar.set(Calendar.MONTH, month); 
		return calendar.getTime();
    }
    
    /***
     * 获取下一个月
     * @param year
     * @param month
     * @return
     */
    public static String getNextMonthStr(int year,int month){
    	Calendar calendar = Calendar.getInstance();     
    	calendar.set(Calendar.YEAR, year);     
    	calendar.set(Calendar.MONTH, month); 
		return new SimpleDateFormat("yyyy-MM").format(calendar.getTime());
    }
    
    /***
     * 获取下一个月
     * @param year
     * @param month
     * @return
     */
    public static Date getPreMonth(int year,int month,int i){
    	Calendar calendar = Calendar.getInstance();     
    	calendar.set(Calendar.YEAR, year);     
    	calendar.set(Calendar.MONTH, month-i-1); 
		return calendar.getTime();
    }
    
    /***
     * 获取下一个月
     * @param year
     * @param month
     * @return
     */
    public static String getPreMonthStr(int year,int month,int i){
    	Calendar calendar = Calendar.getInstance();     
    	calendar.set(Calendar.YEAR, year);     
    	calendar.set(Calendar.MONTH, month-i-1);
		return new SimpleDateFormat("yyyyMM").format(calendar.getTime());
    }
    
    public static String getNextMonthStr(int year,int month,int i){
    	Calendar calendar = Calendar.getInstance();     
    	calendar.set(Calendar.YEAR, year);     
    	calendar.set(Calendar.MONTH, month+i-1); 
		return new SimpleDateFormat("yyyyMM").format(calendar.getTime());
    }

    public static String getPreMonthStr1(int year,int month,int i){
    	Calendar calendar = Calendar.getInstance();     
    	calendar.set(Calendar.YEAR, year);     
    	calendar.set(Calendar.MONTH, month-i-1);
		return new SimpleDateFormat("yyyy-MM").format(calendar.getTime());
    }
    
    public static String getNextMonthStr1(int year,int month,int i){
    	Calendar calendar = Calendar.getInstance();     
    	calendar.set(Calendar.YEAR, year);
    	calendar.set(Calendar.MONTH, month+i-1);
    	calendar.set(Calendar.DAY_OF_MONTH, 1);
		return new SimpleDateFormat("yyyy-MM").format(calendar.getTime());
    }
    /***
     * 转换为日期
     * @param year
     * @param month
     * @return
     */
    public static Date getMonthDate(int year,int month){
    	Calendar calendar = Calendar.getInstance();     
    	calendar.set(Calendar.YEAR, year);     
    	calendar.set(Calendar.MONTH, month-1); 
		return calendar.getTime();
    }
    
    /***
     * 转换为日期
     * @param year
     * @param month
     * @return 
     * @return
     */
    public static String getMonthDateStr(int year,int month){
    	Calendar calendar = Calendar.getInstance();     
    	calendar.set(Calendar.YEAR, year);     
    	calendar.set(Calendar.MONTH, month-1); 
		return new SimpleDateFormat("yyyy-MM").format(calendar.getTime());
    }
    
    /***
     * 转换为日期
     * @param date  yyyymm
     * 
     * @return 
     * @return
     */ 
    public static String getMonthDateStr(String date){
    	Calendar calendar = Calendar.getInstance();  
    	int year = Integer.parseInt(date.substring(0, 4));
    	int month = Integer.parseInt(date.substring(4, 6));
    	
    	calendar.set(Calendar.YEAR, year);     
    	calendar.set(Calendar.MONTH, month-1); 
		return new SimpleDateFormat("yyyy年MM月").format(calendar.getTime());
    }
    /*
     * 获取贷款后n个月所有年月作为echart横坐标
     */
    public static String getNext12MonthDate(int num){
    	String monthdate="";
    	for (int i = num-1; i >=0; i--) {
    		monthdate+=DateUtil.getPreMonthStr(i)+",";
		}
		return monthdate;
    	
    }
    /*
     * 获取贷款后n个月后的月份 
     */
/*    public static String getNextMonthByNum(int time,int num){
    	String year=TimeTools.getYYYYMM(time).substring(0, 4);
    	String month=TimeTools.getYYYYMM(time).substring(TimeTools.getYYYYMM(time).indexOf("-")+1,TimeTools.getYYYYMM(time).length());
    	String monthdate=DateUtil.getNextMonthStr(Integer.parseInt(year),Integer.parseInt(month), num);
		return monthdate;
    	
    }*/
    /*
     * 获取贷款后n个月后的月份查询汇总表  格式为xxxx-xx
     */
   public static String getMonthCaculateByNum(int num){
	  String preMonthStr = DateUtil.getPreMonthStr(num);
   	  String next =preMonthStr.substring(0,4)+"-"+preMonthStr.substring(4,preMonthStr.length());
   	  return next; 
    	
    }
   
   public static String getMonthCaculateByNum2(int num){
		  String preMonthStr = DateUtil.getPreMonthStr(num);
	   	  String next =preMonthStr.substring(0,4)+preMonthStr.substring(4,preMonthStr.length());
	   	  return next; 
	    	
	    }
   //将时间戳转化为时间
   public static Date getDateStringFromTimes(Integer times){
	   SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   long time1 = times*1000l;
	   String d = format.format(time1);
	   Date date = null;
		try {
			date = format.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	   return  date;
   };
   
   //将时间转化时间戳
  public static int getDateTamp(String time) {
	   SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");  
	   Date date;
	   int datetamp = 0;
	try {
		date = format.parse(time);
		datetamp = (int) date.getTime();
	} catch (ParseException e) {
		e.printStackTrace();
	}  
	 return datetamp;
  }
  
  //将字符串转化时间戳(单位秒)
  public static int getTimeStemp(String time) {
	   	 SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	     int timeStemp = 0;
		 try {
			 Date date1 = simpleDateFormat.parse(time+" 00:00:00");
			 Date date2 = simpleDateFormat.parse("1970-01-01 08:00:00");
			 long l = date1.getTime() - date2.getTime() > 0 ? date1.getTime()- date2.getTime() : date2.getTime() - date1.getTime();
			 timeStemp = (int) (l/1000);
		 } catch (ParseException e) {
			 e.printStackTrace();
		 }
	     return timeStemp;
  }
  //将时间戳转化字符串(yyyy-MM-dd)
  public static String getStringByTimeStemp(Integer times) {
	   SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");
	   String time = "";
	   long time1 = times*1000l;
		   try {
			   time = format.format(time1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		   return time;
  }

	public static void main(String[] args) {
		System.out.println(getChangeDayString("2015-07-31",50));
	}

	public static String getChangeDayString(String dateString,int days){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // 日期格式
		Date date = null; // 指定日期
		try {
			date = dateFormat.parse(dateString);

			Date newDate = addDate(date, days); // 指定日期加上20天
			dateString = dateFormat.format(newDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateString;

	}

	public static Date addDate(Date date,long day) throws ParseException {
		long time = date.getTime(); // 得到指定日期的毫秒数
		day = day*24*60*60*1000; // 要加上的天数转换成毫秒数
		time+=day; // 相加得到新的毫秒数
		return new Date(time); // 将毫秒数转换成日期
	}
  //将时间戳转化字符串(yyyy-MM-dd)
  public static String getString2ByTimeStemp(Integer times) {
	  SimpleDateFormat format =  new SimpleDateFormat("HH:mm:ss");
	  String time = "";
	  long time1 = times*1000l;
	  try {
		  time = format.format(time1);
	  } catch (Exception e) {
		  e.printStackTrace();
	  }
	  return time;
  }
  
  //将时间戳转化字符串(yyyyMM)
  public static String getString2ByTimeStemp2(Integer times) {
	  SimpleDateFormat format =  new SimpleDateFormat("yyyyMM");
	  String time = "";
	  long time1 = times*1000l;
	  try {
		  time = format.format(time1);
	  } catch (Exception e) {
		  e.printStackTrace();
	  }
	  return time;
  }
  
  /**
   * 格式化时间
   * @param date string yyyymm格式
   * @param type 格式形式 如 mm...
   * @return 格式后时间
   */
  public static String formatDateYYYYMM(String date,String type) {
    if(date == null || "".equals(date)){
	   return "";
    }
	//设置初始值
	type = type == null ? "yyyyMM" : type;
	Calendar calendar = Calendar.getInstance();
	calendar.set(Calendar.DATE, 2);
  	calendar.set(Calendar.YEAR, Integer.parseInt(date.substring(0,4)));
  	calendar.set(Calendar.MONTH, Integer.parseInt(date.substring(4,6)));
	SimpleDateFormat format =  new SimpleDateFormat(type);
	return format.format(calendar.getTime());
  }
  /**
   * 格式化时间
   * @param date string yyyy-mm-dd 格式
   * @param type 格式形式 如 mm...
   * @return 格式后时间
   */
  public static String formatDateYYYYMMDD(String date,String type){
	   if(date == null || "".equals(date)){
		   return "";
	   }
		Calendar calendar = Calendar.getInstance();     
		calendar.set(Calendar.YEAR, Integer.parseInt(date.split("-")[0]));     
		calendar.set(Calendar.MONTH, Integer.parseInt(date.split("-")[1])-1);     
		calendar.set(Calendar.DAY_OF_MONTH,Integer.parseInt(date.split("-")[2])); 
		return new SimpleDateFormat(type).format(calendar.getTime());
  }
  
  /**
   * 格式化时间
   * @param times Integer unix时间戳
   * @param type 格式形式 如 mm...
   * @return 格式后时间
   */
  public static String getStringByTimeStemp(Integer times, String type) {
	   if(times == null){
		   return "";
	   }
	   //设置初始值
	   type = type == null ? "YYYY年MM月dd日" : type;
	   SimpleDateFormat format =  new SimpleDateFormat(type);
	   String time = "";
	   long time1 = times*1000l;
		   try {
			   time = format.format(time1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		   return time;
  }

  public static Integer getMaxDayByDate(Integer year, Integer month) {
	  Calendar calendar = Calendar.getInstance();
	  calendar.set(Calendar.YEAR, year);     
	  calendar.set(Calendar.MONTH, month - 1);     
	  calendar.set(Calendar.DAY_OF_MONTH, 1);//防止当前日期day超过指定月最大天数
	  int day = calendar.getActualMaximum(Calendar.DATE);
	  
	  return day;
  }
  
  	//获取系统当前日期(yyyy-MM-dd HH:mm:ss)
	public static String getCurrentDayString1(){
		Calendar calendar = Calendar.getInstance() ;
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
	}
  
	//获取系统当前日期(yyyy-MM-dd HH:mm:ss)
	public static String getCurrentDayString2(){
		Calendar calendar = Calendar.getInstance() ;
		calendar.set(Calendar.SECOND, calendar.getTime().getSeconds() + 1); 
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
	}
  /**
   * 获取一个月的天数
   * @param year 年份 ex：2017
   * @param month 月份 ex：6
   * @param type 格式形式 如 mm...
   * @return 指定月份每日日期，格式后时间list
   */
  public static List<String> getDateListByMonth(Integer year, Integer month, String type) {
	   if(year == null || month == null){
		   return null;
	   }
	   List<String> dates = new ArrayList<String>();
	   //获取指定月最大值
	   Integer maxday = getMaxDayByDate(year, month);
	   for (int day = 1; day < maxday + 1; day++) {
		   String date = year + "-" + month + "-" + day;
		   String daytime = formatDateYYYYMMDD(date, type);
		   dates.add(daytime);
	   }
	   return dates;
  }

	/**
	 * 将2016-06-27T09:46:27.000Z格式转为yyyy-MM-dd HH:mm:ss
	 * @param
	 * @throws Exception
	 */
	public static String parseDateToDatetime(String dateTime) throws Exception{
		String replace = dateTime.replace("T", " ");
		int index = replace.lastIndexOf(".");
		String substring = replace.substring(0, index);
		return substring;
	}
	
	//获取系统当前年份
	public static int getDays(String date1,String date2) throws ParseException{
		Date a1 = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
		Date b1 = new SimpleDateFormat("yyyy-MM-dd").parse(date2);
    	return (int) ((b1.getTime()-a1.getTime())/(24*60*60*1000));
	}

	// 两个时间间隔天数
	public static int differentDaysByMillisecond(Date date1,Date date2)
	{
		int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
		return Math.abs(days);
	}

	// 根据yyyy-MM-dd HH:mm:ss 字符串，获取yyyy-MM-dd 部分
	public static String getDate(String datetime){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return LocalDate.parse(datetime,formatter).toString();
	}

	// 根据yyyy-MM-dd HH:mm:ss 字符串，获取HH:mm:ss 部分
	public static String getDateTime(String datetime){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime parse = LocalDateTime.parse(datetime, formatter);
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm:ss");
		return parse.format(formatter1);
	}

}
