package cw.demo.thread;

/**
 * Created by cw on 2018/3/8.
 */
public class BadSuspend extends Thread {
    private static Object object = new Object();

    public BadSuspend(String name) {
        super(name);
    }

    public static void main(String[] args) throws InterruptedException {
        BadSuspend t1 = new BadSuspend("t1");
        BadSuspend t2 = new BadSuspend("t2");
        t1.start();
        Thread.sleep(100);
        t2.start();
        t1.resume();
        t2.resume(); // 由于t1 resume之后，还有一个t1释放锁的过程，导致t2 resume在t2 supend之前，这样实际上resume时什么都没做，t2 supend之后，再也不会resume
        t1.join();
        t2.join(); // t2永远等不到结束
    }

    @Override
    public void run() {
        synchronized (object) {
            System.out.println("in " + this.getName());
            this.suspend(); // suspend时，线程仍然是Runnable状态
        }
    }
}
