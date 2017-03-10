package com.ericsson.eqinson.streamAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem2 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("testDir", "Alice.txt");
        try (Stream<String> lines = Files.lines(path)) {
            List<String> list = lines.map(ss ->
                    Stream.of(ss.split("[\\P{L}]+")).sorted((w1, w2) -> w2.compareToIgnoreCase(w1)).findFirst().orElse("")
            ).collect(Collectors.toList());

            Collections.sort(list, String::compareToIgnoreCase);
            list.stream().limit(10).forEach(System.out::println);
        }

        System.out.println();

        try (Stream<String> lines = Files.lines(path)) {
            List<String> list = lines.map(ss ->
                    Stream.of(ss.split("[\\P{L}]+")).sorted(Comparator.comparing(String::length).reversed()).findFirst().orElse("")
            ).collect(Collectors.toList());

            Collections.sort(list, Comparator.comparing(String::length).reversed());
            list.stream().limit(10).forEach(System.out::println);
        }
    }
}