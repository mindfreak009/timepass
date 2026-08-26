package dsa.sliding_window;

// Given a binary array nums, you should delete one element from it.
// Return the size of the longest non-empty subarray containing only 1's
// in the resulting array. Return 0 if there is no such subarray.

// Example 1:
// Input: nums = [1,1,0,1]
// Output: 3
// Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.

// Example 2:
// Input: nums = [0,1,1,1,0,1,1,0,1]
// Output: 5
// Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].

// Example 3:
// Input: nums = [1,1,1]
// Output: 2
// Explanation: You must delete one element.

// Constraints:
// 1 <= nums.length <= 105
// nums[i] is either 0 or 1.


public class LongestSubArrayOf_1_AfterDeletingOneElement {
    public static void main(String[] args) {

        // int[] arr = {1,1,0,1};
        int[] arr = {0,1,1,1,0,1,1,0,1};
        // int[] arr = {1,1,1};

        int longestSubArrayOf1 = findLongestSubArrayOf1(arr);
        System.out.println(longestSubArrayOf1);
    }

    private static int findLongestSubArrayOf1(int[] arr) {
        // It keeps track of two consecutive groups of 1s:
        // curr = current streak of consecutive 1s.
        //        prev = previous streak of consecutive 1s (just before the last 0).
        // ans = maximum combined length found.
        int prev = 0;
        int curr = 0;
        int ans = 0;

        for (int num : arr) {
            if(num == 1) curr++;
            else {
                ans = Math.max(ans, curr + prev);
                prev = curr;
                curr = 0;
            }
        }
        ans = Math.max(ans, curr + prev);
        return ans == arr.length ? ans-1 :ans;
    }
}
