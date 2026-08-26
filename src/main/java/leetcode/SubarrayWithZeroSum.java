package leetcode;

import io.swagger.models.auth.In;

import java.util.*;

// int[] arr = {4, 2, 3, -1, 6}
// Output : FALSE


public class SubarrayWithZeroSum {
    public static void main(String[] args) {
        int[] arr = {4, 2, 3, -1, 6};

       boolean result =  subArrayWithZeroSum(arr);
       System.out.println(result);
      // System.out.println(findSubArrayWithZeroSum(arr));
      //  System.out.println(res);
    }

    private static boolean subArrayWithZeroSum(int[] arr) {
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum+= arr[i];
            if(arr[i] == 0) {
                return true;
            } else if(sum == 0) {
                return true;
            } else if (map.containsKey(sum)) {
                return true;
            } else {
                map.put(sum, 1);
            }
        }
        System.out.println("Map values :: " + map);
        return false;
    }


    private static boolean findSubArrayWithZeroSum(int[] arr) {

        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+= arr[i];
            set.add(sum);
            if(set.contains(sum)) {
                return true;
            }
        }
        return  false;
    }



}
