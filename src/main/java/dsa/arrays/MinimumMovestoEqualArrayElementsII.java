package dsa.arrays;

// Leetcode Q.462
// Difficulty: Medium

// Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.
// In one move, you can increment or decrement an element of the array by 1.
// Test cases are designed so that the answer will fit in a 32-bit integer.

// Example 1:
// Input: nums = [1,2,3]
// Output: 2
// Explanation:
// Only two moves are needed (remember each move increments or decrements one element):
// [1,2,3]  =>  [2,2,3]  =>  [2,2,2]

// Example 2:
// Input: nums = [1,10,2,9]
// Output: 16

import java.util.Arrays;

public class MinimumMovestoEqualArrayElementsII {
    public static void main(String[] args) {
        // int[] arr = {1,10,2,9};
        int[] arr = {1,2,3};
        System.out.println(minMoves2(arr));
    }

    // Time Complexity: O(n logn)
    // Space Complexity: O(N)
    public static int minMoves2(int[] nums) {
        // sorting the array
        Arrays.sort(nums);

        int len = nums.length;
        int median = nums[len/2];
        int count = 0;

        for (int e1: nums) {
            count+= Math.abs(e1 - median);
        }
        return count;
    }
}
