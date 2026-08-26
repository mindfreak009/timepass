package dsa.arrays;

import java.util.HashMap;

// You are given two integers arrays of equal length (target and arr).
// In one step, you can select any non-empty subarray of arr and reverse it. You are allowed to make any number of steps.
// Return "true" if you can make "arr" equal to "target" or "false" otherwise.

public class MakeTwoArraysEqualByReversingSubArrays {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4};
        int[] target = {4, 2, 1, 3};
       // boolean result = canBeEqual(arr, target);
       // System.out.println(result);

        boolean result2 = canBeEqual2(arr, target);
        System.out.println(result2);
    }

    private static boolean canBeEqual(int[] arr, int[] target) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int element : target) {
            map1.put(element, map1.getOrDefault(element, 0)+1);
        }

        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int element : arr) {
            map2.put(element, map2.getOrDefault(element, 0)+1);
        }

        for (int key: map1.keySet()) {
            if(!map2.containsKey(key)) {
                return false;
            }
            if(map1.get(key) != map2.get(key)) {
                return false;
            }
        }
        return true;
    }

    // Optimized approach - With a single loop
    private static boolean canBeEqual2(int[] arr, int[] target) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int element : target) {
            map1.put(element, map1.getOrDefault(element, 0)+1);
        }

        for (int element: arr) {
            if(!map1.containsKey(element)) {
                return false;
            }
            map1.put(element, map1.get(element)-1);

            if(map1.get(element) == 0) {
                map1.remove(element);
            }
        }
        return map1.isEmpty();
    }
}

