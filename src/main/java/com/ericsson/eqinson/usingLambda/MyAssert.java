package com.ericsson.eqinson.usingLambda;

import java.util.function.Predicate;

public class MyAssert {
    private static <T> void myAssert(T x, Predicate<T> condition) {
        if (!condition.test(x))
            throw new AssertionError();
    }

    public static void main(String[] args) {
        myAssert(2, x -> x > 0);
        myAssert(-1, x -> x > 0);
    }
}
