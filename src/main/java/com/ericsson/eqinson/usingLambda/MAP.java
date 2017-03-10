package com.ericsson.eqinson.usingLambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MAP {
    public static <T, U> List<U> map(List<T> list, Function<T, U> f) {
        return list.stream().map(f::apply).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        map(list, String::valueOf).forEach(System.out::println);
    }
}
