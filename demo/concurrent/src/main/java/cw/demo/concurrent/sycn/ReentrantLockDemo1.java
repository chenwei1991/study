package cw.demo.concurrent.sycn;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by cw on 2018/3/11.
 */
public class ReentrantLockDemo1 extends Thread{
    static ReentrantLock lock=new ReentrantLock();
    static int j=0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new ReentrantLockDemo1();
        Thread t2 = new ReentrantLockDemo1();
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
            lock.lock(); //同一个线程可以多次获得锁（获得多个许可），相应的，释放的时候就要释放多次（释放所有获得的许可，否则其它线程不能获得许可）
            try {
                j++;
            }finally {
                lock.unlock(); // 写在finally里面防止发生异常时，不能正常释放锁
                lock.unlock();
            }
        }
    }
}
