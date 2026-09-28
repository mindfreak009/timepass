package interview_ques.servicebased.epam_interview;

// LeetCode Ques: 45 (Jump Game II)
// Difficulty: Medium

// You are given a 0-indexed array of integers nums of length n. You are initially positioned at index 0.
// Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at index i, you can jump to any index (i + j) where:

/**   ●  0 <= j <= nums[i] and
      ●  i + j < n
**/

// Return the minimum number of jumps to reach index n - 1. The test cases are generated such that you can reach index n - 1.

// Example 1:
// Input: nums = [2,3,1,1,4]
// Output: 2
// Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

// Example 2:
// Input: nums = [2,3,0,1,4]
// Output: 2

// Constraints:
/**    ● 1 <= nums.length <= 10^4
       ● 0 <= nums[i] <= 1000
       ● It's guaranteed that you can reach nums[n - 1].
**/

// Greedy algorithm
// Time complexity: O(N)

public class FindMinimumJump {
    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        // int[] arr = {2,4,1,2,3,1,1,2};

        int minJumps = findMinJumps(arr);
        System.out.println("Minimum Jumps :: " +minJumps);

    }

    private static int findMinJumps(int[] nums) {
        int totalJumps = 0;

        // destination is last index
        int dest = nums.length - 1;

        int coverage = 0, lastJumpIdx = 0;

        // Base case
        if (nums.length == 1)
            return 0;

        // Greedy strategy: extend coverage as long as possible
        for (int i = 0; i < nums.length; i++) {
            coverage = Math.max(coverage, i + nums[i]);

            if (i == lastJumpIdx) {
                lastJumpIdx = coverage;
                totalJumps++;

                // check if we have reached destination already
                if (coverage >= dest) {
                    return totalJumps;
                }
            }
        }

        return totalJumps;
    }
}
