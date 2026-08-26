package dsa.backtracking.permutations;

// Difficulty: Medium
// Ques: 46

// Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

// Example 1:
// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

// Example 2:
// Input: nums = [0,1]
// Output: [[0,1],[1,0]]

// Example 3:
// Input: nums = [1]
// Output: [[1]]

// Constraints:
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// All the integers of nums are unique.

import java.util.ArrayList;
import java.util.List;

// Time Complexity: (N * N!)
public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        permutations(nums, current, result);
        return result;

    }

    public static void permutations(int[] nums, List<Integer> current, List<List<Integer>> result) {
        // base case
        if(current.size() == nums.length) {
            result.add(new ArrayList<>(current));
        }

        for (int i = 0; i < nums.length; i++) {
            if(current.contains(nums[i])) continue;
            // include
            current.add(nums[i]);
            // pick
            permutations(nums, current, result);
            // remove
            // current.remove(current.size()-1);
            current.removeLast();
        }
    }
}
