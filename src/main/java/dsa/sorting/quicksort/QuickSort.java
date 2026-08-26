package dsa.sorting.quicksort;

// Important:
// Worst case: O(N*N) = O(N^2)
// Average: O(N logN)
// Worst case occurs when pivot is always the smallest or largest element

// when to use it ?
// When the memory is to kept low and we have average cases

public class QuickSort {

    private static int partitionArr(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low-1; // here, we assuming that there is no smaller element than low;

        for (int j = low; j < high; j++) {
            if(arr[j] < pivot) {
                i++;

                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap with pivot
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        return i;    // pivot index
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low < high){
            int pidx = partitionArr(arr, low, high);

            quickSort(arr, low, pidx-1);
            quickSort(arr, pidx+1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr  = {6,3,9,5,2,8};
        int n = arr.length;
        quickSort(arr, 0, n-1);

        // print
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
