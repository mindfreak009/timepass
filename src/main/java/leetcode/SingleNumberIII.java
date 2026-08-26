package leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Two Non-Repeating Elements Of Array
public class SingleNumberIII {
    public static void main(String[] args) {

        int[] arr = {13,10,13,26,14,20,14,20};

        Map<String, Integer> map = new HashMap<>();
        map.put("Delhi", 1);
        map.put("Indore", 2);
        map.put("Pune", 3);
        map.put("Mumbai", 4);
        map.put("Delhi", 5);
        map.put("Vizag", 6);
        map.put("Bangalore", 7);

        List<Integer> list =  new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(83);
        list.add(1);
        list.add(99);

        Object[] array = list.stream().filter(i -> i > 10).toArray();
        System.out.println("here ::: " +Arrays.toString(array));

        list.stream().sorted((i, j) -> j.compareTo(i)).forEach(System.out::println);

        int[] arrr = {1,2,3};
        Arrays.stream(arrr).mapToObj(i -> i%2 != 0 ? i+"o" : i+"e").forEach(System.out::println);


        findFirstTwoNonRepeatingElementsOfArray(arr);
    }

    // 1. FIRST APPROACH
    private static void findFirstTwoNonRepeatingElementsOfArray(int[] arr) {
        Map<Integer, Long> collect = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));

        System.out.print("Final Answer: ");
        for (Map.Entry<Integer, Long> map : collect.entrySet()) {
            if(map.getValue() == 1) {
                System.out.print(map.getKey() + " ");
            }
        }
    }
}
