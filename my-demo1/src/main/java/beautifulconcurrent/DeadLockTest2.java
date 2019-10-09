package beautifulconcurrent;

/**
 * 死锁
 */
public class DeadLockTest2 {

    private static Object resourceA = new Object();
    private static Object resourceB = new Object();

    public static void main(String[] args) {

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println(Thread.currentThread() + " get ResourceA");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread() + "waiting get sourceB");
                    synchronized (resourceB) {
                        System.out.println(Thread.currentThread() + "get sourceB");
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceB) {
                    System.out.println(Thread.currentThread() + " get ResourceB");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread() + "waiting get esourceA");

                    synchronized (resourceA) {
                        System.out.println(Thread.currentThread() + "get ResourceA");
                    }
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}
