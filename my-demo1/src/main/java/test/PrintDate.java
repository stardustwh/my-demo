package test;

import java.util.Calendar;

public class PrintDate {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Calendar calendar=Calendar.getInstance();//当前日期
        calendar.set(2021, 6, 1);
        int year=calendar.get(Calendar.YEAR);//2010
        int nextyear=calendar.get(Calendar.YEAR)+2;//2011;
        Calendar nowyear=Calendar.getInstance();
        Calendar nexty=Calendar.getInstance();
        nowyear.set(year, 0, 1);//2010-1-1
        nexty.set(nextyear, 0, 1);//2011-1-1

        //calendar.add(Calendar.DAY_OF_MONTH, -calendar.get(Calendar.DAY_OF_WEEK));//周六
        calendar.add(Calendar.DAY_OF_MONTH, -calendar.get(Calendar.DAY_OF_WEEK)+1);//周日
        Calendar c=(Calendar) calendar.clone();
        for(;calendar.before(nexty)&&calendar.after(nowyear);calendar.add(Calendar.DAY_OF_YEAR, -7)){
            printf(calendar);
        }
        for(;c.before(nexty)&&c.after(nowyear);c.add(Calendar.DAY_OF_YEAR, 7)){
            printf(c);
        }


        
    }

    //打印
    public static void printf(Calendar calendar)
    {
        System.out.println("holidayArray.push('"+calendar.get(Calendar.YEAR)+"-"+(1+calendar.get(Calendar.MONTH))+"-"+calendar.get(Calendar.DATE)+"');");

    }
}