package persistent;

public class MaxSumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};  // output: 6 [4,-1,2,1]
        int[] nums1 = {50, -10, 5, 20};      // output: 65  [50,-10,5,20]
        // System.out.println(maxSumSubarray1(nums));
        System.out.println(maxSumSubarray2(nums));
    }

    private static String maxSumSubarray1(int[] nums) {
        int[] arr = new int[nums.length];
        int currSum = 0;
        int largestSum = 0;

        int start = 0; // indices of the maximum subarray
        int end = 0;  // indices of the maximum subarray
        int tempStart = 0;   // potential start of the new subarray

        for (int i=0; i<nums.length; i++) {
            if(currSum+nums[i] < nums[i]) {
                currSum = nums[i];
                tempStart = i;
            } else {
                currSum+= nums[i];
            }

            if(currSum > largestSum) {
                largestSum = currSum;
                start = tempStart;
                end = i;
            }
//            currSum = Math.max(currSum+nums[i], nums[i]);
//            largestSum = Math.max(largestSum, currSum);
        }
        for (int i= start; i<=end; i++) {
            arr[i] = nums[i];
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        return largestSum + " ===> " + arr;
    }

    private static int maxSumSubarray2(int[] nums) {
        int currMax = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            currMax = Math.max(nums[i], nums[i] + currMax);
            max = Math.max(currMax, max);
        }
        return max;
    }
}
