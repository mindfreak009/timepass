package interview_ques.productbased.zyx;

import java.util.Arrays;

// Possible Output: [2, 3, 7, 5, 8, 12, 10]

// values < 8     |    values >= 8
//   2 3 5 7      |      8 10 12

public class SplitValuesAroundThreshold {
    public static void main(String[] args) {
        int[] nums = {10, 3, 7, 12, 5, 8, 2};
        int threshold = 8;
        System.out.println("Array: " + Arrays.toString(partition(nums, threshold)));
    }

    public static int[] partition(int[] nums, int threshold) {
        // edge case
        if(nums == null || nums.length == 0) {
            return new int[]{0};
        }

        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            // Find a value on the left that belongs on the right
            while (left < right && nums[left] < threshold) {
                left++;
            }

            // Find a value on the right that belongs on the left
            while (left < right && nums[right] >= threshold) {
                right--;
            }

            if(left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        // System.out.println(Arrays.toString(nums));
        return nums;
    }
}
