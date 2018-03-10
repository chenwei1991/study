package cw.demo.thread.wait;

/**
 * Created by cw on 2018/3/10.
 */
public class ObjectWaitNotify {
    static final Object OBJECT = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1=new T1();
        Thread t2=new T2();
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        Thread.sleep(100); // 确保wait先执行
        t2.start();
    }

    public static class T1 extends Thread {
        @Override
        public void run() {
            synchronized (OBJECT) {
                System.out.println("T1 start");
                try {
                    OBJECT.wait(); // wait方法的调用，必须获取到对象的锁才能进行。当调用完成时，会释放锁。被唤醒时，重新获得锁后（并不是notify()调用完成就能立即执行），然后继续执行
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1 end");
            }
        }
    }

    public static class T2 extends Thread {
        @Override
        public void run() {
            synchronized (OBJECT) {
                System.out.println("T2 start");
                OBJECT.notify();
                System.out.println("T2 end");
                try {
                    Thread.sleep(2000); //notify调用后，线程的过程，锁并没有释放，wait的线程仍然不会执行
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
