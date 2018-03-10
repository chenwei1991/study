package cw.demo.thread;

/**
 * Created by cw on 2018/3/7.
 */
public class Interrupt extends Thread {
    public static void main(String[] args) throws InterruptedException {
        Interrupt interrupt = new Interrupt();
        interrupt.start();
        Thread.sleep(1000);
        interrupt.interrupt(); // 调用中断只是设置一个中断标记，线程内部需要调用Thread.isInterrupted()方法进行判断，再进行处理，以达到优雅退出线程的目的
        System.out.println("--------");
    }

    @Override
    public void run() {
        while (true) {
            if (this.isInterrupted()) {
                System.out.println("exit");
                break;
            }

            try {
                System.out.println("begin");
                this.sleep(3000); // sleep等使线程等待的方法之所以会抛出中断异常，是为了快速响应外部的发出的中断通知
                System.out.println("end");
            } catch (InterruptedException e) {
                System.out.println("interrupted");
                this.interrupt(); // sleep()方法在抛出中断异常时，会清除中断标记位，所以如果需要进行线程中断，这里需要再次调用中断方法

            }
        }
    }
}

/** out

 begin
 --------
 interrupted
 exit

 */