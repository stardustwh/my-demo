package beautifulconcurrent;

public class ThreadTest {

    // 继承Thread类
    public static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println(" I am a child thread");
        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();

        thread.start();

        MyThread thread1 = new MyThread();
        thread1.start();

    }
}
