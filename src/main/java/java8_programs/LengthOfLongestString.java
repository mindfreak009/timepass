package java8_programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LengthOfLongestString {
    public static void main(String[] args) {
        String[] str = {"Apple", "Banana" , "Avocados", "Apricot", "Grapes"};

        // 1. Use Java 8 stream with a custom comparator to find and print the string with the maximum length
        Arrays.stream(str)
                .max(Comparator.comparingInt(String::length))
                .ifPresent(maxString -> System.out.println("String with Maximum Length: " + maxString));
        System.out.println("=============================================================");

        // 2. Use Java 8 stream with a custom comparator to find and print the string with the maximum length
        Arrays.stream(str)
                .max(Comparator.comparingInt(String::length))
                .ifPresent(maxString -> System.out.println(maxString +
                        " - has maximum length : " + maxString.length()));
        System.out.println("=============================================================");

        // 3. Java 8 using reduce operations
        String collect = Arrays.stream(str)
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
                .get();
        System.out.println("Here :::: " +collect);
        System.out.println("=============================================================");

        // 4. Using mapToInt() method
         int max = Arrays.stream(str)
                .mapToInt(String::length)
                .max()
                .orElse(0);

         System.out.println(max);
        System.out.println("=============================================================");

    }
}
