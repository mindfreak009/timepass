package dsa.vvip;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Output: {2, 4, 36, 8, 2, 10, 4, 144, 36}
public class IfNumDivByThreeThenSquareNumber {
    public static void main(String[] args) {

        int[] arr = {2, 4, 6, 8, 2, 10, 4, 12, 6};
        List<Integer> result = squareOfNumberIfDivisibleByThree(arr);
        System.out.println(result);
    }

    private static List<Integer> squareOfNumberIfDivisibleByThree(int[] arr) {

       return  Arrays.stream(arr)
                .boxed()
                .map(x -> {
                    if (x % 3 == 0) return x*x;
                    else return x;
                })
                .collect(Collectors.toList());
    }
}
