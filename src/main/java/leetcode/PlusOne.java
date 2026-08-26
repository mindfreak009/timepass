package leetcode;

//  Example 1:
//  Input: digits = [1,2,3]
//  Output: [1,2,4]
//  Explanation: The array represents the integer 123.
//  Incrementing by one gives 123 + 1 = 124.
//  Thus, the result should be [1,2,4].

//  Example 2:
//  Input: digits = [4,3,2,1]
//  Output: [4,3,2,2]
//  Explanation: The array represents the integer 4321.
//  Incrementing by one gives 4321 + 1 = 4322.
//  Thus, the result should be [4,3,2,2].

//  Example 3:
//  Input: digits = [9]
//  Output: [1,0]
//  Explanation: The array represents the integer 9.
//  Incrementing by one gives 9 + 1 = 10.
//  Thus, the result should be [1,0].

import java.util.*;

public class PlusOne {
    public static void main(String[] args) {
       // int[] digits = {1,2,3};
        int[] digits = {1,9};
        // int[] digits = {9, 9, 9, 9};
       // int[] digits = {3,4,9,9,};
        // int[] digits = {4,3,2,1};
        // int[] digits = {4,1,2,1,9};
        // int[] digits = {9};
        // int[] digits = {2,2,1};
       // System.out.println(Arrays.toString(plusOne(digits)));
        System.out.println(Arrays.toString(plusOne(digits)));
    }
// 9,9,9,9
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
