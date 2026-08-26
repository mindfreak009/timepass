package interview_ques;

import java.util.Arrays;
import java.util.stream.Stream;

// Given an integer[] nums = {1,2,3}, return the value as [1o, 2e, 3o]
public class AncestryJavaQuestion {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        Arrays.stream(nums).mapToObj(i -> i % 2 != 0 ? i + "o" : i + "e")
                .forEach(e -> System.out.print(e + " "));
        System.out.println("\n ===================================================");

        String[] names = {"hello", "code", "world"};
        Stream.of(names).filter(x -> x.length() > 4)
                .forEach(System.out::println);
    }
}
