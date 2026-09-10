package java8_programs;

import java.util.Arrays;
import java.util.stream.Collectors;

// Capitalize the first character of each word and then append '#' at the beginning of the String.
public class CapitalizeFirstLetterOfEachWord {
    public static void main(String[] args) {
        String str = "apple banana    cherry";

        // In regex, '\s' means whitespace character and '+' means  one or more of the preceding thing.
        String result = Arrays.stream(str.split("\\s+"))
                .map(s -> Character.toTitleCase(s.charAt(0)) + s.substring(1))
                .collect(Collectors.joining("", "#", ""));
               // .forEach(i -> System.out.println(i+ " "));
        System.out.println(result);
    }
}
