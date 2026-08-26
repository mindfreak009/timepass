package orion;

// Find the first non‑repeating character in a String using Streams
// Input : String input = "programming";

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharacterInStream_Orion {
    public static void main(String[] args) {
        String input = "programming";

        Optional<Character> findFirstNonRepeating =

                input.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();

        System.out.println(findFirstNonRepeating.orElse(null));

//        input.chars()
//                .forEach(x -> {
//                    if(x == 1)  return x;
//                    else return
//                });

    }
}
