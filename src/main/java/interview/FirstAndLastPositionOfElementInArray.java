package interview;

// (Given an array of integer nums, sorted in non-decreasing order,
//  find the starting and ending position of given target value.
//     If target is not found return {-1,-1}
//     You must write an algorithm with O(log n) runtime complexity.
//     (Input: nums=[5,7,7,8,8,10], target=8  Output: [3,4]
//     (Input: nums=[5,7,7,8,8,10], target=6  Output: [-1,-1]

import java.util.Arrays;

public class FirstAndLastPositionOfElementInArray {
    public static void main(String[] args) {
        int[] nums= {5,7,7,8,8,10};
        int target = 8;

        System.out.println(Arrays.toString(findFirstAndLastElement(nums, target)));
        System.out.println(Arrays.toString(findFirstAndLastElement_Improved(nums, target)));
    }

    // Time Complexity: O(N)
    private static int[] findFirstAndLastElement(int[] nums, int target) {
        int firstElement = -1;
        int lastElement = -1;

        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == target) {
                if(firstElement == -1) {
                    firstElement = i;
                }
                lastElement = i;
            }
        }

        return  new int[] {firstElement, lastElement};
    }

    // Time complexity : O(log N)
    private static int[] findFirstAndLastElement_Improved(int[] nums, int target) {

        int left = findLeftValue(nums, target);
        int right = findRightValue(nums, target);

        // System.out.println(left);
        // System.out.println(right);

        return new int[]{left, right};
    }

    private static int findLeftValue(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int index = -1;

        System.out.println("left ::: ");
        while(low <= high) {
            int mid = low + (high-low)/2;

            if(nums[mid] == target) {
                index = mid;
                high = mid - 1;
            } else if(nums[mid] < target) {
                low = mid +1;
            } else {
                high = mid -1;
            }
        }
        return index;
    }

    private static int findRightValue(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int index = -1;

        while(low <= high) {
            int mid = low + (high-low)/2;

            if (nums[mid] == target){
                index = mid;
                low = mid + 1;
            } else if(nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return index;
    }

}
