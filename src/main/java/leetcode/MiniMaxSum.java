package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Time complexity - O(N)
// The idea here is max sum = (totalSum - minNum)
// min Sum = (totalSum - maxNum)
public class MiniMaxSum {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        miniMaxSum(list);
    }

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here

        int min = arr.get(0);
        int max = arr.get(0);
        long totalSum = arr.get(0);

        for (int i = 1; i <= arr.size()-1; i++) {
            totalSum += arr.get(i);

            if (arr.get(i) < min) {
                min = arr.get(i);
            } else if (arr.get(i) > max) {
                max = arr.get(i);
            }
        }
        System.out.println("Min and Max total is :::");
        System.out.println("========================================================");
        System.out.println( (totalSum - max) + " " + (totalSum - min));
        System.out.println("========================================================");

    }
}
