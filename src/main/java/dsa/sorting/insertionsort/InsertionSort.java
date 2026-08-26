package dsa.sorting.insertionsort;

import java.util.Arrays;

// Time Complexity:
// Worst case: O(N*N)  [Reverse Sorted Array: For each element, the inner while loop runs fully ]
// Average case: O(N*N)  [Elements are in random order, About half of the elements are compared and shifted ]
// Best case: O(N)   [Already sorted array: The while condition arr[j] > key is never true. so only one comparison per iteration]

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {3,6,2,1,5};
        System.out.println(Arrays.toString(insertionSort(arr, arr.length)));
    }

    private static int[] insertionSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
             int key = arr[i];
             int j = i-1;
             while(j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
             }
             arr[j+1] = key;
        }
        return arr;
    }
}
