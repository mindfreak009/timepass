package interview;
// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.

// Example 1:
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

// Example 2:
// Input: nums = [3,2,4], target = 6
// Output: [1,2]

// Example 3:
// Input: nums = [3,3], target = 6
// Output: [0,1]

// Constraints:
// 2 <= nums.length <= 10^4
// -10^9 <= nums[i] <= 10^9

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(twoSumm(nums, target)));
    }


    public static int[] twoSumm(int[] nums, int target) {
        if(nums.length <=2) {
            return new int[] {-1, -1};
        }

        Map<Integer, Integer> map = new HashMap<>();
        // 3,2,4
        for (int i = 0; i < nums.length; i++) {
            int sum = target - nums[i];
            if(map.containsKey(sum)) {
                return new int[] {map.get(sum), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {-1,-1};
    }
}


