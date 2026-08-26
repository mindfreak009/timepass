package dsa.sorting.bubblesort;

// Time Complexity : O(n^2) in both worst and average cases.
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {11, 30, 7, 2, 27};
        bubbleSort(arr);
    }

    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        int passes = n-2;
        for (int i = 0; i <=passes; i++) {
            boolean isSwap = false;     // optimised approach
            for (int j = 0; j <=passes-i; j++) {
                if(arr[j] > arr[j+1]) {
                    swapElement(arr, j, j+1);
                    isSwap = true;
                }
            }
            if(!isSwap){                  // optimised approach
                System.out.println("No swaps");
                break;
            }
            printTheArray(arr, "Array after pass: " +i);
        }
    }

    private static void printTheArray(int[] arr, String message) {
        System.out.println("Printing " + message);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if(i!= arr.length-1) {
                System.out.print(",");
            }
        }
        System.out.println();
    }

    public static void swapElement(int arr[], int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}

