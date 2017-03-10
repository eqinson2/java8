package com.ericsson.eqinson.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eqinson on 2016/9/29.
 */
public class Closure {
    public static void main(String[] args) {
        String[] names = {"Peter", "Paul", "Mary"};
        List<Runnable> runners = new ArrayList<>();
        for (String name : names)
            runners.add(() -> System.out.println(name));

        runners.forEach(Runnable::run);
        runners.clear();

        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            runners.add(() -> System.out.println(name));
        }
        runners.forEach(Runnable::run);
    }
}
