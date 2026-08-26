package durgasoft_java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class SumOfOddNumbersInAList {
    public static void main(String[] args) {
       // Comparable<Integer> comparable = (a,b) -> a.compareTo(b) > 0;
        //List<Integer> numbers = Arrays.asList(1,9,65,62,44,100,823,65,22,25);
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        numbers
                .stream()
                .map(number -> number*number)
                .collect(Collectors.toList());
        Integer sumOddNumbers = numbers
                .stream()
                .filter(x -> x % 2 != 0)
                .reduce(0, (a, b) -> a + b);
        System.out.println(sumOddNumbers);

        // APPROACH: 2
        int sum = numbers
                .stream()
                .filter(x -> x % 2 != 0)
                .mapToInt(n -> n).sum();
        System.out.println(sum);

        System.out.println("***********************************************");
        List<String> stringList = Arrays.asList("Mumbai", "Pune", "Delhi", "Bangalore", "Guwahati", "Rishikesh");
        stringList
                .stream()
                .sorted(Comparator.comparing(str -> str.length()))
                .forEach(System.out::println);

        String date = new Date().toString();
        System.out.println("date ::::" +date);

    }
}
