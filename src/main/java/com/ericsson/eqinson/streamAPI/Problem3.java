package com.ericsson.eqinson.streamAPI;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

/**
 * Created by eqinson on 2016/9/29.
 */
public class Problem3 {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("testDir", "Alice.txt")), StandardCharsets.UTF_8);

        long start = System.currentTimeMillis();
        long count = Pattern.compile("[\\P{L}]+").splitAsStream(contents).parallel().filter(w -> w.length() > 12).count();
        System.out.println(count);
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        count = Pattern.compile("[\\P{L}]+").splitAsStream(contents).filter(w -> w.length() > 12).count();
        System.out.println(count);
        System.out.println(System.currentTimeMillis() - start);
    }
}