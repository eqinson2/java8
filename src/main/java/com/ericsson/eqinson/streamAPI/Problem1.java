package com.ericsson.eqinson.streamAPI;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Problem1 {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("testDir", "Alice.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        for (String w : words) {
            if (w.length() > 12) {
                System.out.println(w);
            }
        }

        Stream<String> words2 = Stream.of(contents.split("[\\P{L}]+"));
        Long count = words2.filter(w -> w.length() > 12).count();
        System.out.println(count);
    }
}
