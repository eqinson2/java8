package com.ericsson.eqinson.streamAPI;

import java.io.IOException;
import java.math.BigInteger;
import java.util.stream.Stream;

/**
 * Created by eqinson on 2016/9/30.
 */
public class Infinite {
    public static void main(String[] args) throws IOException {
        Stream<String> echos = Stream.generate(() -> "Echo");
        echos.limit(1000).forEach(System.out::println);

        Stream<Double> randoms = Stream.generate(Math::random);
        randoms.limit(1000).forEach(System.out::println);

        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
        integers.limit(1000).forEach(System.out::println);

        integers = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE)).peek(e -> System.out.println("Fetching " + e));
        integers.limit(100).count();
    }
}
