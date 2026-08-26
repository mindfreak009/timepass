package interviewtime;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountFrequencyOfCharacters {
    public static void main(String[] args) {
        String input = "Press Paper";
        System.out.println(countFrequencey(input));
    }

    public static Map<Character, Integer> countFrequencey(String str) {

        Map<Character, Long> collect = str.chars()
                .mapToObj(c -> (char) c) // convert int to Character
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if(!Character.isWhitespace(str.charAt(i))){
                map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
            }
        }
        return map;
    }
}
