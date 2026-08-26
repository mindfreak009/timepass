package interview_ques.mphasis;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingElementInArray {
    public static void main(String[] args) {

        /* Duplicate elements in an array  */
        String str = "ilovejavatechie";
        Map<Character, Long> map =
                str.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Duplicate Elements :: ");

        map.entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .forEach(result -> System.out.print(result + " "));
        System.out.println("\n===============================================================");

        // First non-repeating element in Array.
        String firstNonRepeatingElement = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .findFirst()
                .get()
                .getKey();


        System.out.println("firstNonRepeatingElement :: " +firstNonRepeatingElement);
        //.forEach(result -> System.out.print(result + " "));
    }
}
