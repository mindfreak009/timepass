package dsa.binarysearch;
//  Input: array = [1,2,3,4,5,3,1], target = 3
//  Output: 2
//  Explanation:: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.

// Input: array = [0,1,2,4,2,1], target = 3
// Output: -1
// Explanation: 3 does not exist in the array, so we return -1.


public class FindInMountainArray {
    public static void main(String[] args) {

        int[] arr = {0,1,2,4,2,1};
        int result = findInMountainArray(arr);
        System.out.println("result :: " +result);
    }

    public static int findInMountainArray(int[] arr) {
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
