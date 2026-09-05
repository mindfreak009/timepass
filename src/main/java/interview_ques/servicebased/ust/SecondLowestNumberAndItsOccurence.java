package interview_ques.servicebased.ust;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SecondLowestNumberAndItsOccurence {
    private static Object lastValue;

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,10,9,9,30,40,10,10);
        //System.out.println(findSecondLowestNumberAndItsOccurence(list));
        System.out.println(findSecondLowestNumAndItsOccurence(list));

    }

    // Java 17 based optimized approach
    public static Map<Integer, Long> findSecondLowestNumAndItsOccurence(List<Integer> integerList) {
        return integerList.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .skip(1)
                .findFirst()
                .map(e -> Map.of(e.getKey(), e.getValue()))
                .orElse(Map.of());

        //        return integerList.stream()
//                //.distinct()
//                .sorted()
//                .filter(SecondLowestNumberAndItsOccurence::isDifferent)
//                .skip(1)
//                .findFirst()
//                .stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    }

    public static boolean isDifferent(Object current) {
        boolean different = !current.equals(lastValue);
        lastValue = current;
        return different;
    }
    public static Map<Integer, Long> findSecondLowestNumberAndItsOccurence(List<Integer> list) {
        Map<Integer, Long> result =
                list.stream()
                        .filter(n -> n.equals(
                                list.stream()
                                        .distinct()
                                        .sorted()
                                        .skip(1)
                                        .findFirst()
                                        .orElse(null)
                        ))
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        ));

        return result;
    }


}
