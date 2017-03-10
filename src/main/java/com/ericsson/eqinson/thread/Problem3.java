package com.ericsson.eqinson.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by eqinson on 2016/10/1.
 */
public class Problem3 {
    public static void main(String... args) throws InterruptedException {
        //process1(1000);
        process2(1000);
    }

    private static void process1(int num) throws InterruptedException {
        AtomicLong l = new AtomicLong(0L);
        long start = System.currentTimeMillis();
        final CountDownLatch latch = new CountDownLatch(num);
        for (int i = 0; i < 1000; i++) {
            new Thread(
                    () -> {
                        for (int j = 0; j < 1000000; j++)
                            l.incrementAndGet();
                        latch.countDown();
                    }
            ).start();
        }
        latch.await();
        System.out.println(l.get());
        System.out.println(System.currentTimeMillis() - start);
    }

    private static void process2(int num) throws InterruptedException {
        LongAdder l = new LongAdder();
        long start = System.currentTimeMillis();
        final CountDownLatch latch = new CountDownLatch(num);
        for (int i = 0; i < 1000; i++) {
            new Thread(
                    () -> {
                        for (int j = 0; j < 1000000; j++)
                            l.increment();
                        latch.countDown();
                    }
            ).start();
        }
        latch.await();
        System.out.println(l.sum());
        System.out.println(System.currentTimeMillis() - start);
    }
}
