package dsa.backtracking.subsets;

// Difficulty: Medium
// Ques: 90

// Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.

// Example 1:
// Input: nums = [1,2,2]
// Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

// Example 2:
// Input: nums = [0]
// Output: [[],[0]]


// Constraints:
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2};
        int[] nums2 = {2};
        System.out.println(subsets(nums1));
        System.out.println(subsets(nums2));
    }

    // Time Complexity: (NlogN)
    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        subsequencesWithDuplicates(0, nums, current, result);
        return result;
    }

    // Time Complexity: (N * 2^N)
    private static void subsequencesWithDuplicates(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // base case
        if(index == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        // include
        current.add(nums[index]);
        // pick
        subsequencesWithDuplicates(index+1, nums, current, result);

        // remove
        current.remove(current.size()-1);  // we are removing last index element

        // no pick
        // avoid all duplicates
        while((index+1) < nums.length && nums[index] == nums[index+1]) {
            index++;
        }
        subsequencesWithDuplicates(index+1, nums, current, result);

    }
}
