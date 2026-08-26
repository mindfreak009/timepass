package java8_programs;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

public class Supplier_Example {
    public static void main(String[] args) {

        Supplier<Integer> supplier = () -> (int) Math.pow(4, 3);
        System.out.println(supplier.get());

        BiPredicate<Integer, String> biPredicate = (num, str) -> {
            return num <10 && str.length()>5;
        };
        System.out.println(biPredicate.test(5, "Hello World"));

        // the last parameter(3rd argument) here is the return type...
        BiFunction<Integer, String, String> biFunction = (num, str) -> {
            return num + " " + str;
        };
        System.out.println(biFunction.apply(15, "Hello World"));
    }
}
