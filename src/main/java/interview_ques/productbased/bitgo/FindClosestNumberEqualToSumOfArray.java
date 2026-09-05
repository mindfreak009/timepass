package interview_ques.productbased.bitgo;

// Given an array, find the smallest number that can be added so that it is closest to
// the given Fibonacci number

// int[] arr = {5, 2, 1};
// Output: 0;
// Explanation : adding arr becomes 5+2+1=8, which is itself Fibonacci number
// and hence we don't require to add any numbers. So output=0


import java.util.Arrays;

public class FindClosestNumberEqualToSumOfArray {
    public static void main(String[] args) {
// Test cases
        int[] b = {15, 1, 3};
        System.out.println(approachingFibonacci(b));  // Expected output: 2

        int[] c = {5, 2, 1};
        System.out.println(approachingFibonacci(c));  // Expected output: 0

        int[] d = {1, 20, 2, 5};
        System.out.println(approachingFibonacci(d));  // Expected output: 6

        int[] e = {6, 6, 4};
        System.out.println(approachingFibonacci(e));  // Expected output: 5

    }

    public static int approachingFibonacci(int[] arr) {
        // Calculate the sum of the array
        int arrSum = Arrays.stream(arr).sum();
        System.out.println("arrSum :: " +arrSum);

        int n1 = 0;
        int n2 = 1;

        // Fibonacci-like calculation
        while (true) {
            int n3 = n1 + n2;
            n1 = n2;
            n2 = n3;

            // Check if n3 is greater than or equal to the arrSum
            if (n3 >= arrSum) {
                return n3 - arrSum;
            }
        }
    }

}


