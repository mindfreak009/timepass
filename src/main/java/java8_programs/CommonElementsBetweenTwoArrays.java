package java8_programs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommonElementsBetweenTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {4,6,5,7,8};

        List<Integer> commonElements = Arrays.stream(arr1)
                .filter(arr1Number -> Arrays.stream(arr2)
                                    .anyMatch(arr2Number -> arr2Number == arr1Number))
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Common Elements of 2 Arrays are :: " +commonElements);


    }
}
