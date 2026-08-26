package java8_programs;

import java.util.*;

public class SortValuesOfHashMapBasedOnKey {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("Delhi", 5);
        map.put("Pune", 2);
        map.put("Bengaluru", 1);
        map.put("Mumbai", 4);
        map.put("Cochin", 3);

        // Converting map to List, since sort method is not applicable for Map..
        List<Map.Entry<String, Integer>> mapToList = new ArrayList<>(map.entrySet());
        System.out.println(mapToList);

        // Sorting the map
        Collections.sort(mapToList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        // Store the sorted entries in a LinkedHashMap to maintain the order
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry: mapToList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        System.out.println("sorted hash map :::: " + sortedMap);

    }
}
