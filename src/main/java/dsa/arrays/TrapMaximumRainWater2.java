package dsa.arrays;

//        Complexity Analysis:
//        Time Complexity: O(N) + O(N) + O(N). There are 3 for loops traversing the array.
//        Space Complexity: O(2N).

public class TrapMaximumRainWater2 {

    // Using Brute Force Approach
    // Driver code
    public static void main(String[] args) {
        // int[] arr = {3, 0, 2, 0, 4};
      //  int[] arr = {4,2,0,3,2,5};  // Output should be 9

         int[] arr =  {1,8,6,2,5,4,8,3,7};   // output should be 49
        int n = arr.length;

        System.out.print(maxWater(arr, n));
    }

    public static int maxWater(int[] arr, int n) {

        // To store the maximum water that can be stored

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(arr[i], left[i - 1]);
        }

        right[n - 1] = arr[n - 1];
        for (int i = n-2; i >= 0; i--) {
            right[i] = Math.max(arr[i], right[i + 1]);
        }

        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            trappedWater += Math.min(left[i], right[i]) - arr[i];
        }

        return trappedWater;
    }

}