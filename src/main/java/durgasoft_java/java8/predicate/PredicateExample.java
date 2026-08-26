package durgasoft_java.java8.predicate;

import java.util.function.Predicate;

interface A {
    public int getLength(String s);
}

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> predicate = I -> I>10;
        System.out.println(predicate.test(100));
        System.out.println(predicate.test(5));

        A a = (s) -> s.length();
        System.out.println(a.getLength("Hello World"));
        System.out.println(a.getLength("Be happy!"));

    }
}
