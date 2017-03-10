package com.ericsson.eqinson.usingLambda;

import java.util.Comparator;

/**
 * Created by eqinson on 2016/10/1.
 */
public class ComparatorMaker {
    public static Comparator<String> makeComparator(boolean order, boolean ignoreCase, boolean ignoreWS) {
        // return (c1, c2) -> c1.compareTo(c2)
        // return (c1, c2) -> c1.compareToIgnoreCase(c2);
        return (c1, c2) -> {
            c1 = c1.replaceAll(" ", "");
            c2 = c2.replaceAll(" ", "");
            return c1.compareTo(c2);
        };

    }


}
