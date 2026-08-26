package dsa.sliding_window;

// int[] arr = {100,200,300,400};
// int n = 4;
// int k = 2;
// Output: 700

// We get maximum sum by adding subarray [300,400] of size 2

// Time Complexity: K +(N-K) , in which K gets striked out and eventually it becomes as O(N)
// Space Complexity: Constant

public class MaxSumSubarrayOfSizeK {
    public static void main(String[] args) {
        int[] arr = {100,200,300,400,900};
        int n = arr.length;
        int k = 2;
        System.out.println(maxSumSubarrayOfSizeK(arr, n, k));
    }

   public static long maxSumSubarrayOfSizeK(int[] arr, int n, int k) {
       long maxSum = 0;
       long windowSum = 0;

       int index = 0;
       while(index < n && index < k) {  // K
           windowSum+= arr[index];
           index++;
       }
       maxSum = windowSum;

       System.out.println("maxSum ::" +maxSum);

       for (int i = 1; i < n-k+1; i++) {  // N-K
           int prevElement = arr[i-1];
           int nextElement = arr[i+k-1];

           windowSum = windowSum - prevElement + nextElement;
           maxSum = Math.max(maxSum, windowSum);
       }

       return maxSum;
   }
}
