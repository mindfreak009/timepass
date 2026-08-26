package interview_ques;

import java.util.*;
import java.util.stream.Collectors;

public class FindNth_HighestSalaryJava8 {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("Delhi", 1500);
        map.put("Mumbai", 200);
        map.put("Mumbai-2", 200);
        map.put("Nagpur", 50);
        map.put("Pune", 2700);
        map.put("Vizag", 4700);
        map.put("Vizag-2", 4700);
        map.put("Chennai", 900);
        map.put("Chennai-2", 900);
        map.put("Indore", 600);

        Map.Entry<String, Integer> nthHighestSalary = findNthHighestSalary(2, map);
        System.out.println(nthHighestSalary);

        Optional<Map.Entry<String, Integer>> dynamicNthHighestSalary = findDynamicNthHighestSalary(2, map);
        dynamicNthHighestSalary.ifPresent(System.out::println);

    }

    private static Map.Entry<String, Integer>  findNthHighestSalary(int num, Map<String, Integer> map) {

        return map.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .distinct()
                .collect(Collectors.toList())
                .get(num-1);

//        map.entrySet()
//                .stream()
//                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
//                .filter(distinctByKey(Map.Entry::getValue))
//                .skip(num - 1)
//                .findFirst();
    }

    private static Optional<Map.Entry<String, Integer>>  findDynamicNthHighestSalary(int num, Map<String, Integer> map) {

        // Edge case
        if (map == null || map.isEmpty() || num <= 0) {
            return Optional.empty();
        }

        List<Integer> distinctValues = map.values()
                .stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println("distinctValues:: " +distinctValues);

        if(num > distinctValues.size()) {

            return Optional.empty();
        }

        int targetValue = distinctValues.get(num-1);

        return map.entrySet()
                .stream()
                .filter(e -> e.getValue() == targetValue)
                .findFirst();


//        return  map.entrySet().stream()
//                .collect(Collectors.groupingBy(Map.Entry::getValue,
//                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
//                .entrySet()
//                .stream()
//                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
//                .collect(Collectors.toList())
//                .get(num - 2);

    }

}
