package streams_hidden_features;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDropWhileTakeWhile {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
        List<Integer> dropWhile = numbers.stream()
                .dropWhile(i -> i < 5)
                .collect(Collectors.toList());

        System.out.println("result :: " +dropWhile);
        System.out.println("=======================");

        List<Integer> takeWhile = numbers.stream()
                .takeWhile(i -> i < 5)
                .collect(Collectors.toList());

        System.out.println("result :: " +takeWhile);
        System.out.println("=======================");

        List<Integer> numResults = numbers.stream()
                .dropWhile(i -> i < 3)
                .takeWhile(i -> i < 7)
                .collect(Collectors.toList());
        System.out.println("combinedResults :: " +numResults);
        System.out.println("=======================");
    }
}
