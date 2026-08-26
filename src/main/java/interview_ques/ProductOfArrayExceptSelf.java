package interview_ques;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

//  Input: arr[]  = {10, 3, 5, 6, 2}
//  Output: prod[]  = {180, 600, 360, 300, 900}
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {

        int arr[]  = {10, 3, 5, 6, 2};
        int prod[] = new int[arr.length];

        int prodd = 1;
        for (int i = 1; i < arr.length; i++) {
            prod[i] = arr[i] * prodd;
            System.out.println("prdo[i] ::: " + prod[i]);
            prodd = prod[i];
        }

        System.out.println("prod[i]" + Arrays.toString(prod));

        int prefix[]=new int[arr.length];
        prefix[0]=1; // since first element can have no prefix
        for(int i=1;i<arr.length;i++) {
            prefix[i] = prefix[i-1] * arr[i-1];
        }
        int suffixproduct = 1;
        // Building Product Array
        for(int i=arr.length-1;i>=0;i--)
        {
            prod[i] = suffixproduct * prefix[i];
            suffixproduct *= arr[i];
        }

        System.out.println("suffixProduct ::: " +suffixproduct);






        // 0 1   1 2 3 5 8 13 21 34

        int n1 = 0;
        int n2 = 1;
        int sum = 0;

        System.out.print(n1 + " " +n2+ " ");  // 0 1
        for (int i = 2; i < 10; i++) {
            sum = n1 + n2;
            System.out.print(sum  + " ");    // 1
            n1 = n2;
            n2 = sum;
        }

        int num = 1234;
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        StringBuilder reverse = sb.reverse();
        System.out.println("Reverse number is  ::: " +reverse);

        List<Integer> list = Arrays.asList(2,6,4,9,8,7);
        list.stream().filter(i -> i%2==0).forEach(result -> System.out.print(result + " "));

    }
}
