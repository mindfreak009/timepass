package interview_ques.paypal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalInt;

public class SecondLargestElement {
    public static void main(String[] args) {
       int[] arr = {12,13,34,6,50,7,52};
       // int[] arr = {12,12,12,12,12,12,12};

        System.out.println(secondLargestElement(arr));
        secondLargestElementJava8(arr);
    }


// Time Complexity: O(N)
    private static int secondLargestElement(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = 0;
        // Arrays.sort(arr);  // o(nlogN) + O(N)

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max && secondMax != max) {
                secondMax = max;
                max = arr[i];
            }
        }

        if(secondMax < 0) {
            return 0;
        }
        return secondMax;

    }

    private static void secondLargestElementJava8(int[] arr) {
//       Arrays.stream(arr)
//                .sorted()
//                .skip(1)
//                .limit(1)
//                .findFirst()
//                .getAsInt();

        OptionalInt secondLargest =
                Arrays.stream(arr)  // Create an IntStream from the array
                .distinct()  // Remove duplicates
                .sorted()  // Sort the stream in ascending order
                .skip(arr.length - 2)  // Skip all but the last two elements
                .findFirst();

    // This code also works fine !!
//                Arrays.stream(arr)  // Create an IntStream from the array
//                        .boxed()    // Converting the primitive int to Wrapper type
//                        .distinct()  // Remove duplicates
//                        .sorted()  // Sort the stream in ascending order
//                        .skip(arr.length - 2)  // Skip all but the last two elements
//                        .findFirst()
//                        .ifPresentOrElse(System.out::print, () -> System.out.println("No second largest element found"));

        secondLargest.ifPresentOrElse(
                System.out::println,  // Print the second largest if found
                () -> System.out.println("No second largest element found"));// Handle case where second largest doesn't exist;
    }
}

