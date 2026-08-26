package generics;

import java.util.Arrays;
import java.util.List;

public class UpperBoundLowerBoundExample {
    public static void main(String[] args) {
       List<? extends Number> num = Arrays.asList(1,2,3); // This line gives error, because of extends keyword
        List<? super Number> num2 = Arrays.asList(1,2,3); // This line gives error
         // num.add(10);   // This line gives error, as we cannot add this number
        System.out.println(sum(num));
        printNumbers(num2);
    }

    // UPPER BOUND
    // To declare an upper-bounded wildcard, use the wildcard character (‘?’),
    // followed by the extends keyword, followed by its upper bound.

    // ↓
    public static double sum(List<? extends Number> numbers) {
        double sum = 0;
        for (Number num: numbers) {
            sum+= num.doubleValue();
        }
        return sum;
    }

    // It is expressed using the wildcard character (‘?’),
    // followed by the super keyword, followed by its lower bound: <? super A>.

    // ↑
    public static void printNumbers(List<? super Integer> list) {
        for(Object obj : list) {
            System.out.print(obj + " ");
        }
    }
}
