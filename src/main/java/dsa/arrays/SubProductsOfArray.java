package dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// Output = (3,6) (6,2) (2,8) (8,7) (7,1)
public class SubProductsOfArray {
    public static void main(String[] args) {

        // Approach 1: Using ArrayList
        List<Integer> list = Arrays.asList(3, 6, 2, 8, 7, 1);
        List<List<Integer>> subLists = new ArrayList<>();

        for (int i = 0; i < list.size()-1; i++) {
            int firstElement = list.get(i);
            int secondElement = list.get(i+1);

            List<Integer> list2 = new ArrayList<>();
            list2.add(firstElement);
            list2.add(secondElement);

            subLists.add(list2);
        }

        System.out.println(subLists);

        // Approach 2 : Using Array
        int[] originalArray = {3, 6, 2, 8, 7, 1};

        // Check if the original array has at least two elements
        if (originalArray.length < 2) {
            System.out.println("Original array should have at least two elements.");
            return;
        }

        // Create sub-arrays and print them
        for (int i = 0; i < originalArray.length - 1; i++) {
            int firstElement = originalArray[i];
            int secondElement = originalArray[i + 1];

            int[] subArray = {firstElement, secondElement};

            // Print the sub-array
            System.out.print("(");
            for (int j = 0; j < subArray.length; j++) {
                System.out.print(subArray[j]);
                if (j < subArray.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print(") ");
        }

    }
}



