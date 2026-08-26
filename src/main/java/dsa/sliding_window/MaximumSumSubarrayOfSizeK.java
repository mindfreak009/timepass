package dsa.sliding_window;


// Explanation:  We get maximum sum by adding subarray [300,400] of size 2
public class MaximumSumSubarrayOfSizeK {
    public static void main(String[] args) {
//         int[] arr = {-2, -5, 6, 4, 3, 8, -1, 0, 9};
//         int k = 4;

        int[] arr = {100, 200, 300, 400};
        int k = 2;
        System.out.println(findMaxSumSubArray(arr, k));
    }

    private static int findMaxSumSubArray(int[] arr, int k) {
        int n = arr.length;
        int maxSum = 0;
        int windowSum = 0;

        // for first window
        for (int i = 0; i < k; i++) {
            windowSum+= arr[i];
        }

        maxSum = windowSum;
        System.out.println("maxSum ::" +maxSum);

        // for other windows
        for (int i = 1; i < n-k+1; i++) {
            // Remove the number that left the window
            // Add the new number that entered the window
            windowSum = windowSum - arr[i - 1] + arr[i + k - 1];
            maxSum = Math.max(maxSum, windowSum);
        }
    return maxSum;
    }
}
