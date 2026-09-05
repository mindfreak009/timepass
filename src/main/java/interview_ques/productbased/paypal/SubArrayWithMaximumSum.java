package interview_ques.productbased.paypal;

// nums = [-2, 1, -3, 4,-1, 2, 1,-5, 4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.

import java.util.ArrayList;
import java.util.List;

// Approach using Kadane's Algorithm
// Time complexity : O(n)
public class SubArrayWithMaximumSum {
    public static void main(String[] args) {
       int[] arr = {-2, 1, -3, 4,-1, 2, 1,-5, 4};
       // int[] arr = {-2,-3,-1};
        System.out.println("maximum sum1 :: " + kadaneAlgorithm(arr));
        System.out.println("maximum sum2 :: " + subArrayWithMaxSum(arr));

        System.out.println(" ====> " +subArrayWithMaxSum2(arr));
    }

    public static int kadaneAlgorithm(int[] arr) {
        int maxSoFar = arr[0];
        int currMax = arr[0];

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            currMax = Math.max(arr[i],  arr[i] + currMax);
            //list.add(currMax);
            maxSoFar = Math.max(currMax, maxSoFar);
        }
        return maxSoFar;
    }
    public static int subArrayWithMaxSum(int[] arr) {
        int sum = 0;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum > max) {
                max = sum;
            }
            if(sum < 0)
                sum = 0;
        }
        System.out.println("max here ::: " +max);
       return  max;
    }

    public static int subArrayWithMaxSum2(int[] arr) {
        int sum = arr[0];
        int maxSoFar = arr[0];

        // Variables to track the indices of the current subarray
        int start = 0;
        int end = 0;
        int tempStart = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > sum + arr[i]) {
                sum = arr[i];
                tempStart = i; // Start a new subarray
            } else {
                sum += arr[i];
            }

            if (sum > maxSoFar) {
                maxSoFar = sum;
                start = tempStart; // Update start index of the maximum subarray
                end = i; // Update end index of the maximum subarray
            }
        }

        System.out.println("start ::" +start);
        System.out.println("end ::" + end);
        System.out.print("Subarray elements: ");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        return maxSoFar;
    }

}
