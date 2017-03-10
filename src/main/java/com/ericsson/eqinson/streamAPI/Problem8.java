package com.ericsson.eqinson.streamAPI;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem8 {
    public static void main(String[] args) {
        Stream<String> first = Stream.of("1", "2", "3");
        Stream<String> second = Stream.of("4", "5", "6", "7");
        zip1(first, second).forEach(System.out::println);
        System.out.println();
        first = Stream.of("1", "2", "3");
        second = Stream.of("4", "5", "6", "7");
        zip2(first, second).forEach(System.out::println);
    }

    private static <T> Stream<T> zip1(Stream<T> first, Stream<T> second) {
        Iterator<T> f = first.collect(Collectors.toList()).iterator();
        Iterator<T> s = second.collect(Collectors.toList()).iterator();
        List<T> l = new ArrayList<>();
        while (f.hasNext() && s.hasNext()) {
            l.add(f.next());
            l.add(s.next());
        }
        return l.stream();
    }

    private static <T> Stream<T> zip2(Stream<T> first, Stream<T> second) {
        Iterator<T> f = first.iterator();
        Iterator<T> s = second.iterator();
        List<T> l = new ArrayList<>();
        while (f.hasNext() && s.hasNext()) {
            l.add(f.next());
            l.add(s.next());
        }
        return l.stream();
    }
}
