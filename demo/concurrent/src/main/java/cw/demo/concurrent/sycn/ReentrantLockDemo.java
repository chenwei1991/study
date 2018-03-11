package cw.demo.concurrent.sycn;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by cw on 2018/3/11.
 */
public class ReentrantLockDemo extends Thread{
    static ReentrantLock lock=new ReentrantLock();
    static int j=0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new ReentrantLockDemo();
        Thread t2 = new ReentrantLockDemo();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(j);
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            lock.lock();
            try {
                j++;
            }finally {
                lock.unlock(); // 写在finally里面防止发生异常时，不能正常释放锁
            }
        }
    }
}
