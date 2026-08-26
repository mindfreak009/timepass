package dsa.arrays;

// Time Complexity : O(N)
// Space Complexity : O(1)

import java.util.Arrays;

public class MoveZeroesToStartOfArray {
    public static void main(String[] args) {
        int[] arr = { 1, 0, 2, 0, 3, 0 };
        moveZerosToStartOfArray(arr);
    }

    private static void moveZerosToStartOfArray(int[] arr) {
        // finding length of the array
        int n = arr.length;

        // find the index of last zero
        int end = -1;

        for (int i = n-1; i >=0 ; i--) {
            if(arr[i] == 0) {
                end = i;
                break;
            }
        }

        System.out.println("end :: " +end);

        // Modifying the array by traversing from end-1 to 0
        for (int i = end-1; i >=0 ; i--) {

            // if element is a non-zero element,
            // swap it with arr[end]
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[end];
                arr[end] = temp;
                end--;
            }
            System.out.println("here :: " + Arrays.toString(arr));
        }

        // printing the array after pushing all zeros to the front
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
