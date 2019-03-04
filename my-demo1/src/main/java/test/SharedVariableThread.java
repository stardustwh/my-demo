package test;

import org.junit.Test;

public class SharedVariableThread extends Thread {
    private int count = 5;

    @Override
    public void run() {
        while (count > 0) {
            count--;
            System.out.println("由 " + SharedVariableThread.currentThread().getName() + " 计算，count=" + count);
        }
    }

    public SharedVariableThread(String name) {
        super();
        this.setName(name);
    }

    public static void main(String[] args) {

        //SharedVariableThread mythread = new SharedVariableThread();

        /*Thread a = new Thread(mythread, "A");
        Thread b = new Thread(mythread, "B");
        Thread c = new Thread(mythread, "C");
        Thread d = new Thread(mythread, "D");
        Thread e = new Thread(mythread, "E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();*/

        SharedVariableThread a = new SharedVariableThread("A");
        SharedVariableThread b = new SharedVariableThread("B");
        SharedVariableThread c = new SharedVariableThread("C");
        a.start();
        b.start();
        c.start();
    }
}