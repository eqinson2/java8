package com.ericsson.eqinson.thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by eqinson on 2016/10/2.
 */
public class Problem7 {
    public static void main(String... args) {
        ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 1000000; i++)
            map.put(String.valueOf(i), Long.valueOf(i));

        long result = map.reduceEntries(1000, kv -> kv.getValue(), Long::max);
        System.out.println(result);

        Map.Entry<String, Long> resultKv = map.reduceEntries(1000, (kv1, kv2) -> kv1.getValue() > kv2.getValue() ? kv1 : kv2);
        System.out.println(resultKv.getKey());
    }
}
