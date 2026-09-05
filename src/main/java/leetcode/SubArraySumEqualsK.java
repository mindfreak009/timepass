package leetcode;

// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
// A sub-array is a contiguous non-empty sequence of elements within an array

// Example 1:
// Input: nums = [1,1,1], k = 2
// Output: 2

// Example 2:
// Input: nums = [1,2,3], k = 3
// Output: 2

// Constraints:
//   ⦿ 1 <= nums.length <= 2 * 10^4
//   ⦿ -1000 <= nums[i] <= 1000
//   ⦿ -10^7 <= k <= 10^7

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
    public static void main(String[] args) {
        // int nums[] = {1,1,1};
        // int k = 2;
        int nums[] = {1,2,3};
        int k = 3;


        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        // Map to store (prefixSum -> frequency)
        Map<Integer, Integer> map = new HashMap<>();

        // Base case: A prefix sum of 0 has occurred once (empty subarray)
        map.put(0, 1);

        int count = 0;
        int currentSum = 0;

        for (int num : nums) {
            // 1. Update cumulative prefix sum
            currentSum += num;

            // 2. Check if (currentSum - k) exists in the map
            if (map.containsKey(currentSum - k)) {
                count += map.get(currentSum - k);
            }

            // 3. Record the current prefix sum in the map
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}
