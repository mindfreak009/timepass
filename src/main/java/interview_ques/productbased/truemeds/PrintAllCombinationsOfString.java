package interview_ques.productbased.truemeds;

import java.util.ArrayList;
import java.util.List;

// Time Complexity: O(N * N!)
public class PrintAllCombinationsOfString {
    public static void main(String[] args) {
        // String str = "GOD";
        String str = "MOUSE";
        List<String> permutations = new ArrayList<>();
        generatePermutations(str, 0, str.length() - 1, permutations);

        // Print all permutations
        for (String perm : permutations) {
            System.out.println(perm);
        }
    }

    private static void generatePermutations(String str, int start, int end, List<String> permutations) {
        // If we have reached the end of the string, add the permutation to the list
        if (start == end) {
            permutations.add(str);
        } else {
            for (int i = start; i <= end; i++) {
                // Swap characters at indices start and i
                str = swap(str, start, i);

                // Recur to generate permutations with the swapped string
                generatePermutations(str, start + 1, end, permutations);

                // Backtrack by swapping the characters back
                str = swap(str, start, i);
            }
        }
    }

    private static String swap(String str, int i, int j) {
        char[] arr = str.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }
}

