package cw.demo.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by cw on 2018/3/10.
 */
public class AtomicIntegerDemo extends Thread {
    private static AtomicInteger i = new AtomicInteger(0);
    private static int k=0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new AtomicIntegerDemo();
        Thread t2 = new AtomicIntegerDemo();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i.intValue());
        System.out.println(k);
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            i.incrementAndGet();
            k++;
        }
    }
}
