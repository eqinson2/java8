package com.ericsson.eqinson.usingLambda;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by eqinson on 2016/10/1.
 */
public class WithLock {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        withLock(lock, () -> System.out.println("I am in lock..."));
    }

    private static void withLock(ReentrantLock lock, Runnable r) {
        lock.lock();
        try {
            r.run();
        } finally {
            lock.unlock();
        }
    }
}
