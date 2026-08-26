package durgasoft_java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamExample {
    public static void main(String[] args) {

        IntStream.range(0, 10)
                .forEach(result -> System.out.print(result + " "));
        IntStream.range(0, 10)
                .mapToObj(result -> result + " ")
                .forEach(System.out::println);
        System.out.println("******************************************");

        IntStream.rangeClosed(1,10).forEach(System.out::println);
        System.out.println("range closed ******************************************");

        IntStream.iterate(0, operand -> operand+1)
                .filter(number -> number%2 == 0)
                .limit(20)
                .forEachOrdered(System.out::println);

        System.out.println("******************************************");

        final List<Integer> numList = Arrays.asList(1,2,3,100,15,200,9,85,300);
        Integer min = numList
                .stream()
                .min(Comparator.naturalOrder()).get();
        System.out.println("min number:: " +min);

        System.out.println("******************************************");
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 100, 23, 93,  99);
        Integer maxNumber = numbers
                .stream()
                .max(Comparator.naturalOrder()).get();
        System.out.println("maxNumber is :::: " +maxNumber);
        Integer maxNum = numbers
                .stream()
                .max(Comparator.naturalOrder())
                .get();
        System.out.println("max number:: " +maxNum);
        System.out.println("******************************************");

        final List<Integer> duplicateNumList = Arrays.asList(1,2,3,100,15,200,9,2,4,3,1,85,15,200,300,9);
        List<Integer> collect = duplicateNumList
                .stream()
                .distinct()
                .sorted()
                .toList();
        System.out.println(" unique numbers :: " +collect);


    }
}
