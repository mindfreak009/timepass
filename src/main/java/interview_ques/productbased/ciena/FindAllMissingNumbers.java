package interview_ques.productbased.ciena;

// 2,5,1,9


import java.util.*;

// Output: [3, 4, 6, 7, 8]
public class FindAllMissingNumbers {
    public static void main(String[] args) {
        int[] arr = {2,5,1,9};

        System.out.println(findAllMissingNumbers(arr));
    }

    public static List<Integer> findAllMissingNumbers(int[] arr) {

        // Step 1: Find the minimum and maximum
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();

        // Step 2: Create a set of all numbers from min to max
        Set<Integer> allNumbers = new HashSet<>();
        for (int i = min; i <= max; i++) {
            allNumbers.add(i);
        }

        System.out.println("here :: " + allNumbers);
        // Step 3: Remove the numbers that are present in the array
        for (int num : arr) {
            allNumbers.remove(num);
        }

        // Step 4: The remaining numbers are the missing numbers
       // System.out.println(allNumbers);

        // Step 5: Converting Set<Integer> to ArrayList<Integer>
        //         Java 10 feature
        return List.copyOf(allNumbers);
    }

//    private static List<Integer> findAllMissingNumbers(int[] arr) {
//
//        // O(N logN)
//        // Arrays.sort(arr);
//
////        List<Integer> list = new ArrayList<>();
////        Set<Integer> set = new HashSet<>();
////
////
////
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//
//        List<Integer> list = new ArrayList<>();
//
//        //time complexity : O(Length of array)
//        for(int i=0; i<arr.length; i++){
//            if(arr[i] < min) {
//                min = arr[i];
//            }
//            if(arr[i] > max) {
//                max = arr[i];
//            }
//            list.add(arr[i]);
//        }
//
//        for (int i = min; i < max; i++) {
//            if(!list.contains(arr[i]))
//                list.add(arr[i]);
//        }
//
//        System.out.println("list here :: " +list);
////
////        for (int i = min; i < max; i++) {
////
////        }
//
//
//        return list;
//    }


}
