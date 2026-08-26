package dsa.sliding_window;

// Leetcode Ques. 2134
// Difficulty: Medium

// A swap is defined as taking two distinct positions in an array and swapping the values in them.
// A circular array is defined as an array where we consider the first element and the last element to be adjacent.
// Given a binary circular array nums, return the minimum number of swaps required to group all 1's present in the array together at any location.

// Example 1:
// Input: nums = [0,1,0,1,1,0,0]
// Output: 1
// Explanation: Here are a few of the ways to group all the 1's together:
// [0,0,1,1,1,0,0] using 1 swap.
// [0,1,1,1,0,0,0] using 1 swap.
// [1,1,0,0,0,0,1] using 2 swaps (using the circular property of the array).
// There is no way to group all 1's together with 0 swaps.
// Thus, the minimum number of swaps required is 1.

// Example 2:
// Input: nums = [0,1,1,1,0,0,1,1,0]
// Output: 2
// Explanation: Here are a few of the ways to group all the 1's together:
// [1,1,1,0,0,0,0,1,1] using 2 swaps (using the circular property of the array).
// [1,1,1,1,1,0,0,0,0] using 2 swaps.
// There is no way to group all 1's together with 0 or 1 swaps.
// Thus, the minimum number of swaps required is 2.

// Example 3:
// Input: nums = [1,1,0,0,1]
// Output: 0
// Explanation: All the 1's are already grouped together due to the circular property of the array.
// Thus, the minimum number of swaps required is 0.

// Constraints:
// 1 <= nums.length <= 10^5
// nums[i] is either 0 or 1.

public class MinimumSwapsToGroupAll1Together {
    public static void main(String[] args) {
        int[] nums = {0,1,0,1,1,0,0};
        System.out.println(minSwaps(nums));

    }

    // Time Complexity: O(N) + O(K) + O(N)
    // Space Complexity: O(N)
    public static int minSwaps(int[] nums) {

        // variable to hold count of all '1' in the array
        int windowSize = 0;
        int curZeros = 0;

        for (int numb : nums) {
            if(numb % 2 != 0) windowSize++;
        }

        // find zeros in first window
        for (int i = 0; i <windowSize; i++) {
            if(nums[i] == 0){
                curZeros++;
            }
        }

        // solve for remaining window
        int minZeros = curZeros;
        int start = 0;
        int end = windowSize - 1;
        int n = nums.length;

        while(start <= n) {
            // if removed element was 0, decrement '0' counter
            // If the number leaving the window is 0, then:
            // We remove it from our zero count, because that 0 is no longer inside the window.
            if(nums[start] == 0){
                curZeros--;
            }
            start++;
            // if included element is 0, increment '0' counter
            end++;
            // We check the new number entering the window
            // If it is 0, we increase the zero count.
            // After the last number, it goes back to the first number.
            if(nums[end % n]==0) {
                curZeros++;
            }
            minZeros = Math.min(minZeros, curZeros);
        }

        return minZeros;
    }
}
