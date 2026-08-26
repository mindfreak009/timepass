package durgasoft_java.java8;

import java.util.function.Consumer;

// Consumer<T> : take input, modify, no output
// method        void accept(T t) {}
public class Consumer1 {
    public static void main(String[] args) {
        Consumer<Integer> c1 = System.out::println;
       // Consumer<Integer> c2 = n -> System.out.println(n);
        c1.accept(10);
    }
}
