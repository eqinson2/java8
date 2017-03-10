package com.ericsson.eqinson.usingLambda;

import java.io.File;

/**
 * Created by eqinson on 2016/10/1.
 */
public class TestFilter {

    public static void main(String[] args) {
        File directory = new File("testDir");

        if (!directory.isDirectory()) {
            System.out.println("No directory provided");
            return;
        }

        File[] files = directory.listFiles(f -> f.getName().endsWith(".log"));

        for (File f : files) {
            System.out.println(f.getName());
        }
    }
}
