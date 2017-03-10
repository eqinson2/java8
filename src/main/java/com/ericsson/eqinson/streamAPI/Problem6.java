package com.ericsson.eqinson.streamAPI;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by eqinson on 2016/9/29.
 */
public class Problem6 {
    public static void main(String[] args) {
        Stream<String> wordList = Stream.of("123", "45678", "90");
//        wordList.flatMap(Problem6::characterStream).forEach(System.out::println);
        wordList.flatMap(Problem6::characterStream2).forEach(System.out::println);
    }

    private static Stream<Character> characterStream(String s) {
        return Stream.iterate(0, n -> n + 1).limit(s.length()).map(s::charAt);
    }

    private static Stream<Character> characterStream2(String s) {
        return IntStream.range(0, s.length()).boxed().map(s::charAt);
    }
}
