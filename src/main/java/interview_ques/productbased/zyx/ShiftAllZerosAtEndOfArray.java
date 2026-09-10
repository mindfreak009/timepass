package interview_ques.productbased.zyx;

import java.util.Arrays;

public class ShiftAllZerosAtEndOfArray {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        System.out.println(Arrays.toString(moveAllZerosToRight(arr)));
        System.out.println(Arrays.toString(moveAllZerosToLeft(arr)));
    }

    // Time Complexity: O(N)
    // Space Complexity: O(1), since we are using the same original array
    public static int[] moveAllZerosToLeft(int[] arr) {
        int len = arr.length;
        int k = len - 1;

        // Scan from right → left
        for(int i=len-1; i>=0; i--) {
            if(arr[i] != 0) {
                arr[k--] = arr[i];
            }
        }

        // fill remaining position with zeros.
        while(k >= 0) {
            arr[k--] = 0;
        }

        return arr;
    }

    public static int[] moveAllZerosToRight(int[] arr) {
        int len = arr.length;
        int k = 0;

        for(int i=0; i<len; i++) {
            if(arr[i] != 0) {
                arr[k++] = arr[i];
            }
        }

        // fill remaining position with other elements.
        while(k < len) {
            arr[k++] = 0;
        }

        return arr;
    }
}
