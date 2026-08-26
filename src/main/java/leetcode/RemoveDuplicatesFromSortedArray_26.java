package leetcode;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicatesFromSortedArray_26 {
    public static void main(String[] args) {

        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(arr));

    }

    public static int removeDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int unique = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] != nums[i-1]){
                unique+= 1;
                System.out.println("unique :: " +unique);
                nums[unique - 1] = nums[i];
                //list.add(nums[unique-1]);

            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println("list " +list);
        return unique;

    }
}
