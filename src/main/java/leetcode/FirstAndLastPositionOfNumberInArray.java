package leetcode;

// You must write alogirthm in O(logN) complexity

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FirstAndLastPositionOfNumberInArray {
    public static void main(String[] args) {

        // nt[] nums = {5, 7, 7, 8, 8, 10};   // target=8  Output=[3,4]
        int[] nums = {7, 7, 7, 7, 8, 8, 10};  // target=6   Output=[-1 -1]

        int target = 7;
        System.out.println(Arrays.toString(findFirstAndLastPosition(nums, target)));

    }

    private static int[] findFirstAndLastPosition(int[] arr, int target) {
        int firstIndex = -1;
        int lastIndex = -1;

        Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> finalResult = new HashMap<>(2);
        for (int i = 0; i < arr.length; i++) {
                if(arr[i] == target) {
                    if(firstIndex == -1) {
                        firstIndex = i;
                        map.put(firstIndex, String.valueOf(arr[i]));
                    }
                    lastIndex = i;
                   map.put(lastIndex, String.valueOf(arr[i]));
                }
            }
        // tp get the first key of map {{ NO VALUE would be returned }}
        System.out.println("here :: " + map.keySet().stream().findFirst().get());

        return new int[]{firstIndex, lastIndex};
    }



}
