package streams_hidden_features;

import java.util.Arrays;
import java.util.List;


// Collectors.teeing() was introduced  in Java 12
// Every element passed to the resulting collector is processed by both downstream collectors,
// then their results are merged using the specified merge function into the final result.
public class CollectorsTeeing {
    public static void main(String[] args) {

        // List<Integer> numbers = Arrays.asList(1,2,3, 0, -1,  4,5,6, 16, 7,8,9);
        List<Integer> numbers = Arrays.asList(-1, -40, -18, -16, -100);

        int max = Integer.MIN_VALUE;
        int min = numbers.get(0);

        for (int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i) > max) {
                max = numbers.get(i);
            } else if(numbers.get(i) < min) {
                min = numbers.get(i);
            }
        }
        System.out.println("min :: "  + min);
        System.out.println("max :: "  + max);

//        Map<String, Integer> minMaxMap = >numbers.stream()
//                .collect(Collectors.teeing(
//                        Collectors.maxBy(Integer::compareTo),   // 1st collector
//                        Collectors.minBy(Integer::compareTo),   // 2nd collector
//                        (e1, e2) -> Map.of("max", e1.get(), "min", e2.get())
//                ));
//        System.out.println(minMaxMap);
//        O/P : min-1, max-9
    }
}
