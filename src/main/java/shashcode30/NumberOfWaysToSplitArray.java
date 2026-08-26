package shashcode30;

// Difficulty: Medium
// ========================

// Example 1:
// Input: nums = [10,4,-8,7]
// Output: 2
// Explanation:
// There are three ways of splitting nums into two non-empty parts:
// - Split nums at index 0. Then, the first part is [10], and its sum is 10.
//   The second part is [4,-8,7], and its sum is 3. Since 10 >= 3, i = 0 is a valid split.

// - Split nums at index 1. Then, the first part is [10,4], and its sum is 14.
//   The second part is [-8,7], and its sum is -1. Since 14 >= -1, i = 1 is a valid split.

// - Split nums at index 2. Then, the first part is [10,4,-8], and its sum is 6.
//   The second part is [7], and its sum is 7. Since 6 < 7, i = 2 is not a valid split.
// Thus, the number of valid splits in nums is 2.

// Example 2:
// Input: nums = [2,3,1,0]
// Output: 2
// Explanation:
// There are two valid splits in nums:
// - Split nums at index 1. Then, the first part is [2,3], and its sum is 5.
//   The second part is [1,0], and its sum is 1. Since 5 >= 1, i = 1 is a valid split.

// - Split nums at index 2. Then, the first part is [2,3,1], and its sum is 6.
//   The second part is [0], and its sum is 0. Since 6 >= 0, i = 2 is a valid split.

//  Constraints:
// =======================
//  2  <= nums.length <= 105
// -105 <= nums[i] <= 105



// Time Complexity : O(N) + O(N)
// Space Complexity: O(1)
public class NumberOfWaysToSplitArray {
    public static void main(String[] args) {
        // int[] nums = {10,4,-8,7};   // Output: 2
        int[] nums = {2,3,1,0};        // Output: 2
        System.out.println(waysToSplitArray(nums));
    }

    public static int waysToSplitArray(int[] nums) {

        long right = 0;
        long left = 0;
        for (int num : nums) {
            right += num;
        }

        int totalCount = 0;

        for (int i = 0; i < nums.length-1; i++) {
            left  += nums[i];
            right -= nums[i];
            if(left >= right) {
                totalCount++;
            }
        }
        return totalCount;
    }
}
