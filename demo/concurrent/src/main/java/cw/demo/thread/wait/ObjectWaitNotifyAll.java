package cw.demo.thread.wait;

/**
 * Created by cw on 2018/3/10.
 */
public class ObjectWaitNotifyAll {
    static final Object OBJECT = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new T1();
        Thread t11 = new T1();
        Thread t2 = new T2();
        t1.setName("t1");
        t11.setName("t11");
        t2.setName("t2");

        t1.start();
        t11.start(); // 多个线程进行wait操作时，会进入一个wait队列，调用notifyAll时，会唤醒所有等待中的线程，然后这些被唤醒的线程，会竞争对象上的锁，获得锁的线程会立即执行，其他线程继续等待获得锁，才能继续执行
        Thread.sleep(100);
        t2.start();
        // 程序正常退出
    }

    public static class T1 extends Thread {
        @Override
        public void run() {
            synchronized (OBJECT) {
                System.out.println(this.getName() + " start");
                try {
                    OBJECT.wait();
                    Thread.sleep(2000); // 所有等待中的线程被唤醒时，只有一个线程能获得锁，执行耗时2秒，其他的线程需要等待2秒才能获得锁继续执行
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this.getName() + " end");
            }
        }
    }

    public static class T2 extends Thread {
        @Override
        public void run() {
            synchronized (OBJECT) {
                System.out.println(this.getName() + " start");
                OBJECT.notifyAll();
                System.out.println(this.getName() + " end");
            }
        }
    }
}
