package interview_ques.productbased.zyx;

import java.util.*;

public class FindAllPairsWhoseSumIsEqualToGivenNumber {
    public static void main(String[] args) {
        int[] arr ={10,15,20,5};

        int pairVal = 25;
        findPairs(arr, pairVal);
    }

    private static Map<List<Integer>, Integer> findPairs(int[] arr, int pairVal) {

        Map<List<Integer>, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<arr.length; i++) {
            stack.push(arr[i]);
        }

        int count = 0;
        int i = 0;
        int j = arr.length-1;

        while(i<=j) {
            if(arr[i] + arr[j] == pairVal ) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[j]);
                map.put(list, map.getOrDefault(list, 0)+1);
                stack.pop();
                i++;
            }
            j--;
        }



        //   while(!stack.isEmpty) {

        //   }

        System.out.println(map);
        return map;

    }
}
