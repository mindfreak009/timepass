package dsa.binarysearch;

public class FindMinimumInRotatedSortedArrayWithDuplicateValues {
    public static void main(String[] args) {
        // int nums[] = {4,5,6,7,1,0,0,1,2};
        // int nums[] = {4,5,6,7,7,0,1,4};
        int nums[] = {2,2,2,0,1};
        int minIndex = findMin(nums);
        System.out.println("The minimum in rotated sorted array is : " + nums[minIndex]);
        System.out.println("The minimum in rotated sorted array is : " + minIndex);
    }

    private static int findMin(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            int mid = start + (end-start)/2;

            // condition to check duplicate values
            if(arr[start]==arr[mid] && arr[mid]==arr[end]){
                start++;
                end--;
            }

            if(mid > 0 && arr[mid] < arr[mid-1]) {
                return mid;
            }
            // if right half is sorted, move left
            else if(arr[end] > arr[mid]) {
                end = mid - 1;
            }
            // if left half is sorted, move right
            else {
                start = mid + 1;
            }
        }

        return start;
    }
}

