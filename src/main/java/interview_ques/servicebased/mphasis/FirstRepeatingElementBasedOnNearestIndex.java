package interview_ques.servicebased.mphasis;

import java.util.*;

// Output should be : a
public class FirstRepeatingElementBasedOnNearestIndex {

    public static void main(String[] args) {
        String str = "Nagesh is the exceptional Java Programmer";
        // String str = "Lenov is a ";
        System.out.println(firstRepeatingElementInArrayBasedOnIndex(str));

    }

    private static char firstRepeatingElementInArrayBasedOnIndex(String str) {

        // We use a LinkedHashSet to remember the order of characters
        Set<Character> seen = new LinkedHashSet<>();
        Set<Character> repeated = new HashSet<>();

        // Stream over the characters in the string, skipping whiētespace
        Optional<Character> firstRepeatingChar =
                str.chars()  // Stream of int values (Unicode code points)
                        .mapToObj(c -> (char) c)  // Convert int to Character
                        .filter(d -> !Character.isWhitespace(d))  // Skip whitespaces
                        .filter(e -> {
                            if (seen.contains(e) && !repeated.contains(e)) {
                                repeated.add(e);  // Mark as repeated (second occurrence)
                                return true;
                            } else {
                                seen.add(e);  // Mark the character as seen
                                return false;
                            }
                        })
                        .findFirst();  // Find the first repeating character

        System.out.println("seen ::" +seen);
        System.out.println("repeated ::" + repeated);

        // Print if found
        return firstRepeatingChar.orElse(Character.MIN_VALUE);
    }
}
