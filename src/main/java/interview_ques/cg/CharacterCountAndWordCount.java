package interview_ques.cg;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharacterCountAndWordCount {
    public static void main(String[] args) {
        String s = "manojpandey";
        Map<Character, Long> collect =
                s.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("collect :: " +collect);
        collect.entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .forEach(System.out::println);

        System.out.println("====================================================================");
        String str = "I am a java developer and I am proud of it";
        Map<String, Long> wordOccurrences =
                Arrays.stream(str.split(" "))   // \\s+
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Printing all words and their count
        wordOccurrences.entrySet().stream().forEach(System.out::println);

        wordOccurrences.entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .forEach(System.out::println);



        Map<String, Long> wordOcc = Arrays.stream(str.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        wordOcc.entrySet()
                .stream()
                .filter(x -> x.getValue() > 2)
                .forEach(System.out::println);

        Integer[] arr = {1,2,3,2,4,1,1,2,1,3,1};

        Integer[] result = Stream.concat(
                Arrays.stream(arr).filter(num -> num == 1),
                Arrays.stream(arr).filter(num -> num != 0)
        ).toArray(Integer[]::new);

        Arrays.stream(result).forEach(x ->  System.out.print(x + " "));

    }
}
