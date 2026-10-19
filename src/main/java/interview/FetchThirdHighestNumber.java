package interview;

import java.util.*;

// fetch the third highest
public class FetchThirdHighestNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3,4,6,7,9,7,8,4,4);
        Optional<Integer> first =
                list.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst();

        System.out.println(first.orElseGet(null));


    }
}
