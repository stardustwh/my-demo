package beautifulconcurrent;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestSimpleDateFormat {

//    static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static ThreadLocal<DateFormat> sagesf = new ThreadLocal<DateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
};

    public static void main(String[] args) {
        for (int i = 0; i<10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(sagesf.get().parse("2019-11-07 10:15:33"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }
}
