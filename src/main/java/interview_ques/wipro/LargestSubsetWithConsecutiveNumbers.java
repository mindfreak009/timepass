package interview_ques.wipro;

// [50,45,32,88,3,56,4,1,88,2,68,5,89,23,90]

import java.util.*;

public class LargestSubsetWithConsecutiveNumbers {
    public static void main(String[] args) {
        int[] nums = {50,45,32,88,3,56,4,1,88,2,68,5,89,23,90, 6, 91, 92, 93, 94, 95, 100};
       // int[] nums = {1,4};
        System.out.println(findSubset(nums));
    }

    // Time Complexity: O(N*logN)
    private static int findSubset(int[] nums) {

        // Edge case:
        // if the array is empty, return 0
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        int j = 0;
        int counter = 1;
        int finalCount = 1;

        Map<List<Integer>, Integer> map = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
            if(j<i && (nums[i] - nums[j] == 1)) {
                map.put(List.of(nums[i]), counter++);
                j++;
            } else {
                finalCount =  Math.max(finalCount, counter);
                counter = 1;
                j++;
            }
        }
        System.out.println("finalCounter: " +finalCount);
        System.out.println("counter: " +counter);

        // Final check after the loop ends, in case the longest subsequence ends at the last element
        finalCount = Math.max(finalCount, counter);

        for (Map.Entry<List<Integer>, Integer> inMap : map.entrySet()) {
            System.out.println(inMap.getKey() + "--" + inMap.getValue());
        };

        return finalCount;
    }
}
