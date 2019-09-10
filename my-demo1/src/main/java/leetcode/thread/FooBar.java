package leetcode.thread;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class FooBar {
    private int n;
    private CyclicBarrier cyclicBarrier;
    private CountDownLatch countDownLatch;

    public FooBar(int n) {
        this.n = n;
        cyclicBarrier = new CyclicBarrier(2);
        countDownLatch = new CountDownLatch(1);
    }


    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            try {

                printFoo.run();
                countDownLatch.countDown();
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {

                countDownLatch.await();
                printBar.run();
                countDownLatch = new CountDownLatch(1);
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {


        FooBar f = new FooBar(10);

        Thread t1 = new Thread(() -> {
            try {
                f.foo(() -> {
                    System.out.print("foo");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                f.bar(() -> {
                    System.out.println("bar");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

    }
}
