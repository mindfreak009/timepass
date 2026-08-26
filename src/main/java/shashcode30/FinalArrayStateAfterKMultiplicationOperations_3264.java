package shashcode30;

// Difficulty: Easy

// You are given an integer array nums, an integer k, and an integer multiplier.
// You need to perform k operations on nums. In each operation:

// Find the minimum value x in nums. If there are multiple occurrences of the minimum value,
// select the one that appears first.
// Replace the selected minimum value x with x * multiplier.
// Return an integer array denoting the final state of nums after performing all k operations.

// Example 1:
// Input: nums = [2,1,3,5,6], k = 5, multiplier = 2
// Output: [8,4,6,5,6]
// Explanation:
// Operation	           Result
// After operation 1	[2, 2, 3, 5, 6]
// After operation 2	[4, 2, 3, 5, 6]
// After operation 3	[4, 4, 3, 5, 6]
// After operation 4	[4, 4, 6, 5, 6]
// After operation 5	[8, 4, 6, 5, 6]

// Example 2:
// Input: nums = [1,2], k = 3, multiplier = 4
// Output: [16,8]
// Explanation:
// Operation	        Result
// After operation 1	[4, 2]
// After operation 2	[4, 8]
// After operation 3	[16, 8]

import java.util.Arrays;
import java.util.PriorityQueue;

public class FinalArrayStateAfterKMultiplicationOperations_3264 {
    public static void main(String[] args) {
        int[] nums = {2,1,3,5,6};
        int k = 5, multiplier = 2;
        System.out.println(Arrays.toString(getFinalState(nums, k, multiplier)));

    }

    // Time Complexity : O(N) + K.log(N)
    // Space Complexity: O(N)

    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        // element, index
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
           if(a[0] == b[0]) return a[1] - b[1];  // if numbers are same, take the number with smallest index
           return a[0] - b[0];
        });

        // insert
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        // perform K operations
        while(k > 0){
            int[] arr = pq.poll();
            nums[arr[1]] = nums[arr[1]] * multiplier;
            pq.offer(new int[]{nums[arr[1]], arr[1]});
            k--;
        }
        return  nums;
    }
}
