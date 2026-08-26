package dsa.binarysearch;

// celing of a number = smallest element in array greater >= target.
// floor of a number = greatest number smaller or equal to (=) target

public class Ceiling {
    public static void main(String[] args) {

        int arr[] = {-18, -15, -3, 0, 2, 15, 22, 64, 99, 122} ;
        System.out.println(findCeilingOfNumber(arr, 14));
    }

    static int findCeilingOfNumber(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        boolean isAscending = arr[start] < arr[end];

        while (start <= end) {
            // find the middle element
            // int mid = (start + end)/2;   // this might possible (start + end) that it might exceed int range
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAscending) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return start;
    }
}
