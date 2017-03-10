package com.ericsson.eqinson.lambda;

import java.io.File;
import java.io.FileFilter;
import java.util.stream.Stream;

/**
 * Created by eqinson on 2016/9/28.
 */
public class FileList {
    private static File[] list(String dir) {
        return new File(dir).listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.toPath().toString().endsWith(".log");
            }
        });
    }

    private static File[] list2(String dir) {
        return new File(dir).listFiles(pathname -> pathname.getName().endsWith(".log"));
    }

    private static File[] list3(String dir) {
        return new File(dir).listFiles(File::isDirectory);
    }

    private static File[] list4(String directory) {
        return new File(directory).listFiles((dir, name) -> name.endsWith(".log"));
    }

    public static void main(String[] args) {
        Stream<File> stream = Stream.of(list("testDir"));
        stream.forEach(x -> System.out.println(x.getName()));

        Stream<File> stream2 = Stream.of(list2("testDir"));
        stream2.forEach(x -> System.out.println(x.getName()));

        Stream<File> stream3 = Stream.of(list3("testDir"));
        stream3.forEach(x -> System.out.println(x.getName()));

        Stream<File> stream4 = Stream.of(list4("testDir"));
        stream4.forEach(x -> System.out.println(x.getName()));
    }
}
