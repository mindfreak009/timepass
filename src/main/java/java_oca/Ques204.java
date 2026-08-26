package java_oca;

import java.util.function.BiPredicate;

public class Ques204 {
    public static void main(String[] args) {
      //  BiPredicate test = (Integer x, final var y) -> x.equals(y);              // Invalid
      //  BiPredicate test1 = (Integer x, final Integer y) -> (x.equals(y));       // Invalid
        BiPredicate test2 = (var x, final var y) -> (x.equals(y));           // Valid
      //  BiPredicate test3 = (final Integer x, var y) -> (x.equals(y));           // Invalid
      //  BiPredicate test4 = (final var x, y) -> (x.equals(y));                   // Invalid

    }
}
