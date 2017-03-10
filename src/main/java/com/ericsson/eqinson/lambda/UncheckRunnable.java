package com.ericsson.eqinson.lambda;

/**
 * Created by eqinson on 2016/9/29.
 */

interface RunnableEx {
    public void run() throws Exception;
}

public class UncheckRunnable {
    public static Runnable uncheck(RunnableEx runner) {
        return () -> {
            try {
                runner.run();
            } catch (Exception e) {
            }
        };
    }

    public static void main(String[] args) {
        new Thread(uncheck(() -> {
            System.out.println("zzz");
            Thread.sleep(3000);
        })).start();
    }
}
