package cw.demo.concurrent.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by cw on 2018/3/13.
 */
public class LockSupportDemo extends Thread {
    /*
    LockSupport 提供park()和unpark()方法实现阻塞线程和解除线程阻塞，LockSupport和每个使用它的线程都与一个许可(permit)关联。permit相当于1，0的开关，默认是0，调用一次unpark就加1变成1，调用一次park会消费permit, 也就是将1变成0，同时park立即返回。再次调用park会变成block（因为permit为0了，会阻塞在这里，直到permit变为1）, 这时调用unpark会把permit置为1。每个线程都有一个相关的permit, permit最多只有一个，重复调用unpark也不会积累。

park()和unpark()不会有 “Thread.suspend和Thread.resume所可能引发的死锁” 问题，由于许可的存在，调用 park 的线程和另一个试图将其 unpark 的线程之间的竞争将保持活性。
     */

    static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new LockSupportDemo();
        Thread t2 = new LockSupportDemo();
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        Thread.sleep(100);
        t2.start();
        LockSupport.unpark(t1);
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
        System.out.println("exit");
    }

    @Override
    public void run() {
        synchronized (object) {
            System.out.println("in " + this.getName());
            LockSupport.park();
        }
    }
}
