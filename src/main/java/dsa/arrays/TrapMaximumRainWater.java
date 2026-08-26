package dsa.arrays;

//        Complexity Analysis:
//        Time Complexity: O(N^2). There are two nested loops traversing the array.
//        Space Complexity: O(1). No extra space is required.

public class TrapMaximumRainWater {

    // Using Brute Force Approach
    // Driver code
    public static void main(String[] args) {
        // int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        // int[] arr =  {3, 0, 2, 0, 4};
        int[] arr =  {1,8,6,2,5,4,8,3,7};  // output should be 49
        int n = arr.length;

        System.out.print(maxWater(arr, n));
    }

    public static int maxWater(int[] arr, int n) {

        // To store the maximum water that can be stored
        int res = 0;

        // For every element of the array except first and last element
        for (int i = 1; i < n - 1; i++) {

            // Find maximum element on its left
            int left = arr[i];
            for (int j = 0; j < i; j++) {
                left = Math.max(left, arr[j]);
            }

            // Find maximum element on its right
            int right = arr[i];
            // {3, 0, 2, 0, 4};
            for (int j = i + 1; j < n; j++) {
                right = Math.max(right, arr[j]);
            }

            res += Math.min(left, right) - arr[i];
        }
        return res;
    }
}
