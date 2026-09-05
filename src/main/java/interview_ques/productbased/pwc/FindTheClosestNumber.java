package interview_ques.productbased.pwc;

import java.util.Arrays;
import java.util.List;

// given an number, find the closest number, given the input.
// int[] arr = {2, 3, 5, 6, 8}
// input=4
// Explanation : If input=4, then the closest numbers are 3 and 5.
//               In this case, it should output 3, 3 being the smallest number

public class FindTheClosestNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 3, 5, 6, 8);
        int input = 47;
       // int input = 4;

        System.out.println(findClosestNumber(list, input));
    }

    public static int findClosestNumber(List<Integer> list, int input) {
        int closest = list.get(0);  // Initialize with the first element
        System.out.println("closest :: " +closest);

        // int minDifference = Math.abs(input - closest);  // Initial difference
        int minDifference = Integer.MAX_VALUE;
        System.out.println("minDifference :: " +minDifference);
        System.out.println("==================================================");

        for (int num : list) {
            int difference = Math.abs(input - num);
            // If a smaller difference is found, update closest
            if (difference < minDifference || (difference == minDifference && num < closest)) {

                closest = num;
                System.out.println("closest :: " +closest);

                minDifference = difference;
                System.out.println("minDiff here :: " +minDifference);
            }
        }

        return closest;
    }
}

//    private static int findTheClosestNumber(List<Integer> list, int input) {
//
//        int minVal = Integer.MAX_VALUE;
//        for(int i = 0; i < list.size(); i++) {
//            if(Math.abs(list.get(i)) < Math.abs(minVal) || input == list.get(i)) {
//                minVal = list.get(i);
//            }
//        }
//
//        return minVal;
//    }
//}


//        for (int i = 1; i < list.size()-1; i++) {
//            int prevElement = list.get(i-1);
//            int currElement = list.get(i);
//
//            if(prevElement==input) {
//                return prevElement;
//            } else if(currElement == input) {
//                return currElement;
//            } else if(input > list.get(i)) {
//                return Math.min(list.get(i), input);
//            }
//        }

      // return -1;

