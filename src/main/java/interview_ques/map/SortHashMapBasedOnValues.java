package interview_ques.map;

import java.util.*;

public class SortHashMapBasedOnValues {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("Delhi", 2);
        map.put("Mysore", 8);
        map.put("Chennai", 7);
        map.put("Bengaluru", 9);
        map.put("Mumbai", 1);
        map.put("Pune", 3);

        // Converting HashMap to List, since Map doesn't have any method to sort per its values
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());

        Collections.sort(entryList, new Comparator<>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        // Store the sorted entries in a LinkedHashMap to maintain the order
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        // print the sorted Map
        System.out.println("Sorted Map :::: " +sortedMap);
    }
}
