package com.ericsson.eqinson.usingLambda;

import java.lang.reflect.Field;
import java.util.Comparator;

/**
 * Created by eqinson on 2016/10/1.
 */
public class Problem9 {

    public static void main(String[] args) {
        Person p1 = new Person("Qingwei", "Song1");
        Person p2 = new Person("Qingwei", "Song");
        Comparator<Person> comparator = new Problem9().lexicographicComparator("firstName", "lastName");
        System.out.println(comparator.compare(p1, p2));
    }

    public Comparator<Person> lexicographicComparator(String... fieldName) {
        return (p1, p2) -> {
            for (int i = 0; i < fieldName.length; i++) {
                try {
                    String fn = fieldName[i];
                    Field f1 = p1.getClass().getField(fn);
                    f1.setAccessible(true);
                    String fv1 = (String) f1.get(p1);

                    Field f2 = p2.getClass().getField(fn);
                    f2.setAccessible(true);
                    String fv2 = (String) f2.get(p2);

                    if (!fv1.equals(fv2))
                        return fv1.compareTo(fv2);
                    else if (i == fieldName.length - 1)
                        break;
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    System.out.println(e.getMessage());
                    return -1;
                }
            }
            return 0;
        };
    }

    public static class Person {
        public String firstName;
        public String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }
}
