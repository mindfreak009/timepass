package interview_ques;

import java.util.Arrays;

// Time Complexity : O(N)
public class LargestElementInArray {
    public static void main(String[] args) {
        int[] arr = {3,5,2,7,4,9, -1};

        findLargestElement(arr);
        ;
        System.out.println(Arrays.stream(arr)
                .max().getAsInt());
    }

    private static void findLargestElement(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            if(arr[i-1] < arr[i]) {
                max = arr[i];
            } else {
                max = arr[i-1];
            }
        }
        System.out.println(max);
    }
}
