package interview;

// n = 4
// int[] arr = {0,3,1,2}
// Output: -1

// n = 5
// int[] arr = {2,3,1,2,3}
// Output: 2,3

import java.util.*;

public class FindDuplicatesWithoutHashmap {
    public static void main(String[] args) {

        // int[] arr = {2,3,1,2,3};
        int[] arr = {5, 9, 15, 9, 5, 77};

        // Approach 1:
        findDuplicatesUsingSet(arr);
        // Approach 2:
        findDuplicatesUsingList(arr);

        // Approach 3:
        // findDuplicates(arr);

        int nums[] = {1,2,3,4,5};
        for (int i = 0; i < nums.length/2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - i -1];
            nums[nums.length - i -1] = temp;
        }
        System.out.println(Arrays.toString(nums));


    }

    public static void findDuplicatesUsingSet(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> duplicates = new ArrayList<>();
        System.out.println("Duplicates using Set");
        for (int num : arr) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }
        System.out.println(duplicates);
    }

    public static void findDuplicatesUsingList(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> duplicates = new ArrayList<>();

        for(int num : arr) {
            if(list.contains(num)) {
                if(!duplicates.contains(num)) {
                    duplicates.add(num);
                }
            } else {
                list.add(num);
            }
        }
        System.out.println("Duplicates: " + duplicates);
    }

    // This approach works only if the array is the range [1.....n]
    public static void findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i])-1;

            // If the value at this index is already negative, it's a duplicate
            if (nums[index] < 0) {
                //duplicates.add(Math.abs(nums[i]));
                System.out.println("Duplicate: " + Math.abs(nums[i]));
            } else {
                // Mark as visited
                nums[index] = -nums[index];
            }
        }
    }
}
