package java8_programs;

import java.util.Arrays;

public class CapitalizeFirstLetterOfEachWord {
    public static void main(String[] args) {
        String str = "apple banana cherry";

        Arrays.stream(str.split("\\s"))
                .map(s -> Character.toTitleCase(s.charAt(0)) + s.substring(1))
                .forEach(s -> System.out.print(s + " "));
    }
}
