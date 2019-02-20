package test;

import org.junit.Test;

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

        //2.使用lambda表达式进行事件处理
        //Java 8之前


    }

}
