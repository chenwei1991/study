package cw.demo.concurrent.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by cw on 2018/3/13.
 */
public class CyclicBarrierDemo extends Thread {
    static AtomicInteger i = new AtomicInteger(0);
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
        System.out.println("集齐龙珠成功，召唤神龙");
    }); // 初始化，当有7个线程使用该对象进行await时，集齐成功，执行Runnable接口

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        for (int i = 0; i < 7; i++) {
            Thread t = new CyclicBarrierDemo();
            t.setName("t" + i);
            t.start();
            //if (i == 5) {
            //    t.interrupt(); // 线程5中断，会导致await的线程broken
            //}
        }
    }

    @Override
    public void run() {
        try {
            System.out.println("收集一个龙珠");
            cyclicBarrier.await();
            System.out.println("第二次收集龙珠");
            cyclicBarrier.await();

        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupt");
            //e.printStackTrace();
        } catch (BrokenBarrierException e) {
            System.out.println(getName() + " broken");  // 某一个await的线程，如果发生interrupted，其它的await的线程就会发生broken
            //e.printStackTrace();
        }
    }
}
