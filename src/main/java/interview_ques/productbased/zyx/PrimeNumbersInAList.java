package interview_ques.productbased.zyx;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumbersInAList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 6, 3, 11, 17, 19, 21, 23, 2);
        System.out.println("prime numbers :: " + findPrimeNumbersList(list));

    }

    private static List<Integer> findPrimeNumbersList(List<Integer> list) {
        return list.stream()
                .filter(i -> {
                    if(findPrimeNumber(i)) return true;
                    else return false;
                })
                .collect(Collectors.toList());
    }

    private static boolean findPrimeNumber(int value) {
            if (value < 0) return false;
            return IntStream.rangeClosed(2, (int) Math.sqrt(value))
                    .noneMatch(i -> value % i == 0);
    }
}
