package java8_programs;

import java.util.stream.Stream;

public class Count_Min_And_Max_Example {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("total count is:: " +integerStream.count());

        Integer minInteger = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).min(Integer::compareTo).get();
        System.out.println("Min Integer is:::" +minInteger);

        Integer maxInteger = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).max(Integer::compareTo).get();
        System.out.println("Max Integer is::: " +maxInteger);

    }
}
