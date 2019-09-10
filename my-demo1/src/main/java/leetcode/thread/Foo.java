package leetcode.thread;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class Foo {

    private CountDownLatch countDownLatchA;
    private CountDownLatch countDownLatchB;
    public Foo() {
        countDownLatchA = new CountDownLatch(1);
        countDownLatchB = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        countDownLatchA.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        countDownLatchA.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        countDownLatchB.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {

        countDownLatchB.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    @Test
    public void showThread() {
        Foo f = new Foo();

        Thread t1 = new Thread(()->{
            try {
                f.first(()->{
                    System.out.println("1");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(()->{
            try {
                f.second(()->{
                    System.out.println("2");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(()->{
            try {
                f.third(()->{
                    System.out.println("3");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
