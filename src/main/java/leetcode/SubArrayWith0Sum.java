package leetcode;

// Asked in Adobe
// int[] arr = {4,2,-3, 1, 6}
// TRUE.  There is a subarray with zero sum from index 1 to 3.

// int[] arr = {4, 2, 0, 1, 6}
// TRUE.  The third element is zero. A single element is also a sub-array.

// Time Complexity: O(N)
// Space Complexity: O(N)    because we are using Map to store our results.


import java.util.HashMap;
import java.util.Map;

public class SubArrayWith0Sum {
    public static void main(String[] args) {
        int[] arr = {4,2,-3, 1, 6};
        int num = 0;
        System.out.println(findSum(arr, num));
    }

    private static boolean findSum(int[] arr, int num) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length-1; i++) {
            sum = sum + arr[i];
            if (arr[i] == 0) {
                return true;
            } else if(sum == 0) {
                return true;
            } else if(map.containsKey(sum)) {
                return true;
            } else {
                map.put(sum, 1);
            }
        }
        return false;
    }
}
