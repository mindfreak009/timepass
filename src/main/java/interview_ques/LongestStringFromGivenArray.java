package interview_ques;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LongestStringFromGivenArray {
    public static void main(String[] args) {

        String[] str = {"hello", "world", "Microservices", "dell"};

        String longestString =
                Arrays.stream(str)
                .reduce((word1, word2) ->
                        word1.length() > word2.length() ? word1 : word2)
                .get();

        System.out.println("Longest String is ::: " +longestString);
        System.out.println("=================================================");

// Find all numbers that start with 1
        int[] numbers = {5, 9, 11,2, 8, 21, 1};
        Arrays.stream(numbers).
                boxed()
                .map(s -> s + "")
                .filter(e -> e.startsWith("1"))
                        .forEach(result -> System.out.print(result + " "));
        System.out.println("\n=================================================");


        // String join method
        List<String> integerList = Arrays.asList("1","2","3","4");
        String results = String.join("-", integerList);
        System.out.println(results);
        
    }
}
