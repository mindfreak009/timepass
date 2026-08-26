package dsa.dynamicprogramming.fibonacci;

// Tabulation approach:
// a.k.a..., Bottom-up approach

public class Fibonacci_With_Tabulation {
    public static void main(String[] args) {
        int n = 45;
        System.out.println(fib(n));
    }

// Time Complexity: O(N)
// Space Complexity: O(N)
    public static int fib(int n) {
        // Base case
        if(n <=1) {
            return n;
        }

        int[] dp = new int[n+1];
        //base case
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = fib(n-1) + fib(n-2);
        }
        return dp[n];
    }

    // Improved CASE
    // Time Complexity: O(N)
    public static int fib2(int n) {
        // Base case
        if(n <=1) {
            return n;
        }

        //base case
        int prev1 = 1;
        int prev2 = 0;
        int ans = 0;

        for (int i = 2; i <= n; i++) {
            // ans  = p1     + p2

            // f(2) = f(1)   + f(0)
            // f(3) = f(2)   + f(1)
            //        p1=ans   p2=p1
            ans = prev1 + prev2;
            prev2 = prev1;
            prev1 =  ans;
        }
        return ans;
    }
}
