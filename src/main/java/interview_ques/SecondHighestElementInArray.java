package interview_ques;

import java.util.Arrays;
import java.util.Collections;

public class SecondHighestElementInArray {
    public static void main(String[] args) {
        int[] arr = {3, 10, 2, 12, 19, 6, 8, 14, 19};
        System.out.println(secondHighestElement(arr));
        secondHighestElementUsingJava8(arr);
    }

    // Time Complexity : O(N)
    // Space Complexity : O(1)
    public static int secondHighestElement(int[] nums) {
        int[] arr = {3, 10, 2, 12, 19, 6, 8, 14, 19, 19, 19};
        //  int[] arr = {10,19,5, 19};

        /*  1. FIRST APPROACH  */
        // int highest = arr[0];              This  is also valid
        int highest = Integer.MIN_VALUE;   // This is also valid
        int second = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > highest) {
                highest = arr[i];
            }
            // second condition needed if there are duplicate values in ARRAY
            else if (arr[i] > second && arr[i]!= highest) {
                second = arr[i];
            }
        }
        //return second;
        System.out.println("Second Max Element2 ::: " + second);
        System.out.println("Highest Max Element2 ::: " + highest);
        System.out.println("======================================");


        /*  2. SECOND APPROACH USING JAVA 8 */
        // If array contains duplicates
        int[] newArr = Arrays.stream(arr)
                .distinct()
                .toArray();

        // Find the maximum element using streams
        int maxNum = Arrays.stream(newArr)
                .max()
                .getAsInt();

        // Find the second largest element using streams
        int secondMax = Arrays.stream(newArr)
                .filter(num -> num < maxNum)
                .max()
                .orElse(maxNum);

        return secondMax;
    }

    public static int secondHighestElementUsingJava8(int[] nums) {

        int[] nums1 = {9,8,5,1, 21, 11, 8, 21};
        Integer secondHighestNumber = Arrays.stream(nums1)
                .boxed()
                .sorted(Collections.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
        System.out.println("Second Highest Element ::: " +secondHighestNumber);

        String[] str = {"hello", "world", "microservices", "am"};
        // Arrays.stream(str).
        return 0;
    }
}
