package interview_ques.paypal;

import java.util.*;
import java.util.stream.Collectors;


// Input: text = "Leetcode is cool"
// Output: "Is cool leetcode"
// Explanation: There are 3 words, "Leetcode" of length 8, "is" of length 2 and "cool" of length 4.
// Output is ordered by length and the new first word starts with capital letter.

public class ArrangeWords {
    public static void main(String[] args) {

        String text = "Leetcode is cool bull hell";
        String result = arrangeWordsUsingJava8(text);
        System.out.println("Result :: " + result);

        arrangeWordsUsingJava7(text);
    }

    // Time complexity : O(N logN)
    // Space complexity: O(N)
    private static void arrangeWordsUsingJava7(String text) {
        String[] word = text.split(" ");
        Arrays.sort(word, Comparator.comparingInt(String::length));

        StringBuilder sb = new StringBuilder();
        sb.append(word[0].substring(0,1).toUpperCase() + word[0].substring(1));

        for (int i = 1; i < word.length; i++) {
            sb.append(" " + word[i].toLowerCase());
        }
        System.out.println("sb ::: "  +sb);
    }

    private static String arrangeWordsUsingJava8(String text) {
        String sortedByLength = Arrays.stream((Character.toLowerCase(text.charAt(0))
                                + text.substring(1)).split(" "))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.joining(" "));

        System.out.println("sortedByLength ::: " +sortedByLength);

        return Character.toUpperCase(sortedByLength.charAt(0)) + sortedByLength.substring(1);
    }
}
