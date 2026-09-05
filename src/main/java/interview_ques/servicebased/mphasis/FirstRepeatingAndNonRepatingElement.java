package interview_ques.servicebased.mphasis;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstRepeatingAndNonRepatingElement {
    public static void main(String[] args) {
        String str = "Lenovo is a Java Programmer";

        findRepeatedCharacter(str);
        findNonRepeatingCharacter(str);
    }

    private static void findRepeatedCharacter(String str) {
        Map<Character, Long> map = getMap(str);

        Optional<Character> firstRepeat = map
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(e -> e.getKey())
                .findFirst();
        System.out.println("First repeating:" + firstRepeat.orElse(null));
    }


    private static void findNonRepeatingCharacter(String str) {
        // calling getMap function
        Map<Character, Long> map = getMap(str);

        Optional<Character> firstNonRepeating = map
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> e.getKey())
                .findFirst();
        System.out.println("First non-repeating:" + firstNonRepeating.orElse(null));
    }

    private static Map<Character, Long> getMap(String str) {
        return str.chars()
                .mapToObj(i -> (char)i)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        //collect.forEach((x,y) -> System.out.println( "Key: " + x + " Val: " + y));
    }

}
