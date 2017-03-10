package com.ericsson.eqinson.lambda;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by eqinson on 2016/9/29.
 */

interface Collection2<T> extends java.util.Collection<T> {
    default void forEachIf(Consumer<T> action, Predicate<T> filter) {
        this.stream().filter(filter).forEach(action);
    }
}

class MyArrayList<T> extends ArrayList<T> implements Collection2<T> {
}

public class Collection {
    public static void main(String[] args) {
        Collection2<String> c = new MyArrayList<String>();
        c.add("eqinson");
        c.add("eqinson*");
        c.forEachIf(System.out::println, (str) -> str.endsWith("*"));
    }
}
