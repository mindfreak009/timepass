package dsa.dynamicprogramming;

import java.util.Arrays;

// Difficulty: Easy

// You are climbing a staircase. It takes n steps to reach the top.
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

// Example 1:
// Input: n = 2
// Output: 2
// Explanation: There are two ways to climb to the top.
//    1. 1 step + 1 step
//    2. 2 steps

// Example 2:
// Input: n = 3
// Output: 3
// Explanation: There are three ways to climb to the top.
//     1. 1 step + 1 step + 1 step
//     2. 1 step + 2 steps
//     3. 2 steps + 1 step

// Constraints:
//    1 <= n <= 45


public class ClimbingStairs_70 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {
        // We are taking [n+1] array, because if we are counting it for n states, then we atleast need [n+1] array
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return recur(n, dp);
    }

    public static int recur(int n, int[] dp) {
        // Base case:
        // because constraint is: 1 <= n <= 45
        if(n <= 2) {
            return n;
        }

        // Base case:
        int prev2 = 1;
        int prev1 = 2;
        int ans = 0;

        for(int i=3; i<= n; i++) {
            ans = prev1 +  prev2;
            prev2 = prev1;
            prev1 = ans;
        }
        return ans;
    }



    // The below code is throwing Time Limit Exceeded"
    // public int climbStairs(int n) {
    //     // We are taking [n+1] array, because if we are counting it for n states, then we atleast need [n+1] array
    //     int[] dp = new int[n+1];
    //     Arrays.fill(dp, -1);
    //     return recur(n, dp);
    // }

    // public int recur(int n, int[] dp) {
    //     // Base case
    //     // because constraint is: 1 <= n <= 45
    //     if(n <= 2) {
    //         dp[n] = n;
    //         return dp[n];
    //     }

    //     // This condition is to check if we have already solved the dp.
    //     if(dp[n] != -1) {
    //         return dp[n];
    //     }
    //     dp[n] = climbStairs(n-1) + climbStairs(n-2);
    //     return dp[n];
    // }
}
