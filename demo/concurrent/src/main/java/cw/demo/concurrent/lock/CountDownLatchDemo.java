package cw.demo.concurrent.lock;

import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.CountDownLatch;

/**
 * Created by cw on 2018/3/13.
 */
public class CountDownLatchDemo extends Thread {
    static CountDownLatch countDownLatch = new CountDownLatch(5);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            new CountDownLatchDemo().start();
        }
        countDownLatch.await();
        System.out.println("计数结束");
    }

    @Override
    public void run() {
        try {
            Thread.sleep(RandomUtils.nextInt(0, 5000));
            System.out.println(this.getId() + "countDown");
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
