package dsa.searching;

public class Searching {
    public static void main(String[] args) {
        int[] arr = {2,3,5,7,11,15,17, 21, 24, 28, 30};
       // int index = ternarySearch(arr, 15);
        int index = exponentialSearch(arr, 7);
        if(index == -1) {
            System.out.println("No element found at index:  " +index);
        } else {
            System.out.println("Found element at index :: "+ index);
        }
    }

    // Time Complexity: (2\sqrt{n}\) = (\sqrt{n})
    public static int ternarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        int index = -1;

        while(start <= end){
            int mid1= start + (end-start)/3;
            int mid2= end - (end-start)/3;

            if(target <= arr[mid1]){
                if(target == arr[mid1]) {
                    index = mid1;
                    break;
                }
                end = mid1-1;
            } else if(target >= arr[mid2]){
                if(target == arr[mid2]) {
                    index = mid2;
                    break;
                }
                start = mid2+1;
            } else {
                start = mid1 + 1;
                end = mid2 - 1;
            }
        }
        return index;
    }

    // enclose the target
    // Time Complexity:
    public static int exponentialSearch(int[] arr, int target) {
        if(arr[0] == target) {
            return 0;
        }
        int i = 1;
        int n = arr.length;

        // skip the range
        while(i<n && arr[i] <= target) {
            i = 2*i;
        }
        int end = Math.min(i,n-1);
        int index = binarySearchOnRange(arr, target, i/2, end);


        return index;
    }

    public static int binarySearchOnRange(int arr[], int target, int start, int end) {
        int ans = -1;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(arr[mid] == target) {
                ans = mid;
                break;
            } else if (arr[mid] < target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return ans;
    }


}

