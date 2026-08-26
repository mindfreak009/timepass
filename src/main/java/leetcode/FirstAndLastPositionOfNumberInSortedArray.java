package leetcode;

// You must write alogirthm in O(logN) complexity

import java.util.Arrays;

public class FirstAndLastPositionOfNumberInSortedArray {
    public static void main(String[] args) {

        int[] nums = {5, 7, 7, 8, 8, 10};   // target=8  Output=[3,4]
        int[] nums1 = {5, 7, 7, 8, 8, 10};  // target=6   Output=[-1 -1]

        int target = 7;
        System.out.println(Arrays.toString(findFirstAndLastPosition(nums1, target)));

    }

    private static int[] findFirstAndLastPosition(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        int firstIndex = -1;
        int lastIndex = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                firstIndex = mid;
                end = mid - 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            }
        }

        start = 0;
        end = arr.length-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                lastIndex = mid;
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            }
        }
        return new int[]{firstIndex, lastIndex};
    }
}
