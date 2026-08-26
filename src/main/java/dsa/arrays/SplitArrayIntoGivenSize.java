package dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitArrayIntoGivenSize {

    public static List<int[]> splitArray(int[] arr, int splitSize) {
        List<int[]> res = new ArrayList<>();

        // 1. edge case
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        // 2. edge case
        if (splitSize <= 0) {
            res.add(new int[0]);
            return res;
        }

        // 3. If splitSize is greater than array length
        // return the whole array as one chunk.
        if(splitSize< 0 || splitSize> arr.length) {
            res.add(Arrays.copyOf(arr, arr.length));
            return res;
        }

        int arraySplit = arr.length / splitSize;
        int remain = arr.length % splitSize;

        int start=0, end=0;
        for (int i = 0; i < arraySplit; i++) {
            end = end + splitSize;
            res.add(Arrays.copyOfRange(arr, start, end));
            start = end;
        }

        if(remain > 0) {
            res.add(Arrays.copyOfRange(arr, start, arr.length));
        }

        return res;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2,5,6,7,8,9,0,11,13,16,17};
        List<int[]> res = splitArray(arr, 5);

        for (int[] result: res) {
            System.out.println(Arrays.toString(result));
        }
    }
}
