package beautifulconcurrent;

public class ThreadDemo {

/*    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    System.out.println("threadOne begin sleep for 2000 seconds");
                    Thread.sleep(2000000);
                    System.out.println("theadOne awaking");
                } catch (InterruptedException e) {
                    System.out.println("threadOne is interrupted while sleeping");
                    return;
                }

                System.out.println("threadOne-leaving normally");
            }
        });

        threadOne.start();

        Thread.sleep(1000);

        threadOne.interrupt();

        threadOne.join();

        System.out.println("main thread is over");
    }*/

    public static void main(String[] args) throws InterruptedException{

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;) {

                }
            }
        });

        threadOne.start();

        threadOne.interrupt();

        System.out.println("isInterrupted:" + threadOne.isInterrupted());

        System.out.println("isInterrupted:" + threadOne.interrupted());

        System.out.println("isInterrupted:" + Thread.interrupted());

        System.out.println("isInterrupted:" + threadOne.isInterrupted());

        threadOne.join();

        System.out.println("main thread is over");
    }
}
