package interview_ques.bitgo;

import java.util.*;

public class FindIntersection {
    public static void main(String[] args) {
        String[] str = new String[]{"1, 3, 4, 7, 13" , "1, 2, 4, 13, 15"};
        // Output: 1,4,13

        System.out.println("final result :: " +findIntersection(str));
    }

    private static List<Integer> findIntersection(String[] str) {

        String[] arr1 = str[0].split(", ");
        String[] arr2 = str[1].split(", ");

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        // Converting str[] to int[] array
        int[] array1 = Arrays.stream(arr1)
                .mapToInt(Integer::parseInt)
                .toArray();

        // Converting str[] to int[] array
        int[] array2 = Arrays.stream(arr2)
                .mapToInt(Integer::parseInt)
                .toArray();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array1.length; i++) {
            map.put(array1[i], map.getOrDefault(array1[i], 0) + 1);
        }

        for (int i = 0; i < array2.length; i++) {
            map.put(array2[i], map.getOrDefault(array2[i], 0) + 1);
        }

       return   map.entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
    }
}

