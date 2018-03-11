package cw.demo.concurrent.sycn;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by cw on 2018/3/12.
 */
public class ReentrantLockTryDemo extends Thread {
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new ReentrantLockTryDemo();
        Thread t2 = new ReentrantLockTryDemo();
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();

    }

    @Override
    public void run() {
        try {
            if (lock.tryLock(3, TimeUnit.SECONDS)) {
                System.out.println(this.getName() + "获得锁");
                Thread.sleep(4000);
            } else {
                System.out.println(this.getName() + "获取锁失败");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }
}
