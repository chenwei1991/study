package cw.demo.concurrent.lock;

import java.util.concurrent.Semaphore;

/**
 * Created by cw on 2018/3/12.
 */
public class SemaphoreDemo extends Thread {
    static Semaphore semaphore = new Semaphore(5);

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Thread t = new SemaphoreDemo();
            t.setName("t" + i);
            t.start();
        }
    }

    @Override
    public void run() {
        try {
            //semaphore.acquire();
            semaphore.acquire(2); // 可以传参，一次拿多个许可，不传默认拿一个许可
            //semaphore.acquireUninterruptibly(); // 无中断的
            //semaphore.tryAcquire() // 可限时的
            Thread.sleep(2000);
            System.out.println(this.getName() + "done"); // 一共5个许可，一次只能进来5个线程。每隔2秒打印5条记录

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //semaphore.release();
            semaphore.release(2);
        }
    }
}
