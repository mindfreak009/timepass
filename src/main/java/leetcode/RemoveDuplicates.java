package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] arr) {
        Map<Integer, String> map = new HashMap<>();

        int i=0;
        for(int j=1;j<arr.length;j++){
            if(arr[i] == arr[j]) {
                //i++;
                map.put(arr[j], j+"-");
            } else if(arr[i]!=arr[j]){
                i++;
                arr[i]=arr[j];
            }
        }
        for (Map.Entry<Integer, String> m :  map.entrySet()) {
            Integer val = m.getKey();
            System.out.print(val + " ");

        }
        // System.out.println( "list :: " + map);
        return i+1;
    }
}
