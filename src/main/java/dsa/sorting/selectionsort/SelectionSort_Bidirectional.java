package dsa.sorting.selectionsort;

import java.util.Arrays;

public class SelectionSort_Bidirectional {
    public static void main(String[] args) {
        int[] arr = {7, 2, 6, 9, 8, 3, 1};
        System.out.println(Arrays.toString(biDirectionalSelectionSort(arr)));
    }

    private static int[] biDirectionalSelectionSort(int[] arr) {

        int n = arr.length;
        int k = n-1;
        // we are not checking the last number, hence we are doing (n-1), because that number would be checked by j.
        for (int i = 0; i < k; i++) {
            // Find the smallest element in the unsorted part of the array
            int minElement = arr[i];
            int minIndex = i;
            // Using the maxElement variable
            int maxElement = arr[i];
            int maxIndex = i;

            for (int j = i+1; j <= k; j++) {
                if(arr[j] < minElement) {
                    minElement = arr[j];
                    minIndex = j;
                } else if (arr[j] > maxElement)  {
                    maxElement = arr[j];
                    maxIndex = j;
                }
            }
            // Swap min element
            swapNumbers(arr, i, minIndex);
            if(maxElement == arr[minIndex]) {
                swapNumbers(arr, k, minIndex);
            } else {
                swapNumbers(arr, k, maxIndex);
            }
            k--;
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
