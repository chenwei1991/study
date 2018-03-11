package cw.demo.concurrent.thread;

/**
 * Created by cw on 2018/3/10.
 */
public class Visibility extends Thread {
    private boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        Visibility visibility = new Visibility();
        visibility.start();
        Thread.sleep(1000);
        visibility.setStop();
        visibility.join();  // 虽然主线程修改了stop变量，但对子线程来说是不可见的，所以exit不会输出。如果把stop变量声明成volatile，则程序可以退出
        // 线程变量可见性问题导致的原因有多种，如指令重排、cpu缓存没有同步到内存、编译优化（）等
        System.out.println("exit");
    }

    @Override
    public void run() {
        int i = 0;
        while (!stop) {
            i++;
        }
        System.out.println("end");
    }

    public void setStop() {
        this.stop = true;
    }
}
