package dsa.dynamicprogramming.fibonacci;

import java.util.Arrays;

// int n= 35  // Output: 102334155
// int n= 45  // Output: 1134903170
// int n= 46  // Output: 1836311903
// int n= 47  // Output: -1323752223

// Time Complexity: O(N)

// Top - Down Approach
public class Fibonacci_With_Memoization {
    public static void main(String[] args) {
        int n = 47;
        System.out.println(fib(n));
    }

    public static int fib(int n) {
        int[] dp = new int[n+1];
        // Filling the arrays with default value of -1
        Arrays.fill(dp, -1);

        return recur(n, dp);
    }

    public static int recur(int n, int[] dp) {
        // Base case:
        if(n <= 1) {
            dp[n] = n;
            return dp[n];
        }

//        if(dp[n] != -1) {
//            return dp[n];
//        }

        dp[n] = fib(n-1) + fib(n-2);
        return dp[n];
    }
}
