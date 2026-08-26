package dsa.arrays;

// You are given an integer array nums of even length. You have to split the array into two parts nums1 and nums2 such that:
//  nums1.length == nums2.length == nums.length / 2.
//  nums1 should contain distinct elements.
//  nums2 should also contain distinct elements.
//  Return true if it is possible to split the array, and false otherwise.

// Example 1:
// Input: nums = [1,1,2,2,3,4]
// Output: true
// Explanation: One of the possible ways to split nums is nums1 = [1,2,3] and nums2 = [1,2,4].

// Example 2:
// Input: nums = [1,1,1,1]
// Output: false
// Explanation: The only possible way to split nums is nums1 = [1,1] and nums2 = [1,1]. Both nums1 and nums2 do not contain
// distinct elements. Therefore, we return false.


import java.util.*;

public class SplitTheArray_3046 {
    public static void main(String[] args) {
        int[] nums1 = {1,1,2,2,3,4};   // OUTPUT: True
        int[] nums2 = {1,1,1,1};    // Output: False
        int[] nums3 = {10,1,7,4,5,1,6,4};  // OUTPUT: True
        int[] nums4 = {6,1,3,1,1,8,9,2};  // OUTPUT: False
        int[] nums5 = {2,10,2,7,8,9,7,6,6,9};  // OUTPUT: True
        int[] nums6 = {8,9,8,5,9,3,3,1,2,1};  // OUTPUT: True    [1 1 2 3 3 5 8 8 9 9]

        System.out.println(isPossibleToSplit(nums1));
        System.out.println(isPossibleToSplit(nums2));
        System.out.println(isPossibleToSplit(nums3));
        System.out.println(isPossibleToSplit(nums4));
        System.out.println(isPossibleToSplit(nums5));
        System.out.println(isPossibleToSplit(nums6));
    }

    public static boolean isPossibleToSplit(int[] nums) {

        // This is a bitwise AND operation with 1. The result of this operation will be 1 if the least significant bit (the rightmost bit) of
        // nums.length is 1 (i.e., if the number is odd),
        // and 0 if it is 0 (i.e., if the number is even).
        // Essentially, this checks if nums.length is odd or even.
        if((nums.length & 1) == 1) return false;

        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            int value = map.getOrDefault(num, 0)+1;
            if(value > 2)
                return false;
            map.put(num, value);
        }

        return true;
    }
}
