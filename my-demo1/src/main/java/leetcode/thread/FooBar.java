package leetcode.thread;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class FooBar {
    private int n;
    private CyclicBarrier cyclicBarrier;
    private CountDownLatch countDownLatch;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            printFoo.run();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            printBar.run();
        }
    }

    @Test
    public void showThread() {

    }
}
