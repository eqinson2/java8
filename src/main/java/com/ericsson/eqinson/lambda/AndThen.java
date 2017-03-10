package com.ericsson.eqinson.lambda;

/**
 * Created by eqinson on 2016/9/29.
 */
public class AndThen {
    private static void andThen(Runnable r1, Runnable r2) {
        new Thread(() -> {
            r1.run();
            r2.run();
        }).start();
    }

    public static void main(String[] args) {
        andThen(() -> System.out.println("ZZZ"), () -> System.out.println("KKK"));
    }
}
