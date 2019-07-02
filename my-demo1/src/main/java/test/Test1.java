package test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import sun.net.www.http.HttpClient;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * Java 8 lambda表达式例子
 */

public final class Test1 implements java.io.Serializable, Comparable<String>, CharSequence  {



    @Test
    public void test(){
        //1.用lambda表达式实现Runnable
        //Java 8 之前
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("java 8 之前...");
            }
        }).start();

        //Java 方式
        new Thread( () -> System.out.println("java 8 现在。。。")).start();



    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }

    @Override
    public IntStream chars() {
        return null;
    }

    @Override
    public IntStream codePoints() {
        return null;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    class SharedVariableThread extends Thread {
        private int count = 5;

        @Override
        public void run() {
            super.run();
            count--;
            System.out.println("由 " + SharedVariableThread.currentThread().getName() + "计算，count=" + count);
        }


    }

    @Test
    public void test1(){

        SharedVariableThread mythread = new SharedVariableThread();

        Thread a = new Thread(mythread, "A");
        Thread b = new Thread(mythread, "B");
        Thread c = new Thread(mythread, "C");
        Thread d = new Thread(mythread, "D");
        Thread e = new Thread(mythread, "E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }

    public Integer test2(Integer i,Integer j){



        return null;
    }

    @Test
    public void test3(){

        Double a = 0.0;
        Double b = 0.0;
        Double count = a+b;
        long x = 1390147200000L;
        System.out.println(DateUtil.getStringByTimeStemp((int)(x/1000))+"__--------------------");
    }


    @Test
    public void test4(){

        String[] arrs =  {"aa","bbb","ccc"};

        List<String> list = Arrays.stream(arrs).collect(Collectors.toList());
        Arrays.stream(arrs).filter(s->s.startsWith("a")).forEach(System.out::println);

        //list.get(0) -> System.out::println;
        System.out.println(list.get(0));
    }

    @Test
    public void test5(){
        /*byte b1 = 1, b2 = 2, b3, b6;
        final byte b4 = 4, b5 = 6;
        b6 = b4 + b5;
        //b3 = (b1 + b2);
        //System.out.println(b3 + b6);
        int i = 40;
        String s1 = String.valueOf(i < 50 ? 233 : 666);
        String s2 = String.valueOf(i < 50 ? 233 : 666.0);
        assertEquals(true, s1.equals(s2));*/

        /*int count = 0;
        for(int i = 0; i < 10; i++) {
            count = ++count;
        }*/
        System.out.println(Double.NaN == Double.NaN);



    }

    @Test
    public void test6(){

       /* String result = HttpClientTool.httpget("https://sp0.baidu.com/8aQDcjqpAAV3otqbppnN2DJv/api.php?query=2019-06&resource_id=6018&format=json","",false);
        JSONObject jsonObject = JSONObject.parseObject(result);
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        JSONObject jsonObject1 = JSONObject.parseObject(jsonArray.toJSONString());*/

        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar calendar=Calendar.getInstance();
        calendar.set(2017, 6, 1);
        long next =calendar.getTimeInMillis();
        calendar.add(Calendar.MONTH,-1);
        while(calendar.getTimeInMillis()!=next)
        {
            System.out.println(calendar.getTime().toLocaleString());
            int w = calendar.get(Calendar.DAY_OF_WEEK)-1;
            if (w<0) {
                w=0;
            }
            System.out.println(weekDays[w]);
            int i=1;
            calendar.add(Calendar.DAY_OF_MONTH, i++);
        }


    }

    @Test
    public void test7(){

         String s = "22";
         s.hashCode();

    }

}
