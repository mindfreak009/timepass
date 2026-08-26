package dsa.binarysearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class BinarySearch {
    public static void main(String[] args) {

        int[] arr = {4,6,9,17,29,44,62,70,99,105,222,363,455,500};
        System.out.println(String.format("Number is found in index:: "
                + binarySearch(arr, 500)));
        Stream<Integer> sorted = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder());
        sorted.forEach(e -> System.out.print(e + " "));
        //System.out.println("sorted :: " + Arrays.toString(sorted));

        System.out.println();
        System.out.println("===========================================");
        List<Integer> list = Arrays.asList(1,3,2,4,3,1,2);
        list.stream().distinct().sorted(Comparator.reverseOrder()).forEach(i -> System.out.print(i + " "));
    }

    // return the index
    // return -1 if it does not exist
    static int binarySearch(int[] arr, int target) {

        int start = 0;
        int end = arr.length -1;

        int[] ar = new int[2];
        while(start <= end) {
            // find the middle element
            // int mid = (start + end)/2;   // this might possible (start + end) that it might exceed int range
            int mid = start + (end - start)/2;

            if(target < arr[mid]) {
                end = mid - 1;
            } else if(target > arr[mid]) {
                start = mid + 1;
            } else {
                // answer found
                return mid;
            }
        }
      return -1;
    }
}
