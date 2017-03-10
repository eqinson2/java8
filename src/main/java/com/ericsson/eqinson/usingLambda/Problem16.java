package com.ericsson.eqinson.usingLambda;

import java.util.concurrent.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Created by eqinson on 2016/10/1.
 */
public class Problem16 {
    public static <T> void doInOrderAsync(BiConsumer<T, Throwable> biConsumer, T s, Throwable ex) {
        Thread t = new Thread(() -> biConsumer.accept(s, ex));
        t.start();
    }

    public static <T> void doInOrderAsync2(Runnable first, Runnable second, Consumer<Throwable> handler) {
        Thread thread1 = new Thread(() -> {
            try {
                first.run();
            } catch (Throwable t) {
                handler.accept(t);
            }
        }
        );
        Thread thread2 = new Thread(() -> {
            try {
                second.run();
            } catch (Throwable t) {
                handler.accept(t);
            }
        }
        );
        thread1.start();
        thread2.start();
    }

    public static <T> void doInOrderAsync3(Callable<T> first, Callable<T> second, Consumer<Throwable> handler) {
        ExecutorService pool = Executors.newCachedThreadPool();
        Future f1 = pool.submit(first);
        Future f2 = pool.submit(second);
        try {
            f1.get();
            f2.get();
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
            handler.accept(e);
        }
    }

    public static void main(String[] args) {
        String s = "www";
        doInOrderAsync((c1, except) -> {
            System.out.println(c1);
            try {
                throw except;
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }, s, new RuntimeException());

        doInOrderAsync3(() -> {
            return "1";
        }, () -> {
            throw new RuntimeException();
        }, System.out::println);
    }
}
