package cw.demo.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created by cw on 2018/3/11.
 */
public class AtomicIntegerFieldUpdaterDemo {
    static final AtomicIntegerFieldUpdater UPDATER = AtomicIntegerFieldUpdater.newUpdater(Candidate.class, "score");

    public static void main(String[] args) throws InterruptedException {
        final AtomicInteger i = new AtomicInteger(0);
        final Candidate candidate = new Candidate();
        Thread[] threads = new Thread[2];
        for (int j = 0; j < 2; j++) {
            threads[j] = new Thread() {
                @Override
                public void run() {
                    for (int k = 0; k < 1000000; k++) {
                        UPDATER.incrementAndGet(candidate);
                        i.incrementAndGet();
                        candidate.cid++;
                        candidate.id++;

                    }
                }
            };
            threads[j].start();
        }
        for (int j = 0; j < 2; j++) {
            threads[j].join();
        }
        System.out.println(candidate.score);
        System.out.println(i.intValue());
        System.out.println(candidate.id);
        System.out.println(candidate.cid);

    }

    static class Candidate {
        int id;
        volatile int cid;
        volatile int score;
    }
}
