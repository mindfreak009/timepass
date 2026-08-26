package dsa.binarysearch;

// Bitonic array is first part in increasing order and then decreasing order.

// Time Complexity : OlogN
public class FindPeakElementInBitonicArray {
    public static void main(String[] args) {

       int[] arr = {2,4,6,8,11,16, 24, 13,11,9,3,2,1};
        // int[] arr = {22,12,5,2,1,0};
        int index = findPeakElementInBitonicArray(arr);
        if(index == -1) {
            System.out.println("Element doesn't exist");
        } else {
            System.out.println("Number " +arr[index] + " exist at index : " +index);
        }

        findElementInBitonicArray(arr, 22);

    }

    private static int findElementInBitonicArray(int[] arr, int target) {
            int index = findPeakElementInBitonicArray(arr);
            if(index == -1 || target > arr[index]) {
                System.out.println("Element doesn't exist");
            } else if(target == arr[index]){
                System.out.println("Number " +arr[index] + " exist at index : " +index);
                return 0;
            }
        return -1;
    }
    private static int findPeakElementInBitonicArray(int[] arr) {

        int start = 0;
        int end = arr.length-1;
        int mid = start + (end-start)/2;

        // Finding next and previous element
        int next = (mid+1) % arr.length;
        int prev = (mid-1 + arr.length) % arr.length;

        System.out.println("Previous element is ::: " + prev + " and next element " + next);

        if(arr[mid] > arr[prev] && arr[mid] > arr[next]) {
            return mid;
        } else if(arr[mid] > arr[prev]) {
            start = mid+1;
        } else {
            end = mid-1;

        }
        return -1;
    }
}
