package interview_ques.productbased.zyx;

import java.util.ArrayList;
import java.util.List;

public class ZeptoJavaQuestion {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7};
        int subArraySize = 5;
        List<List<Integer>> result = generateSubarrays(arr, subArraySize);

        // Print the result
        for (List<Integer> subarray : result) {
            System.out.println(subarray);
        }
    }

    public static List<List<Integer>> generateSubarrays(Integer[] arr, int subArraySize) {
        List<List<Integer>> result = new ArrayList<>();

        int n = arr.length;
        // multiplying the subArraySize with arr.length
        for (int i = 0; i < (n*subArraySize); i++) {
            List<Integer> subarray = new ArrayList<>();
            for (int j = 0; j < subArraySize; j++) {
                int index = (i + j) % n; // Circular index to handle wrapping around the end of the array
                //System.out.println("index ::" +index);
                subarray.add(arr[index]);
                //System.out.println("subarray ::" +subarray);
            }
            // System.out.println("i ::" +i);
            i= i+subArraySize-1;
            //System.out.println("i now ::" +i);


            result.add(subarray);
        }
        return result;
    }
}

// index ::0
// subarray ::[1]
// index ::1
// subarray ::[1, 2]
// index ::2
// subarray ::[1, 2, 3]
// index ::3
// subarray ::[1, 2, 3, 4]
// i ::0
// i now ::3
// index ::4
// subarray ::[5]
// index ::5
// subarray ::[5, 6]
// index ::6
// subarray ::[5, 6, 7]
// index ::0
// subarray ::[5, 6, 7, 1]
// i ::4
// i now ::7
// index ::1
// subarray ::[2]
// index ::2
// subarray ::[2, 3]
// index ::3
// subarray ::[2, 3, 4]
// index ::4
// subarray ::[2, 3, 4, 5]
// i ::8
// i now ::11
// index ::5
// subarray ::[6]
// index ::6
// subarray ::[6, 7]
//index ::0
// subarray ::[6, 7, 1]
// index ::1
// subarray ::[6, 7, 1, 2]
// i ::12
// i now ::15
// index ::2
// subarray ::[3]
// index ::3
// subarray ::[3, 4]
// index ::4
// subarray ::[3, 4, 5]
// index ::5
// subarray ::[3, 4, 5, 6]
// i ::16
// i now ::19
// index ::6
// subarray ::[7]
// index ::0
// subarray ::[7, 1]
// index ::1
// subarray ::[7, 1, 2]
// index ::2
// subarray ::[7, 1, 2, 3]
// i ::20
// i now ::23
// index ::3
// subarray ::[4]
// index ::4
// subarray ::[4, 5]
// index ::5
// subarray ::[4, 5, 6]
// index ::6
// subarray ::[4, 5, 6, 7]
// i ::24
// i now ::27

// [1, 2, 3, 4]
// [5, 6, 7, 1]
// [2, 3, 4, 5]
// [6, 7, 1, 2]
// [3, 4, 5, 6]
// [7, 1, 2, 3]
// [4, 5, 6, 7]