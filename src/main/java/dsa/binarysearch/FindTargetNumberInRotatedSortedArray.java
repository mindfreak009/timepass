package dsa.binarysearch;

public class FindTargetNumberInRotatedSortedArray {
    public static void main(String[] args) {

        //int[] nums = {63,2,3,7,9};
        int[] nums = {5,6,7,8,9,1,2,3};
        int target = 3;
        int targetNumberIndex = findTargetNumberInRotatedSortedArray(nums, target);
        System.out.println("Target number found in array index :: " +targetNumberIndex);
    }

    private static int findTargetNumberInRotatedSortedArray(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;
        int ans = -1;

        while(start <= end) {
            int mid = start + (end -start)/2;

            if(target == arr[mid]) {
                return mid;
            }
            // left side is sorted
            if(arr[start] <= arr[mid]) {
                // can ans be found in left side?
                if(target >= arr[start] && target < arr[mid]){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // right side is sorted
            else {
                // can ans be found in right side?
                if (target >= arr[mid] && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return ans;
    }
}
