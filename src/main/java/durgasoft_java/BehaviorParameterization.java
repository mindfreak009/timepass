package durgasoft_java;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class BehaviorParameterization {
    public static void main(String[] args) {

        List<Integer>  numbers = Arrays.asList(12,9,13,4,6,2,4,12,15);
        filterAndPrint(numbers, x -> x%2==0);
        System.out.println("================================");
        filterAndPrint(numbers, x -> x%2!=0);
        System.out.println("================================");
        filterAndPrint(numbers, x -> x%3==0);

        List<String>  stringList = Arrays.asList("Spring", "API", "Microservices", "Asia");
        stringList.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> o) {
         numbers
            .stream()
            .filter(o)
            .forEach(System.out::println);
    }
}
