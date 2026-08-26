package dsa.dynamicprogramming.trappingrainwater;

// Difficulty: Hard

// Given n non-negative integers representing an elevation map where the width of each bar is 1,
// compute how much water it can trap after raining.

// Example 1:
// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
// In this case, 6 units of rain water (blue section) are being trapped.

// Example 2:
// Input: height = [4,2,0,3,2,5]
// Output: 9

// Constraints:
//      n == height.length
//      1 <= n <= 2 * 104
//      0 <= height[i] <= 105


public class TrappingRainWater_42 {
    public static void main(String[] args) {
        // int[] height =  {0,1,0,2,1,0,1,3,2,1,2,1};  // output: 6
       // int[] height =  {3,1,2,4,0,1,3,2};   // output: 8
        int[] height =  {1,8,6,2,5,4,8,3,7};   // output: 19
        System.out.println(trap(height));
        System.out.println(trap_bruteForceApproach(height));
    }

    // Brute-Force-Approach
    public static int trap_bruteForceApproach(int[] height) {
        int n = height.length;

        // Auxillary space to hold values
        int[] left = new int[n];
        int[] right = new int[n];

        // Initializing the first value of left[0] with height[0]... So basically it would hold value=3;
        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] =  Math.max(left[i-1], height[i]);
        }

        right[n-1] = height[n-1];
        for (int i = n-2; i >=0 ; i--) {
            right[i] = Math.max(right[i+1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i <n ; i++) {
            ans  += Math.min(left[i], right[i]) - height[i];
        }

        return ans;
    }

    // Optimised approach
    public static int trap(int[] height) {
        int n = height.length;
        int leftMax = 0;
        int rightMax = 0;
        int l = 0;
        int r = n-1;
        int ans = 0;

        while(l < r) {
            if(height[l] > leftMax) {
                leftMax = Math.max(leftMax, height[l]);
            }
            if(height[r] > rightMax) {
                rightMax = Math.max(rightMax, height[r]);
            }
            if(leftMax < rightMax) {
                ans = ans + leftMax - height[l];
                l++;
            } else {
                ans = ans + rightMax - height[r];
                r--;
            }
        }
        return ans;
    }
}
