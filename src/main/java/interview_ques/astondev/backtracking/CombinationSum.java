package interview_ques.astondev.backtracking;

import java.util.ArrayList;
import java.util.List;

// Given the below
// Input:  int[] arr = {3, 2, 6, 4, 9, 1, 8};
// Target: 9
// Output: ((3,2,4), (6,2,1), (9), (8,1), (6,3))

public class CombinationSum {

    public static void main(String[] args) {
        // Target = 9
        int[] arr = {3, 2, 6, 4, 9, 1, 8};
        int currIdx = 0;
        int target = 9;

        List<List<Integer>> result = new ArrayList<>();
        findSubsets(arr, target, 0, new ArrayList<>(), result);

        // Print result
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }

    private static void findSubsets(int[] arr, int target, int index,
                                    List<Integer> current,
                                    List<List<Integer>> result) {

        // If target becomes 0 → valid subset
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // If out of bounds or target becomes negative → stop
        if (index >= arr.length || target < 0) {
            return;
        }

        // Include current element
        current.add(arr[index]);
        // Pick current element
        findSubsets(arr, target - arr[index], index + 1, current, result);

        // Backtrack (remove element)
        current.removeLast();

        // Exclude current element
        findSubsets(arr, target, index + 1, current, result);
    }
}
