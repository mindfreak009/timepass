package dsa.binarysearch;

// Input: arr = [0,2,1,0]
// Output: 1

// Input: arr = [0,10,5,2]
// Output: 1

// Input: arr = [0,1,0]
// Output: 1

public class Mountain {
    public static void main(String[] args) {

        int arr[] = {0,2,1,0};
        System.out.println(peakIndexInMountainArray(arr));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            // find the middle element
            // int mid = (start + end)/2;   // this might possible (start + end) that it might exceed int range
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1]) {
                // you are in the desc part of the array
                // this may be the ans but look at the left.
                // this is why end != mid-1
                end = mid;

            } else {
                // you are in asc part of array
                // because we know that mid + 1 element > mid element
                start = mid + 1;
            }
        }
        // in the end, start == end and pointing to the largest number because of the 2 checks
        // start and end are always trying to find max element in the above 2 checks.
        // hence when they are pointing to just one element, that is the max one because that's what check says.
        // At every point of time, for start and end, they have the best possible answer till the

        // you can return start or end, because at this time both start and end would have the same value.
        return start;
    }
}
