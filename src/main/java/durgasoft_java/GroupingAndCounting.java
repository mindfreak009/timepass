package durgasoft_java;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingAndCounting {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alex", "Henry", "Alex", "Sandra", "Alex", "Thomas", "Thomas", "Henry", "Giorgino");
        Map<String, Long> counting = names.stream()
                .collect(Collectors.groupingBy
                        (Function.identity(), Collectors.counting())
                );
        counting.forEach((name, count) -> System.out.println(name +":" +count));


        // prior to java 8
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<=names.size()-1; i++){
            String str = names.get(i);
            Integer integer = map.get(str);

            if(!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, integer+1);
            }
        }


        System.out.println("map :: " + map);

        // Print sum of all numbers
        List<Integer> list = Arrays.asList(1,4,99,320,9971,20,4651,922);
        Integer sum = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println("sum is:: " +sum);

        Integer sum2 = list.stream().reduce(0, Integer::sum);
        System.out.println("sum2 is:: " +sum);

        int sum3 = list.stream()
                .mapToInt(Integer::intValue)
                //.mapToInt(x -> x)  This would also give the correct output
                .sum();
        System.out.println("sum3 is:: " +sum3);
// =============================================================================================
        List<String> listString = Arrays.asList("Spain", "Germany", "Antigua", "Denmark", "Portugal", "India");
        String join = listString
                .stream()
                .collect(Collectors.joining(","));
        System.out.println("join ::" + join);

//        List<List<String>> arrayListOfNames = new ArrayList<>(
//                new ArrayList("Mariam", "Alex", "Ismail");
//                new ArrayList("John", "Alesha", "Andre");
//                new ArrayList("Susy", "Ali");
//        );


        // To remove the last comma in a string
        List<String> stringList = Arrays.asList("JAVA", "J2EE", "Spring", "Hibernate");
        stringList.stream()
                        .forEach(i -> System.out.print(i + " "));

        stringList.stream().map((s) -> s + ", ")
                .map((s) -> s.lastIndexOf(",")).toString();
                //.forEach(i -> System.out.print(i + " "));

        System.out.println(stringList);

//        Collectors.joining(", ")) +
//                (stringList.size() > 1 ? ", " : "") +
//                stringList.get(stringList.size() - 1);
    }
}
