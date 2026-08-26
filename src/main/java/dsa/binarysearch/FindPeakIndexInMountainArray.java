package dsa.binarysearch;

public class FindPeakIndexInMountainArray {
    public static void main(String[] args) {

        int[] arr = {0,1,2,4,2,1};
        System.out.println("The number is ::" + findPeakIndexInMountainArray(arr));
    }

    private static int findPeakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid = start + (end-start)/2;

        while(start < end) {
            if(arr[mid] < arr[mid+1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
            // After each adjustment of the pointers (start or end),
            // we need to calculate a new mid to reflect the new search range.
            mid = start + (end-start)/2;
        }
        return arr[start];
    }
}
