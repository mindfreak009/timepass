package interview_ques.paypal;

import java.util.*;

// Several pairs have the minimum difference of : 1
// [(1,2), (2,3), (3,4)]
// So the OUTPUT should look like : [1, 2, 2, 3, 3, 4]

// Time Complexity : O(N log N)
public class ClosestNumbers {

    public static void main(String[] args) {

        int[] arr = {3, 2, 1, 4};
        int[] ints = closestNumbers(arr);
        System.out.println(Arrays.toString(ints));

    }

    private static int[] closestNumbers(int[] arr) {
         Arrays.sort(arr);

        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            int currentDiff = arr[i + 1] - arr[i];
            if (minDiff >= currentDiff) {
                if (hashMap.containsKey(currentDiff)) {
                    hashMap.get(currentDiff).add(arr[i]);
                    hashMap.get(currentDiff).add(arr[i + 1]);
                    System.out.println("map here :::" +hashMap);
                } else {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(arr[i]);
                    tempList.add(arr[i + 1]);
                    hashMap.put(currentDiff, tempList);
                }
                minDiff = currentDiff;
            }
        }

        List<Integer> minDiffElements = hashMap.get(minDiff);
        int[] result = new int[minDiffElements.size()];
        // System.out.println("result.length :: " + result.length);
        for (int i = 0; i < result.length; i++) {
            result[i] = minDiffElements.get(i);
        }

        return result;
    }

}
