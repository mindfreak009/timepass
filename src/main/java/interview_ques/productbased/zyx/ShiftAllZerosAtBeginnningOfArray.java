package interview_ques.productbased.zyx;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShiftAllZerosAtBeginnningOfArray {
    public static void main(String[] args) {

        Function<Integer, String> func = (t) -> "output : " + t;
        System.out.println(func.apply(88));

        String str = "Nitin";
        StringBuilder stringBuilder = new StringBuilder(str);
        if (stringBuilder.reverse().toString().equalsIgnoreCase(str)) {
            System.out.println("String is palindrome");
        } else {
            System.out.println("String is NOT palindrome");
        }


        Integer[] array = {4, 0, 3, 0, 2, 0, 1};
        // Integer[] array = {1, 2, 3, 4, 5, 0, 0, 0, 0};

        StringBuilder sb = new StringBuilder();
        sb.append("Hello");

        Map<StringBuilder, Integer> map = new HashMap<>();
        map.put(sb, 1);
        System.out.println("here1 ::: " + map.get("sb"));

        map.put(sb.append("Kumar"), 2);
        // map.put(new StringBuilder("hello"), 1 );
        // map.put(new StringBuilder("hello"), 2);

        System.out.println("here2 ::: " + map.get("sb"));

        // 1. Java 8 Approach
        Integer[] result = Stream.concat(
                Arrays.stream(array).filter(num -> num == 0),
                Arrays.stream(array).filter(num -> num != 0)
        ).toArray(Integer[]::new);

        System.out.println("First Approach :: " + Arrays.toString(result));


       //  2. Normal Java Approach
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0 && i > 0) {
                int temp = array[i - 1];
                if (temp != 0) {
                    array[i - 1] = 0;
                    array[i] = temp;
                    i = -1;
                }
            }
        }
        System.out.println("Second Approach :: " +Arrays.toString(array));


    // 3. Third Approach
        int j = 0;
        for(var i=0;i< array.length;i++){
            if(array[i]!=0){
                j = i;
                while(j< array.length){
                    if(array[j]==0){
                        //swap the next element
                        array[j] = array[i];
                        array[i]=0;
                        break;
                    }
                    j++;
                }
            }
        }
        System.out.println("Third Approach :: " +Arrays.toString(array));


        // 4. Approach
        // Time complexity : O(N)
        // Reason :   Since the inner loop's iterations are limited to the range of the outer loop and don't depend
        //            on the array's size directly, we can simplify the time complexity to  O(N)
        int temp = 0;
        int startIndex = 0;

        // Integer[] array = {4, 0, 3, 0, 2, 0, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                for (int b = startIndex; b <= i; b++) {
                    temp = array[b];
                    array[b] = array[i];
                    array[i] = temp;
                }
              // startIndex += 1;
            }
        }

        System.out.println("Fourth Approach :: " +Arrays.toString(array));

        // ---------------------------------------------------------------------------------------------------------
        //  Giving desired output //

        int[] arr = {1,2,2,1,3};
        Map<Integer, Long> collect = Arrays.stream(arr)
                .boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);

       collect.entrySet().stream()
                .filter(x -> x.getValue() == 1)
               .map(Map.Entry::getKey)
                .forEach(System.out::println);

        Arrays.stream(arr).boxed().filter(n->Collections.frequency(Collections.singleton(arr), n) == 1).forEach(System.out::println);

        // ---------------------------------------------------------------------------------------------------------
        // Not giving desired output  //

        // Convert array to set to remove duplicates and then back to list
        List<Integer> distinctElements = Arrays.stream(arr)
                .boxed() // Convert int to Integer
                .collect(Collectors.toSet()) // Collect unique elements into a set
                .stream()
                .collect(Collectors.toList()); // Convert set back to list

        // Output the list of distinct elements
        System.out.println("Distinct elements: " + distinctElements);

    }
}
