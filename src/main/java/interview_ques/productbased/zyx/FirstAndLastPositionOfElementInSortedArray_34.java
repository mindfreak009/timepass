package interview_ques.productbased.zyx;

import java.util.Arrays;

public class FirstAndLastPositionOfElementInSortedArray_34 {
    public static void main(String[] args) {
       //  int[] arr = {1,2,3,5,5,5,5,6,6,7,8,9};
       //  int numToBeFound = 5;
        int[] arr = {5,7,7,7,8,10};
        int numToBeFound = 7;

        int[] ans = findFirstAndLastPositionOfNumber(arr, numToBeFound);
        System.out.println(Arrays.toString(ans));

        System.out.println(Arrays.toString(findFirstAndLastPositionOfNumberImproved(arr, numToBeFound)));

    }

    // Time Complexity : O(N)
    private static int[] findFirstAndLastPositionOfNumber(int[] arr, int numToBeFound) {

        int firstNum = -1;
        int lastNum = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == numToBeFound) {
                if(firstNum == -1) {
                    firstNum = i;
                }
                lastNum = i;
            }
        }

        return new int[]{firstNum, lastNum};
    }

    // Time Complexity: O(log N)
    private static int[] findFirstAndLastPositionOfNumberImproved(int[] arr, int numToBeFound) {

       int left =  findLeftBound(arr, numToBeFound);
       int right =  findRightBound(arr, numToBeFound);

       return new int[]{left, right};
    }

    private static int findLeftBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;
        int index = -1; // If we take 0 here, then we get vague results, becuase 0 would indicate 0th position.

        while(low <= high) {
            int mid = low + (high-low)/2;

            if(arr[mid] == target) {
                index = mid;
                high = mid-1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }

    private static int findRightBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;
        int index = -1;

        while(low <= high) {
            int mid = low + (high-low)/2;

            if(arr[mid] == target) {
                index = mid;
                low = mid+1;
            } else if (arr[mid] > target) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }


}
