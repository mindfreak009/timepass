package leetcode;

// Difficulty: Medium

// Given two positive integers left and right, find the two integers num1 and num2 such that:
//      left <= num1 < num2 <= right .

// Both num1 and num2 are prime numbers.
// num2 - num1 is the minimum amongst all other pairs satisfying the above conditions.
// Return the positive integer array ans = [num1, num2]. If there are multiple pairs satisfying these conditions, return the
// one with the smallest num1 value. If no such numbers exist, return [-1, -1].

// Example 1:
// Input: left = 10, right = 19
// Output: [11,13]
// Explanation: The prime numbers between 10 and 19 are 11, 13, 17, and 19.
// The closest gap between any pair is 2, which can be achieved by [11,13] or [17,19].
// Since 11 is smaller than 17, we return the first pair.

// Example 2:
// Input: left = 4, right = 6
// Output: [-1,-1]
// Explanation: There exists only one prime number in the given range, so the conditions cannot be satisfied.

// Constraints:
//    1 <= left <= right <= 106

import java.util.Arrays;

public class ClosestPrimeNumbersInRange_2523 {
    public static void main(String[] args) {
        int left = 10, right = 19;
        System.out.println(Arrays.toString(closestPrimes(left, right)));
    }

    public static int[] closestPrimes(int left, int right) {
        /*  Sieve algorithm to find prime numbers between [1, right]  */
        boolean[] prime = new boolean[right + 1];
        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;

        // Sieve Algorithm --> O(R log(log R))
        for (int i = 2; i*i <= right ; i++) {
            if(prime[i]) {
                for (int j = i*i; j <= right ; j+= i) {
                    prime[i] = false;
                }
            }
        }

        /* find min diff b/w pair of prime numbers */
        // Time Complexity: (R-L)
        int res[] = new int[] {-1, -1};
        int minDiff = Integer.MAX_VALUE;
        int prev = -1;
        for (int i = left; i <= right ; i++) {
            if(prime[i]) {
                if(prev == -1) {
                    prev = i;
                } else {
                    if(i - prev < minDiff) {
                        res[0] = prev;
                        res[1] = i;
                        minDiff = i-prev;
                    }
                    prev = i;
                }
            }
        }

        return res;
    }
}
