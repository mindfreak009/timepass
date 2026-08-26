package interview_ques.altimetrik;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// highest frequency from the given string
public class FindHighestFrequencyFromAString {
    public static void main(String[] args) {
        String str = "Prakash";

        System.out.println(findHighestFrequencyFromGivenString(str));
        System.out.println(findHighestFrequencyFromGivenString1(str));
    }

    private static String findHighestFrequencyFromGivenString(String str) {
        return str.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(e -> e.getKey() + ":" + e.getValue())
                .orElse("");
    }

    private static String findHighestFrequencyFromGivenString1(String str) {
        Map<Character, Long> freqMap = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));
        long maxFreq = 0;
        char maxChar = '\0';

        for(Map.Entry<Character,Long> entry: freqMap.entrySet()) {
            if(Math.max(maxFreq, entry.getValue()) != maxFreq) {
                maxFreq = entry.getValue();
                maxChar = entry.getKey();

            }
        }

        return maxChar + ":" + maxFreq;
    }
}


// System.out.println(Collections.max(map.entrySet().));
//        Map<Character, Integer> newMap = new HashMap<>();
//        int max = 0;
//        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//                max = Math.max(max, entry.getValue());
//                newMap.put(entry.getKey(), max);
//
//
//        }
//        System.out.println(newMap);

//        Map<Character, Long> collect = map.entrySet()
//                .stream()
//                .map(Map.Entry::getKey)
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//



//                collect.entrySet().stream()
//                        .max(Comparator.comparing((a,b) -> b,a));
