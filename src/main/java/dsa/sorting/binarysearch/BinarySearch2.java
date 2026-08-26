package dsa.sorting.binarysearch;

public class BinarySearch2 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[] {10,20,30, 45, 51, 70, 100, 571};

        int targetElement = 571;

        int targetElement1 = findTargetElement(arr, targetElement);
        System.out.println("targetElement :::" +targetElement1);
    }

    private static int findTargetElement(Integer[] arr, int targetElement) {

        int start = 0;
        int end = arr.length-1;

        while(start <= end) {
            // calculate mid element
            int mid = start + (end-start)/2;

            if(targetElement > arr[mid]) {
                start = mid + 1;
            } else if(targetElement < arr[mid]) {
                end = mid - 1;
            } else {
                // answer found
                return mid;
            }
        }
        return -1;
    }
}
