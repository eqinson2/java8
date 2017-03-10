package com.ericsson.eqinson.streamAPI;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Parallel {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("testDir", "Alice.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        for (int i = 0; i < 100; i++) {
            AtomicInteger[] shortWords = new AtomicInteger[12];
            for (int j = 0; j < 12; j++)
                shortWords[j] = new AtomicInteger(0);

            words.stream().parallel().forEach(s -> {
                if (s.length() < 12) shortWords[s.length()].incrementAndGet();
            });
            System.out.println(Arrays.toString(shortWords));
        }

        System.out.println();

        for (int i = 0; i < 100; i++) {
            int[] shortWords = new int[12];

            words.stream().parallel().forEach(s -> {
                if (s.length() < 12) shortWords[s.length()]++;
            });
            System.out.println(Arrays.toString(shortWords));
        }

        words.stream().parallel().collect(Collectors.groupingByConcurrent(String::length, Collectors.counting())).forEach((k, v) -> {
            System.out.println("Item : " + k + " Count : " + v);
        });
    }
}
