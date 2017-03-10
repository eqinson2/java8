package com.ericsson.eqinson.usingLambda;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;

/**
 * Created by eqinson on 2016/10/1.
 */
public class Uncheck {
    public static <T, R> Function<T, R> unchecked(MyFileReader<T, R> f) {
        return (t) -> {
            try {
                return f.read(t);
            } catch (IOException e) {
                return null;
            }
        };
    }

    public static void main(String[] args) {
        Function<String, String> f = unchecked((path) -> new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8));
        System.out.println(f.apply("testDir/eqinson1.log"));
    }
}
