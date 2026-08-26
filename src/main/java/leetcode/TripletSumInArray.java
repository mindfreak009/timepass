package leetcode;

// n=6, X=13
// N = total number of elements
// X = addition of the triplet sum
// int[] arr = {1,4,45,6,10,8};

// Time Complexity:
// O(NLogN)  -- sorting
// O(N^2) - because for loop & while loop inside
// So Total time complexity ===>  O(NLogN) + O(N^2)

import java.util.Arrays;

public class TripletSumInArray {
    public static void main(String[] args) {

        int[] arr = {1, 4, 45, 6, 10, 8};
        Arrays.sort(arr);
        int sumTarget = 52;
        System.out.println(findTripletSumArray(arr, sumTarget));
        System.out.println(findTripletSumArrayBruteForce(arr, sumTarget));
    }

    // Brute force approach
    // Time complexity: O(N^3)
    private static boolean findTripletSumArrayBruteForce(int[] arr, int sumTarget) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    System.out.println("arr[k]" +arr[k]);
                    int sum = arr[i] + arr[j] + arr[k];
                    if(sum == sumTarget) {
                        System.out.println("Triplet is ==> ("+arr[i]+" "+arr[j]+" "+arr[k]
                                + ") at index:: " +i+ " "+j+ " "+k);
                        return true;
                    }
                }
            }
        }
        return false;
    }


    // Time complexity: O(NlogN) + O(N^2)
    private static boolean findTripletSumArray(int[] arr, int sumTarget) {
        for (int i = 0; i < arr.length-1; i++) {
            int start = i+1;
            int end = arr.length-1;

            while(start < end) {
                int sum = arr[i] + arr[start] + arr[end];
                if(sum == sumTarget) {
                    System.out.println("Triplets are :: " +arr[i] + " "+arr[start]+ " "+arr[end]+
                            " positions :" +i+ " " +start+ " " +end);
                    return true;
                } else if(sum > sumTarget) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return  false;
    }
}
