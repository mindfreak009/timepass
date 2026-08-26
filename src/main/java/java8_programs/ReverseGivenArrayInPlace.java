package java8_programs;

import java.util.Arrays;
import java.util.stream.IntStream;

// Output : 5,4,3,2,1
public class ReverseGivenArrayInPlace {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        // secondApproach(arr);

        // First find the middle of array
        IntStream.range(0, arr.length / 2)
                .forEach(i -> {
                        int temp = arr[i];
                        arr[i] = arr[arr.length - i - 1];
                        arr[arr.length - i - 1] = temp;
        });

        System.out.println("Reversed Array :: " +Arrays.toString(arr));
    }

    // 2. SECOND APPROACH
    public static int[] secondApproach(int[] arr) {
        for (int i = 0; i < arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        System.out.println("Reversed Array 2:: " +Arrays.toString(arr));
        return arr;
    }
}
