package cw.demo.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by cw on 2018/3/11.
 */
public class AtomicReferenceDemo {
    private static AtomicReference<String> str = new AtomicReference<String>("abc");

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

            new Thread("t" + i) {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long) (Math.random() * 100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (str.compareAndSet("abc", "def")) {
                        System.out.println(this.getName() + "success");
                    } else {
                        System.out.println(this.getName() + "fail");
                    }
                }
            }.start();
        }
    }
}
