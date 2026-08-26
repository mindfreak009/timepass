package interview_ques;

import java.util.Arrays;
import java.util.List;

// Time complexity : O(N + M)
// Space complexity: O(N)

//  Input: arr[]  = {10, 3, 5, 6, 2}
//  Output: prod[]  = {180, 600, 360, 300, 900}
public class ProductOfArrayExceptSelf2 {
    public static void main(String[] args) {

        // int arr[]  = {10, 3, 5, 6, 2};
        int arr[]  = {2, 3, 5};
        int total[] = new int[arr.length];

        int product = 1;
        for (int i = 0; i < arr.length; i++) {
            product = product * arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            total[i] = product/arr[i];
        }

        System.out.println(Arrays.toString(total));
        // System.out.println(Arrays.toString(total));

    }
}
