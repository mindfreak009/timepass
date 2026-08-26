package dsa.sorting.selectionsort;

import java.util.Arrays;

// Time Complexity : O(N^2)
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {7, 2, 6, 9, 8, 3, 1};
        System.out.println(Arrays.toString(selectionSort(arr)));
    }

    private static int[] selectionSort(int[] arr) {

        int n = arr.length;
        // we are not checking the last number, hence we are doing (n-1), because that number would be checked by j.
        for (int i = 0; i < n-1; i++) {
            // Find the smallest element in the unsorted part of the array
            int minElement = arr[i];
            int minIndex = i;

            for (int j = i+1; j < n; j++) {
                if(arr[j] < minElement) {
                    minElement = arr[j];
                    minIndex = j;
                }
            }
            // We swap (i) with minIndex because everytime (i) becomes part of unsorted array
            swapNumbers(arr, i, minIndex);
        }

        return arr;

    }

    public static void swapNumbers(int[] arr, int i, int minIndex) {
        // Move minimum element to its correct position
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;

    }
}
