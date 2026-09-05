package interview_ques.servicebased.hcl;

// given an arr[] , find the subarray that has the maximum sum and return its sum
// arr[] = { 2, 3, -8, 7, -1,2,3}
// o/p = 11

public class PrintMaximumSubarray {
    public static void main(String[] args) {
        int[] arr = { 2, 3, -8, 7, -1, 2, 3};
        System.out.println(findMaxSubarray(arr));
        System.out.println(findMaxSubarray2(arr));
    }

    private static int findMaxSubarray(int[] arr) {
        int max = arr[0];
        int result = 0;

        for (int i = 1; i < arr.length; i++) {
               max =  Math.max(arr[i]+max, arr[i]);
               result =  Math.max(max, result);
        }
        return result;
    }

    // Kadane's Algorithm
    private static int findMaxSubarray2(int[] arr) {
        int max = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i = 1; i < arr.length; i++) {
            currSum += arr[i];
            max =  Math.max(currSum, max);

            // Edge case : If anytime sum becomes less than '-1', then reset it to '0'
            if(currSum < 0) {
                currSum = 0;
            }
        }
        return max;
    }

}
