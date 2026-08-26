package dsa.sorting.radixsort;


import java.util.Arrays;

// Time Complexity: K * (N + 10 + N)
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {1, 603, 44, 7, 101, 67};
        System.out.println(Arrays.toString(radixSort(arr)));
    }

    private static int[] radixSort(int[] arr) {
        // finding max element
        int max = Integer.MIN_VALUE;
        for(int a: arr) {
            max = Math.max(a, max);
        }
        // Find the max number of digits
        int digits = (max==0)?1:(int)Math.log10(max)+1;
        for (int d = 0; d < digits; d++) {
            // 403 ==> (403 / 1) % 10     Ans: 3
            // 403 ==> (403 / 10) % 10    Ans: 0
            // 403 ==> (403 / 100) % 10   Ans: 4
            int count[] = new int[10];
            for (int a : arr) {
                int digit = (a/(int)Math.pow(10, d)) % 10;
                count[digit]++;
            }
            for (int j = 1; j < 10; j++) {
                count[j] += count[j-1];
            }
            int n = arr.length;
            int res[] = new int[n];
            for (int j= n-1; j>=0; j--) {
                int digit = (arr[j]/(int)Math.pow(10, d)) % 10;
                int freq = count[digit];
                res[freq-1] = arr[j];
                count[digit]--;
            }
            arr = res;
        }

        return arr;
    }
}
