package com.ericsson.eqinson.usingLambda;

import java.util.function.Supplier;

public class MyIfLogger {
    private Level level = Level.FINEST;

    public static void main(String[] args) {
        MyIfLogger logger = new MyIfLogger();
        int[] a = new int[20];
        for (int i = 0; i < 20; i++)
            a[i] = i;
        for (int i = 0; i < 20; i++) {
            int j = i;
            logger.logIf(Level.FINEST, () -> j == 10, () -> "a[10]= " + a[10]);
        }

    }

    private void logIf(Level level, Supplier<Boolean> condition, Supplier<String> supplier) {
        if (level == this.level && condition.get()) {
            System.out.println(supplier.get());
        }
    }

    private enum Level {
        ERROR, WARNING, INFO, DEBUG, FINEST;
    }

}
