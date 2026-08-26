package dsa.sorting.mergesort;

import java.util.Arrays;

// Overall Time Complexity: O(N log N)
public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {5, 51, 34, 82, 2, 7};
        int n = arr.length;

        divide(arr, 0, n-1);

        System.out.println("=================================================");
        System.out.print("Final sorted array::  ");
        // print
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("=================================================");

    }

    // Time Complexity: O(log N)
    public static void divide(int[] arr, int startIndex, int endIndex) {
        // Base case to stop recursion
        if (startIndex >= endIndex) {
            return;
        }

        int mid = startIndex + (endIndex - startIndex)/2;

        // Recursively divide the array into two halves
        divide(arr, startIndex, mid);
        divide(arr, mid+1, endIndex);

        // Merge the divided subarrays
        conquer(arr, startIndex, mid, endIndex);
    }

    // Time complexity : O(N)
    private static void conquer(int[] arr, int startIndex, int mid, int endIndex) {
        int[] merged = new int[endIndex - startIndex + 1];

        int index1 = startIndex;
        int index2 = mid+1;
        int x = 0;

        // Merge the two halves
        while(index1 <= mid && index2 <= endIndex) {
            if(arr[index1] <= arr[index2]) {
                merged[x++] = arr[index1++];
            } else {
                merged[x++] = arr[index2++];
            }
        }

        System.out.println("mergedArray :: " + Arrays.toString(merged));
        // Copy remaining elements from the left half
        while(index1 <= mid) {
            merged[x++] = arr[index1++];
        }

        System.out.println("mergedArray after copying till mid :: " + Arrays.toString(merged));

        // Copy remaining elements from the right half
        while(index2 <= endIndex) {
            merged[x++] = arr[index2++];
        }

        // copying the merged elements in original array
        for (int i = 0, j= startIndex; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }
}
