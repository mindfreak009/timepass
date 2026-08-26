package interview;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Interview2 {
    public static void main(String[] args) {

        String[][] str = {{"a","b","c"},{"c","a","b","d"},{"a","b","e","f"}};
        // a b d, e, f

        uniqueValuesWithoutC(str);
    }

    private static List<String> uniqueValuesWithoutC(String[][] str) {

        // Step 1: Flatten, filter, and collect unique letters excluding 'c'
        Set<String> uniqueLetters = Arrays.stream(str)
                .flatMap(Arrays :: stream)           // Flatten the 2D array into a Stream<String>
                .filter(letter -> !letter.equals("c"))  // Filter out 'c'
                .collect(Collectors.toSet());    // Collect into a Set

        // Step 2: Print the unique letters
        System.out.println(uniqueLetters);

        // converting Set into List
        return List.copyOf(uniqueLetters);
    }
}
