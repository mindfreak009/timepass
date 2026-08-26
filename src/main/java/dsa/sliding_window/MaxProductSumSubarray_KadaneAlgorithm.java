package dsa.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Asked in Airtel
public class MaxProductSumSubarray_KadaneAlgorithm {
    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 7, -5, 4};
        System.out.println("Maximum Sub array product is "
                + maxSubarrayProduct(arr));

        System.out.println("Maximum Sub array product (Kadane) Algo) "
                + maxSubarrayProductUsingKadaneAlgorithm(arr));

        System.out.println("Max Sub-Array product (3) :: " + maxSubArrayProductWithKadaneAlgorithn(arr));
    }

    // Time complexity : O(N^2)
    private static int maxSubarrayProduct(int arr[]) {
        // Initializing result
        int result = arr[0];
        int n = arr.length;
        List<Integer> indices = new ArrayList<>();
        int[] ints = {};

        for (int i = 0; i < n; i++) {
            int mul = arr[i];
            // traversing in current subarray
            for (int j = i + 1; j < n; j++) {
                // updating result every time to keep an eye
                // over the maximum product
                mul *= arr[j];
                result = Math.max(result, mul);
//                ints = Arrays.copyOfRange(arr, j, result);
            }

            // updating the result for (n-1)th index.
           // result = Math.max(result, mul);
        }
        return result;
    }


    private static int maxSubArrayProductWithKadaneAlgorithn(int[] arr) {
        // We are keeping here 1 because if we keep 0, then we would get output as 0 since any number
        // multiplied by 0 would be always zero... e.g.. 5*0 = 0;
        int currMax = 1;
        int totalMax = 1;

        for(int i: arr) {
            currMax = Math.max(currMax*i, i);
            totalMax = Math.max(currMax, totalMax);
        }
        return totalMax;
    }

    private static int maxSubarrayProductUsingKadaneAlgorithm(int arr[]) {

        int sum = 1;
        int maxNum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            sum = sum * arr[i];
            maxNum = Math.max(maxNum, sum);

            // this condition is when we are multiplying the SUM OF PRODUCT
            if(sum == 0) {
                sum = 1;
            }
            // this condition is to be applied when we are adding the SUM
//            if (sum < 0) {
//                sum = 0;
//            }

        }
        return maxNum;
    }

}

