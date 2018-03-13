package cw.demo.concurrent.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by cw on 2018/3/13.
 */
public class ReadWriteLockDemo extends Thread {
    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock(); // 读读不互斥，读写、写写互斥

    public static void main(String[] args) {
        Thread t1 = new ReadWriteLockDemo();
        Thread t2 = new ReadWriteLockDemo();
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        try {
            lock.readLock().lock();
            System.out.println(this.getId() + "获得锁");
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(this.getId() + "释放锁");
            lock.readLock().unlock();
        }

    }
}
