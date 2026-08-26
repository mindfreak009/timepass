package interview_ques;

import java.util.Arrays;
import java.util.stream.IntStream;

// input  :   int[] num = {1,2,3,4,5};
// output ;   int[] num = [5, 4, 3, 2, 1]

// Time Complexity : O(N)
public class ReverseArrayOfIntegersInPlace {
    public static void main(String[] args) {
        int[] num = {1,2,3,4,5};

        // Approach 1 : JAVA 8
        IntStream.range(0, num.length/2).forEach(i -> {
               int temp = num[i];
               num[i]  = num[num.length - i - 1];
               num[num.length - i - 1] = temp;
        });
        System.out.println(Arrays.toString(num));

        // Approach 2 : JAVA 8
        for (int i = 0; i < num.length/2 ; i++) {
            int temp = num[i];
            num[i]  = num[num.length - i - 1];
            num[num.length - i - 1] = temp;
        }
        System.out.println(Arrays.toString(num));


        int i = 0;
        print1to100WithoutForLoop(i);

    }

    private static void print1to100WithoutForLoop(int i) {
        i++;
        if(i <= 100) {
            System.out.print(i + " ");
            print1to100WithoutForLoop(i);
        }
    }
}
