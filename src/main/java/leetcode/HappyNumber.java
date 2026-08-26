package leetcode;

// Difficulty: Easy

// Write an algorithm to determine if a number n is happy.
// A happy number is a number defined by the following process:

// Starting with any positive integer, replace the number by the sum of the squares of its digits.
//   • Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
//   • Those numbers for which this process ends in 1 are happy.
//   • Return true if n is a happy number, and false if not.

// Example 1:
// Input: n = 19
// Output: true

// Explanation:
// 1^2 + 9^2 = 82
// 8^2 + 2^2 = 68
// 6^2 + 8^2 = 100
// 1^2 + 0^2 + 0^2 = 1

// Example 2:
// Input: n = 2
// Output: false

// Constraints:
// 1 <= n <= 2^31 - 1

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        // int n = 2;
        // int n = 61;
        int n = 19;
        System.out.println("isHappy: " + isHappy(n));
        System.out.println("isHappy1: " + isHappy1(n));
        System.out.println("isHappy2: " + isHappy2(n));
    }

    public static int sumOfSquareOfDigits(int n) {
        int sum = 0;
        while (n != 0){
            int digit = n % 10;
            n = n/10;
            sum+= (digit*digit);
        }
        return sum;
    }

    // Time Complexity: O(log N)
    // Space Complexity: O(N)
    public static boolean isHappy1(int n) {
        Set<Integer> set = new HashSet<>();

        // adding all the previous calculated sumOfSquareOfDigits numbers into set.
        while (n != 1) {
            if(set.contains(n)) {
                return false;
            }
            set.add(n);
            //System.out.println("set ::" +set);
            n = sumOfSquareOfDigits(n);
        }
        return true;
    }

    public static boolean isHappy2(int n) {

        // Floyd Cycle detection algorithms
        int slow = n , fast = n;
        while (true) {
            slow = sumOfSquareOfDigits(slow);
            // This means the fast player uses the machine two times.
            // Example:
            // Start with 19
            // 1st time: 19 → 82
            // 2nd time: 82 → 8^2 + 2^2 = 64 + 4 = 68
            // So fast goes:
            // 19 → 82 → 68
            //So fast takes 2 steps:
            fast = sumOfSquareOfDigits(sumOfSquareOfDigits(fast));

            if(fast == 1){
                return true;
            }
            if(slow == fast) {
                return false;
            }
        }
    }


    public static boolean isHappy(int n) {
        Set<Integer> usedNumbers = new HashSet<>();

        int sum = 0;
        while(true) {
            // Find the sum of squares
            while(n != 0) {
                sum += Math.pow(n%10, 2.0);
                n = n/10;
            }
            // If sum is 1, return true
            if(sum == 1) return true;

            // Else the new number is the current sum
            n = sum;

            // Check if we have already encountered that number
            if(usedNumbers.contains(n)) {
                return false;
            }
            return usedNumbers.add(n);
        }
    }
}
