package beautifulconcurrent;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestTimer {

    static Timer timer = new Timer();

    static ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);

    public static void main(String[] args) {
        /*timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("---one Task---");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                throw new RuntimeException("error");
            }
        },500);*/

      /*  timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (;;) {
                    System.out.println("---two Task---");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        },1000);*/

      scheduledThreadPoolExecutor.schedule(new Runnable() {
          @Override
          public void run() {
              System.out.println("---one Task---");

              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              throw new RuntimeException("error");
          }
      },500, TimeUnit.MICROSECONDS);

      scheduledThreadPoolExecutor.schedule(new Runnable() {
          @Override
          public void run() {
              for (;;) {
                  System.out.println("---two Task---");

                  try {
                      Thread.sleep(1000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
          }
      },1000,TimeUnit.MICROSECONDS);

      scheduledThreadPoolExecutor.shutdown();
    }
}
