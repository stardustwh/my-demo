package beautifulconcurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ThreadTest {

    // 继承Thread类
    public static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println(" I am a child thread");
        }
    }

    public static void main(String[] args) {
       /* MyThread thread = new MyThread();

        thread.start();

        MyThread thread1 = new MyThread();
        thread1.start();*/

        List<String> userNames = new ArrayList<String>() {{
            add("Hollis");
            add("hollis");
            add("HollisChuang");
            add("H");
        }};


        Iterator<String> iterator = userNames.iterator();
        while (iterator.hasNext()) {
            String userName = iterator.next();
            if (userName.equals("Hollis")) {
                /*userNames.remove(userName);*/
                //userNames.remove(0);
               iterator.remove();
            }
        }
      /*  for (String userName : userNames) {
            if (userName.equals("Hollis")) {
                *//*userNames.remove(userName);*//*
                //userNames.remove(0);
                userNames.iterator().remove();
            }
        }*/

        System.out.println(userNames);

    }
}
