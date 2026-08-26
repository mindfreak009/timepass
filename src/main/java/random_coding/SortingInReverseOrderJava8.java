package random_coding;

import com.google.common.base.Predicate;

import java.util.*;
import java.util.stream.Collectors;

public class SortingInReverseOrderJava8 {
    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1, 87, -7, 65, 33, 21, 89, 101, 504, 233, 304);
        // integerList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        integerList.stream().map(n -> n*n*n).forEach(System.out::println);

        List<String> stringList = Arrays.asList("Delhi", "Mumbai", "Pune", "Bangalore", "Delhi",
                "Cochin", "Hyderabad", "Navi Mumbai", "Vizag");

        List<String> collect = stringList.stream().distinct().collect(Collectors.toList());
        System.out.println("collect ::: " +collect);
        List<String> uniqueList = new ArrayList<>();
        stringList.forEach(str -> {
            if(!uniqueList.contains(str)) {
                uniqueList.add(str);
            }
        });
        System.out.println("List now ::: " + uniqueList);

        Map<String, Integer> map = new HashMap<>();
        map.put("Hello", 1);
        map.put("World", 2);
        map.put("HelloWorld", 3);
        map.put("Dell", 4);
        map.forEach((key,value) -> System.out.print(value + " "));

        List<String> laptopList = new ArrayList();
        laptopList.add("DELL");
        laptopList.add("ACER");
        laptopList.add("HCL");

        // Intermediate operation
        laptopList.sort(String::compareTo);

        // Terminal Operation
        laptopList.forEach(a -> {
            System.out.println(a);
        });

        // String s = "Code Decode";
        Predicate<String> predicate = st -> st.length() >= 5;
        System.out.println("here ::: " + predicate.test("Code Decode"));


    }
}
