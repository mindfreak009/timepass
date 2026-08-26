package orion;

// Sort a Map by values using Stream API

// Map<String, Integer> map = new HashMap<>();
// map.put("A", 3);
// map.put("B", 1);
// map. Put("C", 2);

// Ouput: B=1, C=2, A=3

import java.util.HashMap;
import java.util.Map;

public class SortMapByValues {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 3);
        map.put("B", 1);
        map.put("C", 2);

       map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);

//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        Map.Entry::getValue,
//                        (oldValue, newValue) -> oldValue,
//                        LinkedHashMap::new));

        // System.out.println(collect);


    }
}
