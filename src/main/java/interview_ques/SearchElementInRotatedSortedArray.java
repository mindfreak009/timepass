package interview_ques;

public class SearchElementInRotatedSortedArray {
    public static void main(String[] args) {

        int[] nums = {5,6,7,8,9,1,2,3};
        int target = 7;
        int ans = findNumber(nums, target);
        System.out.println("Target Number is available in index position: " + ans);
    }

    private static int findNumber(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        int ans = -1;

        while(start <= end) {
            int mid = start + (end-start)/2;

            // If target is
            if(target == arr[mid]) {
                return mid;
            }
            // left part is sorted
            if(arr[start] <= arr[mid]) {
                // can answer be found on left side ?
                if(target >= arr[start] && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // right part is sorted
            else {
                if(target >= arr[mid] && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return ans;
    }
}
