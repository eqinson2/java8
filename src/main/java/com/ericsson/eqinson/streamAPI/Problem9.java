package com.ericsson.eqinson.streamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem9 {
    public static void main(String[] args) {
        ArrayList<String> l1 = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            l1.add(String.valueOf(i));

        ArrayList<String> l2 = new ArrayList<>();
        for (int i = 10; i < 20; i++)
            l2.add(String.valueOf(i));

        List<ArrayList<String>> l3 = new ArrayList<>();
        l3.add(l1);
        l3.add(l2);

        Stream<ArrayList<String>> s = l3.stream();

        ArrayList<String> result = new ArrayList<>();
        s.forEach(result::addAll);
        String r = result.stream().collect(Collectors.joining(", "));
        System.out.println(r);

        Stream<ArrayList<String>> ss = l3.stream();
        r = ss.reduce(new ArrayList<String>(), (ss1, ss2) -> {
            ss1.addAll(ss2);
            return ss1;
        }).stream().collect(Collectors.joining(", "));
        System.out.println(r);
    }
}
