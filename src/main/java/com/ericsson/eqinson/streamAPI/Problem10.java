package com.ericsson.eqinson.streamAPI;

import java.util.OptionalDouble;
import java.util.stream.Stream;

/**
 * Created by eqinson on 2016/9/30.
 */


public class Problem10 {
    public static void main(String[] args) {
        Stream<Double> doubles = Stream.of(1.0d, 2.0d, 3.0d);
        double sum = doubles.mapToDouble(Double::doubleValue).sum();
        doubles = Stream.of(1.0d, 2.0d, 3.0d);
        OptionalDouble avg = doubles.mapToDouble(Double::doubleValue).average();
        System.out.println(sum);
        System.out.println(avg.getAsDouble());

        doubles = Stream.of(1.0d, 2.0d, 3.0d);
        System.out.println(doubles.reduce((a, b) -> a + b).orElse(0d));
    }
}