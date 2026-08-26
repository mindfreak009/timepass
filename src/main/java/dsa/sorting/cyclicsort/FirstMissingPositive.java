package dsa.sorting.cyclicsort;

// Difficulty: Hard

// Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
// You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

// Example 1:
// Input: nums = [1,2,0]
// Output: 3
// Explanation: The numbers in the range [1,2] are all in the array.

// Example 2:
// Input: nums = [3,4,-1,1]
// Output: 2
// Explanation: 1 is in the array but 2 is missing.

// Example 3:
// Input: nums = [7,8,9,11,12]
// Output: 1
// Explanation: The smallest positive integer 1 is missing.

// Constraints:
// 1 <= nums.length <= 10^5
// -2^31 <= nums[i] <= 2^31 - 1


// Time Complexity: O(N)
public class FirstMissingPositive {
    public static void main(String[] args) {
        // int[] arr = {7,8,9,11,12};  // Output: 1
        // int[] arr = {3,4,-1,1};  // Output: 2
        int[] arr = {1,2,0};     // Output: 3
        System.out.println(firstMissingPositive(arr));
    }
    public static int firstMissingPositive(int[] nums) {
        int i = 0;
        int n = nums.length;

        while(i<n) {
            int expectedIndex = nums[i]-1;
            if(expectedIndex < 0 || expectedIndex >=n || nums[expectedIndex] == nums[i]) {
                i++;
            } else {
                swapNums(nums, expectedIndex, i);
            }
        }
        // to check the index is aligning with the numbers
        for (int j = 1; j <= n; j++) {
            int expectedIndex = j-1;
            if(nums[expectedIndex] != j) return j;
        }
        return n+1;
    }

    private static void swapNums(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
