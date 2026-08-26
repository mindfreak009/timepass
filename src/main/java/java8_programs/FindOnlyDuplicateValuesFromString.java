package java8_programs;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindOnlyDuplicateValuesFromString {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Delhi");
        list.add("Mumbai");
        list.add("Delhi");
        list.add("Pune");
        list.add("Bangalore");
        list.add("Pune");

        // extract ONLY duplicate values from String
        Set<String> set = new HashSet<>();
        list.stream()
                .filter(e -> !set.add(e))
                .forEach(System.out::println);
        System.out.println("===================================================");


        findDuplicatesUsingCollectionsFrequency(list);
        String[] duplicatesUsingHashMap = findDuplicatesUsingHashMap(list);
        System.out.println("Answer here :: " +Arrays.toString(duplicatesUsingHashMap));
    }

    private static String[] findDuplicatesUsingHashMap(List<String> list) {
        Map<String, Integer> map = new HashMap<>();

        for(String element : list) {
            map.put(element, map.getOrDefault(element, 0)+1);
        }

        System.out.println("map here ::: " +map);
        List<String> resultList = new ArrayList<>();
        for(Map.Entry<String, Integer> duplicateElem : map.entrySet()) {
            if(duplicateElem.getValue() > 1) {
                String key = duplicateElem.getKey();
                resultList.add(key);
             }
        }
        // initializing empty String[] to store results.
        String[] result = new String[map.size()];
        System.out.println("result here ::: " + Arrays.toString(resultList.toArray()));
        return resultList.toArray(new String[0]);
    }

    private static void findDuplicatesUsingCollectionsFrequency(List<String> list) {
        // using Collections.frequency() method
        List<String> duplicateElement = list.stream()
                .distinct()
                .filter(i -> Collections.frequency(list, i) > 1)
                .collect(Collectors.toList());
        System.out.println("duplicate element ::: " +duplicateElement);
        System.out.println("===================================================");
    }
}
