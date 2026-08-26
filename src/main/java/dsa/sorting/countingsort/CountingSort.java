package dsa.sorting.countingsort;

import java.util.Arrays;

// Time Complexity: 3(N+K) = O(N+K)
public class CountingSort {
    public static void main(String[] args) {
        int arr[] = {100,1,0,5,4};
        System.out.println(Arrays.toString(countSort(arr)));
    }

    private static int[] countSort(int[] arr) {
        //1. Count frequency
        int max = Integer.MIN_VALUE;
        for (int val : arr){
            max = Math.max(max, val);
        }
        int count[] = new int[max+1];
        for (int val: arr) {
            count[val]++;
        }
        System.out.println(Arrays.toString(count));
        //2. Prefix sum (K)
        for (int i = 1; i < max+1; i++) {
            count[i] += count[i-1];
        }
        System.out.println("count now:: " +Arrays.toString(count));

        // 3. Arrange the elements
        int n = arr.length;
        int res[] = new int[n];
        for (int i = n-1; i >= 0; i--) {
            int val = arr[i];
            int prefixCount = count[val];
            res[prefixCount-1] = val;
            count[val]--;
        }
        return res;
    }
}
