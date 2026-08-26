package interviewtime;

// list= 10,10,9,9,30,40,10,10
// 2nd lowest number and its count occurrence using stream api

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

// Output: {30=1}
public class FindSecondHighestNumberAndItsOccurence {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,10,9,9,30,40,10,10);
        System.out.println(findSecondHighestNumberAndItsOccurence(list));
        System.out.println(findSecondHighestNumberAlongWithOthersThereAfter(list));
    }


    private static Map.Entry<Integer, Long> findSecondHighestNumberAndItsOccurence(List<Integer> list) {
        return list.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet()
                        .stream()
                        .sorted((a, b) -> Integer.compare(b.getKey(), a.getKey()))
                        .skip(1)
                        .findFirst()
                        .orElse(null);
    }

    private static Map<Integer, Long> findSecondHighestNumberAlongWithOthersThereAfter(List<Integer> list) {

        // Step 1: Build Frequency Map
        Map<Integer, Long> freqMap = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Step 2: Find maximum key
        Integer maxKey = freqMap.keySet()
                .stream()
                .max(Integer::compareTo)
                .orElse(null);

        // Step 3: Find second highest number and other elements thereafter
        LinkedHashMap<Integer, Long> finalResult =
                freqMap.entrySet()
                .stream()
                .filter(e -> !e.getKey().equals(maxKey))
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a, LinkedHashMap::new)
                );

        return finalResult;

    }


}




//        Map<Integer, Long> collect = list.stream()
//                .sorted()
//                .skip(1)
//                .limit(1)
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//        list.stream()
//                .sorted()
//                .skip(1)
//                .findFirst()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//        ;



//        Integer secondLowest = list.stream()
//                .distinct()
//                .sorted()
//                .skip(1)
//                .findFirst()
//                .orElse(null);
//
//        Map<Integer, Long> result = list.stream()
//                .filter(n -> n.equals(secondLowest))
//                .collect(Collectors.groupingBy(
//                        Function.identity(),
//                        Collectors.counting()
//                ));
//
//        System.out.println(result);


