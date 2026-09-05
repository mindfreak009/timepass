package interview_ques.servicebased.wissen;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {

        // int[] nums = {100, 3, 200, 1, 4, 400, 2};
        int[] nums = {1,2,3,3,10,11,12,13};
        // int[] nums = {2};
        System.out.println(firstApproach(nums));
        System.out.println(secondApproachUsingHashSet(nums));
    }

    // Time Complexity: O(N * logN)
    private static int firstApproach(int[] arr) {
        if(arr.length == 0) return 0;
        Arrays.sort(arr);

        int maxLen = 1;
        int currLen = 1;

        for (int i = 1; i < arr.length ; i++) {
            if(arr.length == 0) return 0;

//            if(arr[i] == arr[i-1] ) {
//                continue; // skip duplicates
//            }

            // skip duplicates
            if(arr[i] != arr[i-1] && arr[i] - arr[i-1] == 1) {
                currLen++;
            } else {
                maxLen = Math.max(currLen, maxLen);
                currLen = 1;
            }

//            if (arr[i] - arr[i-1] == 1) {
//                currLen++;
//            } else {
//                maxLen = Math.max(currLen, maxLen);
//                currLen = 1;
//            }
        }
        return Math.max(currLen, maxLen);
    }

    private static int secondApproachUsingHashSet(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int num : set) {
            // check if it is start of sequence
            if (!set.contains(num - 1)) {

                int currentNum = num;
                int length = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
