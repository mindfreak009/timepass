package shashcode30;

// Difficulty : Medium
//

// You are given a 0-indexed array nums and a non-negative integer k.
// In one operation, you can do the following:
// Choose an index i that hasn't been chosen before from the range [0, nums.length - 1].
// Replace nums[i] with any integer from the range [nums[i] - k, nums[i] + k].
// The beauty of the array is the length of the longest subsequence consisting of equal elements.

// Return the maximum possible beauty of the array nums after applying the operation any number of times.
// Note that you can apply the operation to each index only once.

// A subsequence of an array is a new array generated from the original array by deleting some elements (possibly none)
// without changing the order of the remaining elements.

// Example 1:
// Input: nums = [4,6,1,2], k = 2
// Output: 3
// Explanation: In this example, we apply the following operations:
//- Choose index 1, replace it with 4 (from range [4,8]), nums = [4,4,1,2].
//- Choose index 3, replace it with 4 (from range [0,4]), nums = [4,4,1,4].
// After the applied operations, the beauty of the array nums is 3 (subsequence consisting of indices 0, 1, and 3).
// It can be proven that 3 is the maximum possible length we can achieve.

// Example 2:
// Input: nums = [1,1,1,1], k = 10
// Output: 4
// Explanation: In this example we don't have to apply any operations.
// The beauty of the array nums is 4 (whole array).

import java.util.Arrays;

public class MaximumBeautyOfAnArrayAfterApplyingOperation_2779 {
    public static void main(String[] args) {

        int[] nums = {4,6,1,2};
        int k = 2;

        System.out.println(maximumBeauty(nums, k));
    }

    public static int maximumBeauty(int[] nums, int k) {
        if(nums.length==1) return 1;

        // create count array
        int max = 0;
        for (int num: nums) {
            max = Math.max(max, num);
        }
        // System.out.println(max);

        int count[] = new int[max+1];
        // System.out.println(Arrays.toString(count));

        // insert range in count array
        for (int num : nums) {
            count[Math.max(num-k, 0)]++;
            count[Math.min(num+k+1, max)]--;
        }

        // find max of prefixSum
        int curSum = 0;
        int maxSum = 0;
        for (int c: count) {
            curSum+= c;
            maxSum = Math.max(maxSum, curSum);
        }

        return  maxSum;
    }
}
