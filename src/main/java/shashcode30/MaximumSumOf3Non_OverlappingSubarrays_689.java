package shashcode30;

// Difficulty: Hard
//=================

// Given an integer array nums and an integer k, find three non-overlapping subarrays of length k
// with maximum sum and return them.

// Return the result as a list of indices representing the starting position of each interval (0-indexed).
// If there are multiple answers, return the lexicographically smallest one.

// Example 1:
// Input: nums = [1,2,1,2,6,7,5,1], k = 2
// Output: [0,3,5]
// Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
// We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.

// Example 2:
// Input: nums = [1,2,1,2,1,2,1,2,1], k = 2
// Output: [0,2,4]

// Constraints:
// 1 <= nums.length <= 2 * 104
// 1 <= nums[i] < 216
// 1 <= k <= floor(nums.length / 3)

import java.util.Arrays;

public class MaximumSumOf3Non_OverlappingSubarrays_689 {
    public static void main(String[] args) {
        // int[] nums = {1,2,1,2,6,7,5,1};
        int[] nums = {1,2,1,2,1,2,1,2,1};
        int k = 2;
        System.out.println(Arrays.toString(maxSumOfThreeSubarrays(nums, k)));
    }

    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int bestSingleStart = 0;
        int[] bestDoubleStart = {0,k};
        int[] bestTripleStart = {0,k, k*2};

        // initial window
        int singleWindowSum = 0;
        for (int i = 0; i < k; i++) {
            singleWindowSum+= nums[i];
        }
        int doubleWindowSum = 0;
        for (int i = k; i < k*2; i++) {
            doubleWindowSum+= nums[i];
        }

        int tripleWindowSum = 0;
        for (int i = k*2; i < k*3; i++) {
            tripleWindowSum+= nums[i];
        }

        int bestSingleSum = singleWindowSum;
        int bestDoubleSum = singleWindowSum +  doubleWindowSum;
        int bestTripleSum = singleWindowSum + doubleWindowSum + tripleWindowSum;

        int singleStartIndex = 1;
        int doubleStartIndex = k + 1;
        int tripleStartIndex = k * 2 + 1;

        while(tripleStartIndex <= nums.length - k) {
            // current sum
            singleWindowSum = singleWindowSum - nums[singleStartIndex - 1] +  nums[singleStartIndex + k - 1];
            doubleWindowSum = doubleWindowSum - nums[doubleStartIndex - 1] +  nums[doubleStartIndex + k - 1];
            tripleWindowSum = tripleWindowSum - nums[tripleStartIndex - 1] +  nums[tripleStartIndex + k - 1];

            // updating best sum
            if(singleWindowSum > bestSingleSum) {
                bestSingleStart = singleStartIndex;
                bestSingleSum = singleWindowSum;
            }

            if(doubleWindowSum+ bestSingleSum > bestDoubleSum) {
                bestDoubleStart[0] = bestSingleStart;
                bestDoubleStart[1] = doubleStartIndex;
                bestDoubleSum =  doubleWindowSum + bestSingleSum;
            }

            if(tripleWindowSum + bestDoubleSum > bestTripleSum) {
                bestTripleStart[0] = bestDoubleStart[0];
                bestTripleStart[1] = bestDoubleStart[1];
                bestTripleStart[2] = tripleStartIndex;
                bestTripleSum = tripleWindowSum + bestDoubleSum;
            }

            singleStartIndex += 1;
            doubleStartIndex += 1;
            tripleStartIndex += 1;

        }
        return bestTripleStart;
    }
}
