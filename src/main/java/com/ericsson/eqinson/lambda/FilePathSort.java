package com.ericsson.eqinson.lambda;

import java.io.File;
import java.util.stream.Stream;

/**
 * Created by eqinson on 2016/9/28.
 */
public class FilePathSort {
    private static File[] sort(String directory) {
        return new File(directory).listFiles((dir, name) -> name.endsWith(".log"));
    }

    public static void main(String[] args) {
        File[] files = new File[]{new File("eqinson3/test1"), new File("eqinson2/test1"),
                new File("eqinson1/test2"), new File("eqinson1/test1")};

        Stream<File> stream = Stream.of(files);
        stream.sorted((o1, o2) -> {
            int dirComp = o1.getParent().compareTo(o2.getParent());
            int fileComp = o1.toPath().getFileName().toString().compareTo(o2.toPath().getFileName().toString());
            return dirComp == 0 ? fileComp : dirComp;
        }).forEach(x -> System.out.println(x.toPath().toString()));
    }
}
