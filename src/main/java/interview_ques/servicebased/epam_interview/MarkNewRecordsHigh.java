package interview_ques.servicebased.epam_interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Given an integer array nums, create a result array where each position is marked with either 1 or 0 based on whether the corresponding element is a new record high.

//  An element is considered a new record high if:
//     ● The first element is always considered a record high and should be marked 1.
//  For every subsequent element:
//    ● It must be greater than its immediate predecessor, and
//    ● It must be greater than the maximum value seen so far, including all elements before it.
//    ● If both conditions are satisfied, mark the position with 1; otherwise, mark it with 0.

public class MarkNewRecordsHigh {
    public static void main(String[] args) {
        int[] nums = {2,1,5,3,4,8,6};  // Output: [1 0 1 0 0 1 0]
        List<int[]> result = markRecordHighs(nums);
        result.forEach(arr ->
                System.out.println(Arrays.toString(arr))
        );
    }

    // Time Complexity: O(N)
    // Space Complexity : O(N) for the result array.
    public static List<int[]> markRecordHighs(int[] nums) {

        List<int[]> finalResult = new ArrayList<>();
        // edge case
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        int[] result = new int[nums.length];
        result[0] = 1;
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > maxSoFar) {
                result[i] = 1;
            }
            maxSoFar = Math.max(maxSoFar, nums[i]);
        }

        finalResult.add(result);
        return finalResult;
    }
}
