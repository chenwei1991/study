package cw.demo.concurrent.sycn;


import org.apache.commons.lang3.ArrayUtils;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by cw on 2018/3/11.
 */
public class ReentrantLockInterruptDemo extends Thread {
    static ReentrantLock lock1 = new ReentrantLock();
    static ReentrantLock lock2 = new ReentrantLock();
    int lock = 0;

    public ReentrantLockInterruptDemo(int lock) {
        this.lock = lock;
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockInterruptDemo t1 = new ReentrantLockInterruptDemo(1);
        ReentrantLockInterruptDemo t2 = new ReentrantLockInterruptDemo(2);
        t1.start();
        t2.start();
        Thread.sleep(2000);
        deadlockCheck();
    }

    /**
     * 启动一个死锁检查的后台守护线程，每5秒钟检查一次，发现死锁就把死锁的线程终止掉
     */
    public static void deadlockCheck() {
        final ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    long[] deadlockedThreads = mxBean.findDeadlockedThreads();
                    //ThreadInfo[] threadInfo = mxBean.getThreadInfo(deadlockedThreads);
                    //Arrays.asList(threadInfo).stream().
                    final List<Long> longs = Arrays.asList(ArrayUtils.toObject(deadlockedThreads));
                    Thread.getAllStackTraces().keySet().stream().filter(t -> longs.contains(t.getId())).forEach(t -> t.interrupt());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.setDaemon(true);
        thread.start();
    }

    @Override
    public void run() {
        try {
            if (this.lock == 1) { // t1线程现获取lock1,然后获取lock2
                lock1.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock2.lockInterruptibly();
            } else {  // t2线程先获取lock2 ，然后获取lock1
                lock2.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock1.lockInterruptibly();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock1.isHeldByCurrentThread()) {
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()) {
                lock2.unlock();
            }
            System.out.println("线程" + lock + "退出");
        }
    }
}
