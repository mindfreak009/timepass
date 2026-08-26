package leetcode;

// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.

// Solve this question with an algorithm that is less than O(n^2) time complexity
// https://leetcode.com/problems/two-sum/description/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
       int[] nums = {2,7,11,15};
       int target = 9;
        // int[] nums = {3,2,4};
         // int target = 6;

        // int[] nums = {-1,-2,-3,-4,-5};
        // int target = -8;
         // int[] nums = {3,3};
         // int target = 6;

       //  System.out.println(Arrays.toString(getTwoSumIndex(nums, target)));
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        if(nums.length < 2) {
            return new int[] {-1, -1};
        }

        // 2, 7, 11, 15
        // target: 9
        Map<Integer, Integer> map = new HashMap<>();
        for(int i= 0; i<nums.length; i++) {
            int sum = target - nums[i];
            System.out.println("sum:: " +sum);
            if(map.containsKey(sum)) {
                System.out.println("here1 :: " + Arrays.toString(new int[]{map.get(sum), i}));
                return new int[] {map.get(sum), i};
            } else {
                map.put(nums[i], i);
                System.out.println("here 2 :::" + map);
            }
        }
        return new int[] {-1, -1};
    }
}
