package ancestry_java;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BiFunctionExample {

    public static void main(String[] args) {

        List<Integer> list1 = Stream.of(1,3,4,5,7,9,11,15).collect(Collectors.toList());
        List<Integer> list2 = Stream.of(11,3,43,5,6,7,19,11,23).collect(Collectors.toList());

        BiFunction<List<Integer>, List<Integer>, List<Integer>> biFunction =
                (int1, int2) -> Stream.of(int1, int2)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> sortedFunction = (lists) -> lists
                    .stream()
                    .sorted()
                    .collect(Collectors.toList());

        System.out.println("Lambda approach ::" + biFunction.andThen(sortedFunction).apply(list1, list2));
    }
}



//    Map<String, Integer> map = new HashMap<>();
//        map.put("Sandhya", 5000);
//                map.put("Alice", 15000);
//                map.put("Ellyse Perry", 25000);
//                map.put("Grace", 50000);