package com.ericsson.eqinson.usingLambda;


import java.util.function.Function;

public class PairMap {
    public static <T, U> Pair<U> map(Pair<T> pair, Function<T, U> f) {
        return new Pair<U>(f.apply(pair.p1), f.apply(pair.p2));
    }

    public static void main(String[] args) {

    }

    public static class Pair<T> {
        T p1;
        T p2;

        public Pair(T p1, T p2) {
            this.p1 = p1;
            this.p2 = p2;
        }
    }
}
