package dsa.arrays;
import java.util.Arrays;

// Given an integer array nums, move all 0's to the end of it while maintaining
// the relative order of the non-zero elements.
// Note that you must do this in-place without making a copy of the array.

// Example 1:
// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]

// Example 2:
// Input: nums = [0]
// Output: [0]

// Constraints:
// 1 <= nums.length <= 10^4
// -2^31 <= nums[i] <= 2^31 - 1

// Similar question - strings->Sort colours


public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        int[] result  = moveZeroesAtEnd(nums);
        System.out.println(Arrays.toString(result));
    }

    private static int[] moveZeroesAtEnd(int[] nums) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[counter++] = nums[i];
                // System.out.println("nums  :: " + Arrays.toString(nums));
                // System.out.println("counter  :: " + counter);

            }
        }
        // System.out.println("nums here :: " + Arrays.toString(nums));

        while(counter < nums.length) {
            nums[counter++] = 0;
        }

        return nums;
    }
}
