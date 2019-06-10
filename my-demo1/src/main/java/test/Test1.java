package test;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Java 8 lambda表达式例子
 */

public class Test1 {

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

}
