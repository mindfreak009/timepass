package dsa.sorting.countingsort;

import java.util.Arrays;

// Time Complexity: O(N+K), K being the maximum from the array
// Space Complexity: O(N)
public class CountingSort1 {
    public static void countSort(int[] arr) {
        // Base condition
        if(arr == null || arr.length<=1) {
            return;
        }
        
        // Step 1: Find the maximum 
        int maxNum = 0;
        for (int num: arr) {
            maxNum = Math.max(num, maxNum);
        }
        
        // Step 2: Create a freqCount arr
        int[] countArr = new int[maxNum+1];
        for (int num : arr){
            countArr[num]++;
        }
        System.out.println("countArr:: " + Arrays.toString(countArr));

        // Step 3: Traverse over the original array
        int index = 0;
        for (int i=0; i<=maxNum; i++) {
            while(countArr[i] > 0){
                arr[index] = i;
                index++;
                countArr[i]--;
            }
        }
    }
    

    public static void main(String[] args) {
        int[] arr = {6,3,10,9,2,4,9,0,7};
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
