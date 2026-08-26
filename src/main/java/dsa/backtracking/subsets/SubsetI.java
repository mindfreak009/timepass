package dsa.backtracking.subsets;

// Difficulty: Medium
// Ques no(Leetcode): 78

// Given an integer array nums of unique elements, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.

// Example 1:
// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

// Example 2:
// Input: nums = [0]
// Output: [[],[0]]

// Constraints:
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
// All the numbers of nums are unique.


import java.util.ArrayList;
import java.util.List;

public class SubsetI {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        subsequences(0, nums, current, result);
        return result;
    }

    // Time Complexity: (N * 2^N)
    private static void subsequences(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // base case
        if(index == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        // include
        current.add(nums[index]);
        // pick
        subsequences(index+1, nums, current, result);

        // remove
        current.remove(current.size()-1);  // we are removing last index element

        // no pick
        subsequences(index+1, nums, current, result);

    }
}
