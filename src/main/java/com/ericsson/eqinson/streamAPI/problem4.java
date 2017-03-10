package com.ericsson.eqinson.streamAPI;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class problem4 {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4};
        Stream<int[]> s = Stream.of(values);

        Stream.of(1, 2, 3, 4);

        IntStream ss = IntStream.of(1, 2, 3, 4, 5);
        System.out.print(ss.min().getAsInt());
    }
}
