package dsa.dynamicprogramming.fibonacci;

// Time complexity:  O(N)
// Space complexity:  O(N)

// Fibonacci series using Dynamic Programming
public class Fibonacci {
    public static void main(String[] args) {
        int n = 1;
        System.out.println(fib(n));
       // System.out.println(fib1(n));
    }

    // Time Complexity: 2*N
    public static long fib1(long n) {

        // Base case:
        if(n <= 1) {
            return n;
        }

        return fib1(n-1) + fib1(n-2);
    }

    public static int fib(int n) {
        /* Declare an array to store Fibonacci numbers. */
        int f[] = new int[n + 2]; // 1 extra to handle case, n = 0
        System.out.println("length of array :: " +f.length);
        int i;

        /* 0th and 1st number of the series are 0 and 1*/
        f[0] = 0;
        f[1] = 1;

        for (i = 2; i <= n; i++) {
            /* Add the previous 2 numbers in the series
              and store it */
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }
}
