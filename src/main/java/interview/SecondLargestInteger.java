package interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecondLargestInteger {
    public static void main(String[] args) {
        // 2nd largest integer
        List<Integer> list = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

        int max = Integer.MIN_VALUE;
        int secondMax = 0;
        for (int i = 0; i < list.size(); i++) {
           if(list.get(i) > max && secondMax != max) {
               secondMax = max;
             //  System.out.println("secondMax here  ::: "+secondMax);
               max = list.get(i);
              // System.out.println("max here  ::: "+max);

           }
        }

        System.out.println("secondMAx ::: "+secondMax);
        System.out.println(list.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .limit(1)
                .findFirst()
                .orElse(null));

    }
}
