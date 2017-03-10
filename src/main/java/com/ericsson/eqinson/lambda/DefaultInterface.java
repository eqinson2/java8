package com.ericsson.eqinson.lambda;

interface I {
    public default void f() {
        System.out.println("11111111111");
    }
}

interface J {
    public default void f() {
        System.out.println("22222222222");
    }
}

class K implements I, J {
    public void f() {
        I.super.f();
        //System.out.println("33333333333");
    }
}

public class DefaultInterface {
    public static void main(String[] args) {
        new K().f();
    }
}
