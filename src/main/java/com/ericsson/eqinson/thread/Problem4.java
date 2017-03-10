package com.ericsson.eqinson.thread;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.LongStream;

public class Problem4 {
    private static int size = 100000;
    private static long[] array = new long[size];

    public static void main(String... args) throws Exception {
        process1();
        //process2();
    }

    private static void process1() throws InterruptedException {
        Random rand = new Random();
        Arrays.parallelSetAll(array, i -> rand.nextLong());
        LongAccumulator ac = new LongAccumulator(Math::min, 0L);
        int nThreads = Runtime.getRuntime().availableProcessors();
        CountDownLatch latch = new CountDownLatch(nThreads);
        ExecutorService pool = Executors.newFixedThreadPool(nThreads);
        int chunkSize = size / nThreads;
        for (int i = 0; i < nThreads; i++) {
            final int index = i;
            pool.submit(
                    () -> {
                        int start = index * chunkSize;
                        int end = (index + 1) * chunkSize;
                        for (int j = start; j < end; j++)
                            ac.accumulate(array[j]);
                        latch.countDown();
                    }
            );
        }
        latch.await();
        System.out.println(ac.get());
    }

    private static void process2() {
        Random rand = new Random();
        Arrays.parallelSetAll(array, i -> rand.nextLong());
        LongAccumulator ac = new LongAccumulator(Math::max, 0L);
        LongStream.of(array).parallel().forEach(ac::accumulate);
        System.out.println(ac.get());
    }
}
