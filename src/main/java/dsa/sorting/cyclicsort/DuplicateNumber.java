package dsa.sorting.cyclicsort;

// Difficulty: Medium

// Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
// There is only one repeated number in nums, return this repeated number.

// You must solve the problem without modifying the array nums and using only constant extra space.
// Example 1:
// Input: nums = [1,3,4,2,2]
// Output: 2

// Example 2:
// Input: nums = [3,1,3,4,2]
// Output: 3

// Example 3:
// Input: nums = [3,3,3,3,3]
// Output: 3

// Constraints:
// 1 <= n <= 10^5
// nums.length == n + 1
// 1 <= nums[i] <= n
// All the integers in nums appear only once except for precisely one integer which appears two or more times.

// Follow up:
// How can we prove that at least one duplicate number must exist in nums?
// Can you solve the problem in linear runtime complexity?


// Time Complexity: O(n)
// Space Complexity: O(1)

// ===========================================================================================
//           Floyd’s algorithm is mainly designed to find one duplicate number.

//       Floyd’s Cycle Detection Algorithm (Tortoise and Hare) works for finding duplicates when:
//          • Array size = n + 1
//          • Elements are in range 1 to n
//          • At least one duplicate exists
// ===========================================================================================

public class DuplicateNumber {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        // int[] arr = {1,2,3,2,4,1};
        // int[] arr = {3,1,3,4,2};
        // System.out.println(findDuplicate(arr));
       System.out.println(findDuplicateUsingFloydCycleDetection(arr));
    }

    // This method works only if:
    //    • Values are in range 1 to n
    //    • Array size is n+1
    //    • Exactly one duplicate (may appear multiple times)
    public static int findDuplicateUsingFloydCycleDetection(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: detect cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: find entry point
        slow = nums[0];  // OR fast = 0;

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }


}
