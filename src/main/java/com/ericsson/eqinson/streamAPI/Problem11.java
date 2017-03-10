package com.ericsson.eqinson.streamAPI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem11 {
    public static void main(String[] args) throws IOException {
        int[] seq = new int[1000];
        for (int i = 0; i < 1000; i++) seq[i] = i;
        IntStream stream = IntStream.of(seq);
        ArrayList<Integer> arr = new ArrayList<>(1000);
        stream.parallel().forEachOrdered(arr::add);

        String r = arr.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(r);
    }
}
