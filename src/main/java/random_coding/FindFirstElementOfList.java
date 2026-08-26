package random_coding;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


interface AX{
    default void msg(){
        System.out.println("Hi");
    }
}



interface B{
    default void msg(){
        System.out.println("Hello");
    }
}

public class FindFirstElementOfList implements AX, B{

    public static void main(String[] args) {

        new FindFirstElementOfList().msg();
        // To find first element of a list
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
       myList.stream().findFirst().ifPresent(System.out::println);

        // To find total number of elements present in the list using Stream functions
        List<Integer> myList2 = Arrays.asList(10,15,8,49,25,98,98,32,15);
        long count = myList2.stream().count();
        System.out.println("Count of total elements in list :: " +count);

        // To find the maximum value element present in a list
        List<Integer> myList3 = Arrays.asList(10,15,8,49,25,98,98,32,15);
        int maxNum =  myList2.stream().max(Integer::compare).get();
        System.out.println("Maximum number is :: " +maxNum);


        // Given a list of integers, sort all the values present in it.
        List<Integer> myList4 = Arrays.asList(10,15,8,49,25,98,98,32,15);
        List<Integer> sortedList = myList4.stream().sorted().collect(Collectors.toList());
        System.out.println("sortedList ::: " +sortedList);

        // Given a list of integers, sort all the values present in it in descending order
        List<Integer> myList5 = Arrays.asList(10,15,8,49,25,98,98,32,15);
        List<Integer> sortedList2 = myList4.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("sortedList in desc order ::" +sortedList2);

        // perform cube on list elements and filter numbers greater than 50
        List<Integer> integerList = Arrays.asList(4,5,6,7,1,2,3);
        integerList.stream()
                .map(i -> i*i*i)
                .filter(i -> i>50)
                .forEach(System.out::println);

        // Write a Java 8 program to sort an array and then convert the sorted array into Stream
        int arr[] = { 99, 55, 203, 99, 4, 91 };
        Arrays.parallelSort(arr);
        Arrays.stream(arr).forEach(System.out::println);

        // use map to convert object into Uppercase in Java 8
        String str = "hello, I am a boy";
        Stream.of(str).map(i -> i.toUpperCase()).forEach(System.out::println);

        //  program to print the count of each character in a String
        String strr = "This is Pune";
        LinkedHashMap<String, Long> linkedHashMap =
                Stream.of(strr.split(""))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy
                        (st -> strr, LinkedHashMap::new, Collectors.counting()));

        System.out.println("linkedHashMap :: " + linkedHashMap);

        // To find only duplicate elements with its count from the String
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String, Long> collection = names.stream()
                .filter(x -> Collections.frequency(names, x) >= 1)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()
                ));
        System.out.println("collection ::: " +collection);
    }

    @Override
    public void msg() {
        B.super.msg();
    }
}
