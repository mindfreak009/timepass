package dsa.greedy_algorithm;


import java.util.Arrays;
import java.util.List;

// Given an array of even number of elements, form groups of 2 using these array elements such that the difference
// between the group with the highest sum and the one with the lowest sum is minimum.
// Note:  An element can be a part of one group only and it has to be a part of at least 1 group.
public class MinDiffBetweenGroupsOfSizeTwo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 6, 4, 3);
        int n = list.size();
        System.out.println(calculateMinDiff(list, n));
    }

    private static boolean calculateMinDiff(List<Integer> arr, int n) {
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
        System.out.println("Minimum difff :: " + (max - min));
        return false;
    }
}
