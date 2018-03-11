package cw.demo.concurrent.thread.wait;

/**
 * Created by cw on 2018/3/10.
 */
public class ObjectWaitNotify1 {
    static final Object OBJECT = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new T1();
        Thread t11 = new T1();
        Thread t2 = new T2();
        t1.setName("t1");
        t11.setName("t11");
        t2.setName("t2");

        t1.start();
        t11.start(); // 多个线程进行wait操作时，会进入一个wait队列，调用notify时，会随机唤醒一个等待中的线程
        Thread.sleep(100);
        t2.start();
        // 程序不能退出，因为只唤醒了一个线程，还有一个线程在wait
    }

    public static class T1 extends Thread {
        @Override
        public void run() {
            synchronized (OBJECT) {
                System.out.println(this.getName() + " start");
                try {
                    OBJECT.wait();
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
                OBJECT.notify();
                System.out.println(this.getName() + " end");
            }
        }
    }
}
