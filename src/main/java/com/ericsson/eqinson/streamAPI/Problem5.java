package com.ericsson.eqinson.streamAPI;

import java.util.stream.Stream;

public class Problem5 {
    public static void main(String[] args) {
        Stream<Long> integers = Stream.iterate(1L, n -> (25214903917L * n + 11) % (long) Math.pow(2, 48));
        integers.limit(20).forEach(System.out::println);
    }
}
