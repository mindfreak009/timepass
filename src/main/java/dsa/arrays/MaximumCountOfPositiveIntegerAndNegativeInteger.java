package dsa.arrays;

// Difficulty: EASY

// Given an array nums sorted in non-decreasing order, return the maximum between the number of positive integers and
// the number of negative integers.

// In other words, if the number of positive integers in nums is pos and the number of negative integers is neg,
// then return the maximum of pos and neg.
// Note that 0 is neither positive nor negative.

// Example 1:
// Input: nums = [-2,-1,-1,1,2,3]
// Output: 3
// Explanation: There are 3 positive integers and 3 negative integers. The maximum count among them is 3.

// Example 2:
// Input: nums = [-3,-2,-1,0,0,1,2]
// Output: 3
// Explanation: There are 2 positive integers and 3 negative integers. The maximum count among them is 3.

// Example 3:
// Input: nums = [5,20,66,1314]
// Output: 4
// Explanation: There are 4 positive integers and 0 negative integers. The maximum count among them is 4.

// Constraints:
//      1 <= nums.length <= 2000
//     -2000 <= nums[i] <= 2000
// nums is sorted in a non-decreasing order.

// Follow up: Can you solve the problem in O(log(n)) time complexity?


public class MaximumCountOfPositiveIntegerAndNegativeInteger {
    public static void main(String[] args) {// Output: 3
       // int[] nums = {-2,-1,-1,1,2,3};       // Output: 3
        int[] nums = {-3, -1, 0, 0, 1, 1, 6};  // Output: 3
        System.out.println(maximumCount(nums));
    }

    public static int maximumCount(int[] nums) {
        int start = 0;
        int n = nums.length;
        int end = n-1;
        int negPos = binaryySearch(nums, 0, end, -1);  // log(n)
        int posPos = binaryySearch(nums, negPos, end, 0);   // log(n - negPos)
        int posCount = (n - posPos);

        return Math.max(negPos, posPos);
    }

    public static int binaryySearch(int nums[], int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start)/2;
            if(nums[mid] <= target){
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        return start;
    }
}
