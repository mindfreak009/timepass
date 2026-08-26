package interview_ques.map;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
//        boolean result = numbers.stream()
//                .allMatch(x -> x > 0);

        // result: true

        List<List<String>> listOfList = Arrays.asList(
                Arrays.asList("one", "two"),
                Arrays.asList("three", "four"),
                Arrays.asList("four", "five")
        );
        List<String> result = listOfList.stream()
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(result);

    }
}
