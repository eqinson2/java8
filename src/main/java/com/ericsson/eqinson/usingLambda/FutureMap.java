package com.ericsson.eqinson.usingLambda;

import java.util.concurrent.*;
import java.util.function.Function;

/**
 * Created by eqinson on 2016/10/1.
 */
public class FutureMap {
    public static <T, U> Future<U> map(Future<T> future, Function<T, U> f) {
        return new Future<U>() {
            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                return false;
            }

            @Override
            public boolean isCancelled() {
                return false;
            }

            @Override
            public boolean isDone() {
                return false;
            }

            @Override
            public U get() throws InterruptedException, ExecutionException {
                return f.apply(future.get());
            }

            @Override
            public U get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                return f.apply(future.get());
            }
        };
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        Future<String> f1 = pool.submit(() -> "123");
        try {
            System.out.println(map(f1, String::valueOf).get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
