package dsa.binarysearch;

public class FindPivotElement {
    public static void main(String[] args) {
        int[] arr = {3, 8, 10, 17, 1, 9, 44, 66};
        System.out.println("Index of pivot element is ::: " + findPivotElement(arr, arr.length));
    }

    private static int findPivotElement(int[] arr, int length) {
        int start = 0;
        int end = arr.length - 1;
        int mid = start + (end-start)/2;

        while(start < end) {
//            if(arr[mid] >= arr[0]) {
//                start = mid + 1;
//            }
            if(arr[mid] < arr[mid+1]) {
              start = mid + 1;
            } else {
                end = mid;
            }
            mid = start + (end-start)/2;
        }

        return start;   // here, you can return end as well.. since at this time, both start and end would have the same value;

    }
}
