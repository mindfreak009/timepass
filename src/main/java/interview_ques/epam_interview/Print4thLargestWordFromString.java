package interview_ques.epam_interview;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

// Print the 4th longest word
// output : am
public class Print4thLargestWordFromString {
    public static void main(String[] args) {
        String str = "I am here for the interview";
        System.out.println(printFourthLargestWordFromString(str));
    }

    private static String printFourthLargestWordFromString(String str) {
        // HashMap to store word with their length
        Map<String, Integer> wordLengthMap = new HashMap<>();

        // Set to add unique elements
        Set<String> existing = new HashSet<String>();

        Arrays.stream(str.split(" "))
                .forEach(word -> wordLengthMap.put(word, word.length()));
        //System.out.println("existing :: " +existing);

        // Iterating map and adding elements in Set
        return wordLengthMap
                .entrySet()
                .stream()
                .filter(entry -> existing.add(String.valueOf(entry.getValue())))
                .map(Map.Entry::getKey)
                .skip(3)
                .limit(1)
                .toList()
                .toString();
    }
}
