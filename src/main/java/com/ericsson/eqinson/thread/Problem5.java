package com.ericsson.eqinson.thread;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem5 {
    private static Set<File> makeNewSet(File file) {
        Set<File> s = ConcurrentHashMap.<File>newKeySet();
        s.add(file);
        return s;
    }

    public static void main(String... args) throws Exception {
        ConcurrentHashMap<String, Set<File>> map = new ConcurrentHashMap<>();

        String dir = "testDir";
        File[] files = Paths.get(dir).toFile().listFiles(file -> file.getName().matches(".+\\.txt|.+\\.log"));
        for (File f : files) {
            String contents = new String(Files.readAllBytes(Paths.get(dir, f.getName())), StandardCharsets.UTF_8);
            Pattern.compile("[\\P{L}]+").splitAsStream(contents).parallel().forEach(
                    s -> {
//                        map.merge(s, makeNewSet(f), (sets, ff) -> {
//                            sets.add(f);
//                            return sets;
//                        });
                        map.computeIfAbsent(s, k -> ConcurrentHashMap.<File>newKeySet()).add(f);
                    }
            );
        }

        map.forEach(Long.MAX_VALUE,
                (k, v) -> "Word: " + k + " File: " + v.stream().map(File::getName).collect(Collectors.toList()),
                System.out::println
        );
    }
}
