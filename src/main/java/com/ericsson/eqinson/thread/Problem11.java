package com.ericsson.eqinson.thread;

import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Problem11 {
    public static <T> CompletableFuture<T> repeat(Supplier<T> action, Predicate<T> until) {
        CompletableFuture<T> future = CompletableFuture.supplyAsync(action::get);

        future.thenAccept(r -> {
            if (!until.test(r))
                repeat(action, until);
            else
                System.out.println(r);
        });

        return future;
    }
}
