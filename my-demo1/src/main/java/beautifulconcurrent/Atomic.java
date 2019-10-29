package beautifulconcurrent;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * 统计0的个数
 */
public class Atomic {

    private static AtomicLong atomicLong = new AtomicLong();

    private static Integer[] arrayOne = new Integer[] {0 , 1 , 2 , 3 , 0 , 5 , 6 , 0 , 56 , 0} ;
    private static Integer[] arrayTwo =new Integer[] {10 , 1 , 2 , 3 , 0 , 5 , 6 , 0 , 56 , 0} ;

    LongAdder longAdder = new LongAdder();


    public static void main(String[] args) throws InterruptedException{

        Thread threadOne = new Thread(new Runnable() {
            public void run() {

                int size  = arrayOne.length;
                for (int i = 0; i<size; i++) {
                    if (arrayOne[i].intValue() == 0) {
                        atomicLong.incrementAndGet();
                    }
                }
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            public void run() {
                int size = arrayTwo.length;
                for (int i = 0; i<size; i++) {
                    if (arrayTwo[i].intValue() == 0) {
                        atomicLong.incrementAndGet();
                    }
                }
            }
        });

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

        System.out.println("count 0:" + atomicLong.get());
    }

}
