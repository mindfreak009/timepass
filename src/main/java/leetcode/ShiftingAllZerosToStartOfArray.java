package leetcode;

import java.util.Arrays;
import java.util.stream.Stream;

public class ShiftingAllZerosToStartOfArray {
    public static void main(String[] args) {
        // int[] arr = {1, 2, 0, 4, 0, 9, 0, 5, 0, 6};
        int[] arr = {1, 0, 0, 2, 3, 0, 0, 4, 0};

        Integer[] shiftZerosAtBeginningArray = Stream.concat(
                Arrays.stream(arr).filter(i -> i == 0).boxed(),
                Arrays.stream(arr).filter(i -> i != 0).boxed()
        ).toArray(Integer[]::new);

        System.out.println("allZerosAtBeginning ::: " + Arrays.toString(shiftZerosAtBeginningArray));
        System.out.println("=========================================================================");
        shiftAllZerosToStartOfArray(arr);
    }

    // Time complexity : O(N)
    // Reason :   Since the inner loop's iterations are limited to the range of the outer loop and don't depend
    //            on the array's size directly, we can simplify the time complexity to  O(N)
    private static void shiftAllZerosToStartOfArray(int[] arr) {
        //  int[] arr = {1, 2, 0, 4, 0, 9, 0, 5, 0, 6};
        //  Shift all zeros to the start of the array
        int temp = 0;
        int startIndex = 0;
        // int startIndex = arr.length;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                for (int j = startIndex; j < i; j++) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        System.out.println("final output ::: " + Arrays.toString(arr));
    }
}
