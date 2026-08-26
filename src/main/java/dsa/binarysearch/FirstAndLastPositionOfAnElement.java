//package dsa.binarysearch;
//
//import javafx.util.Pair;
//
//
//// code by LoveBabbar
//public class FirstAndLastPositionOfAnElement {
//    public static void main(String[] args) {
//
//        int[] arr = {1,3,3,3,3,3,3,4,5,7};
//        int target = 5;
//
//        Pair<Integer, Integer> result = firstAndLastPosition(arr, arr.length, target);
//        System.out.println("First occurence is at Index ::  " + result.getKey());
//        System.out.println("First occurence is at Index ::  " + result.getValue());
//
//    }
//
//    static Pair<Integer, Integer> firstAndLastPosition(int[] arr, int size, int target) {
//        Pair<Integer, Integer> pair = new Pair<>(
//                findFirstOccurence(arr, size, target),
//                findLastOccurence(arr, size, target));
//        return pair;
//    }
//
//    private static int findFirstOccurence(int[] arr, int size, int target) {
//        int start = 0;
//        int end = arr.length - 1;
//        int mid = start + (end - start)/2;
//        int ans = 0;
//
//        while(start <= end) {
//            if(arr[mid] == target) {
//                ans = mid;
//                end = mid - 1;
//            } else if(arr[mid] > target) {
//                end = mid - 1;
//            } else if(arr[mid] < target){
//                start  = mid + 1;
//            }
//            mid = start + (end - start)/2;
//        }
//
//        return ans;
//    }
//
//    private static int findLastOccurence(int[] arr, int size, int target) {
//        int start = 0;
//        int end = arr.length - 1;
//        int mid = start + (end - start)/2;
//        int ans = 0;
//
//        while(start <= end) {
//            if(arr[mid] == target) {
//                ans = mid;
//                start =  mid + 1;
//            } else if(arr[mid] > target) {
//                end = mid - 1;
//            } else if(arr[mid] < target){
//                start  = mid + 1;
//            }
//            mid = start + (end - start)/2;
//        }
//        return ans;
//    }
//}
