package com.ericsson.eqinson.thread;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by eqinson on 2016/10/1.
 */
public class Problem1 {
    private static AtomicReference<String> r = new AtomicReference<>("");

    public static void main(String... args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            final int num = i;
            new Thread(
                    () -> {
                        StringBuilder sb = new StringBuilder(num);
                        for (int j = 0; j < num; j++)
                            sb.append("k");
                        String s = sb.toString();
                        r.updateAndGet(x -> x.length() > s.length() ? x : s);
                    }
            ).start();
        }
        Thread.sleep(1000 * 5);
        System.out.println(r.get());
    }
}
