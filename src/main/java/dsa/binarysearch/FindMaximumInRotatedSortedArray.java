package dsa.binarysearch;

public class FindMaximumInRotatedSortedArray {
    public static void main(String[] args) {
        // int nums[] = {2,2,4,0,1,4,6};
        int nums[] = {2,4,7,46, 93};
        int maxIndex = findMax(nums);
        System.out.println("The index of maximum number in rotated sorted array is : " + maxIndex);
        System.out.println("The maximum in rotated sorted array is : " + nums[maxIndex]);
    }

    private static int findMax(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            int mid = start + (end-start)/2;
            if(arr[mid] > arr[mid+1]) {
                return mid;
            }
            // if right half is sorted, move left
            else if(arr[start] > arr[mid]) {
                end = mid - 1;
            }
            // if left half is sorted, move right
            else {
                start = mid + 1;
            }
        }

        return end;
    }
}
