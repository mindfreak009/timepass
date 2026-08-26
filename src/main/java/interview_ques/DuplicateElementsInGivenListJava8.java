package interview_ques;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DuplicateElementsInGivenListJava8 {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(10,20,30,87,10,20,76, 28,80,90, 80, 80);

        Set<Integer> set = new HashSet<>();
        list.stream()
                .filter(x -> !set.add(x))
                .collect(Collectors.toSet()).forEach(System.out::println);

        System.out.println("================================================");
        Function<Integer, Integer> f = x -> x*x;
        System.out.println(f.apply(5));

        System.out.println("================================================");
        list.stream()
                .skip(list.size() - 3)
                .forEach(System.out::println);

        System.out.println("================================================");

       String str = "welcome to code decode and code decode welcomes you";
       Map<String, Long> collect =
               Stream.of(str.split(" "))
               .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        collect.entrySet().forEach(e -> {
            System.out.println(e.getKey() + "-" +e.getValue());
        });
    }
}
