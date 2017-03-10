package com.ericsson.eqinson.usingLambda;

/**
 * Created by eqinson on 2016/10/1.
 */
public class Generic {
    public static void main(String[] args) {
        Plate<? extends Fruit> p = new Plate<Apple>(new Apple());
//        p.set(new Fruit());
//        p.set(new Apple());
//        Fruit newFruite1 = p.get();
        Fruit newFruite2 = p.get();

        Plate<? super Fruit> p2 = new Plate<>(new Fruit());
        p2.set(new Fruit());
        p2.set(new Apple());
//        Fruit newFruite3 = p2.get();
//        Apple newFruite4 = p2.get();

    }
}

class Food {
}

class Fruit extends Food {
}

class Meat extends Food {
}

class Apple extends Fruit {
}

class Banana extends Fruit {
}

class Pork extends Meat {
}

class Beef extends Meat {
}

class Plate<T> {
    private T item;

    public Plate(T item) {
        this.item = item;
    }

    public void set(T t) {
        item = t;
    }

    public T get() {
        return item;
    }
}