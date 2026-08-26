package shashcode30;

// Difficulty - Medium
// You are given an array nums consisting of positive integers.
// Starting with score = 0, apply the following algorithm:

// Choose the smallest integer of the array that is not marked. If there is a tie, choose the one with the smallest index.
// Add the value of the chosen integer to score.
// Mark the chosen element and its two adjacent elements if they exist.
// Repeat until all the array elements are marked.
// Return the score you get after applying the above algorithm.

// Example 1:
// Input: nums = [2,1,3,4,5,2]
// Output: 7
// Explanation: We mark the elements as follows:
// 1 is the smallest unmarked element, so we mark it and its two adjacent elements: [2,1,3,4,5,2].
// 2 is the smallest unmarked element, so we mark it and its left adjacent element: [2,1,3,4,5,2].
// 4 is the only remaining unmarked element, so we mark it: [2,1,3,4,5,2].
// Our score is 1 + 2 + 4 = 7.

// Example 2:
// Input: nums = [2,3,5,1,3,2]
// Output: 5
// Explanation: We mark the elements as follows:
// 1 is the smallest unmarked element, so we mark it and its two adjacent elements: [2,3,5,1,3,2].
// 2 is the smallest unmarked element, since there are two of them, we choose the left-most one, so we mark the one at index 0 and its right adjacent element: [2,3,5,1,3,2].
// 2 is the only remaining unmarked element, so we mark it: [2,3,5,1,3,2].
// Our score is 1 + 2 + 2 = 5.

// Constraints:
// 1 <= nums.length <= 105
// 1 <= nums[i] <= 106

import java.util.*;


public class FindScoreOfAnArrayAfterMarkingAllElements {
    public static void main(String[] args) {
        int[] nums = {2,1,3,4,5,2};
        System.out.println(findScore(nums));
    }

    public static long findScore(int[] nums) {
        // copy
        // [element, index]
        int len = nums.length;
        int copy[][] = new int[len][2];

        for (int i=0; i< len; i++) {
            copy[i][0] =  nums[i];
            copy[i][1] = i;
        }

        // Print the 2D array without using a loop
        System.out.println("copy now ::: " + Arrays.deepToString(copy));
        Arrays.sort(copy, (a,b) -> a[0] - b[0]);

        long res = 0;
        for (int i = 0; i < len; i++) {
            int element = copy[i][0];
            int index = copy[i][1];

            if(nums[index] < 0) continue;
            res += nums[index];
            nums[index] = -nums[index];

            if(index-1 >=0 && nums[index-1]>0) {
                nums[index-1] =  -nums[index-1];
            }

            if(index+1 < len && nums[index+1]>0) {
                nums[index+1] =  -nums[index+1];
            }
        }
        return res;
    }
}
