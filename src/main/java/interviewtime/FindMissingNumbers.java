package interviewtime;

import java.util.*;

// WAP to find missing numbers from the below list/array using custom functional interface.
//
// Use case 1:
// [1,0,4,3] // 2
//
// Use case 2:
// [7,8,6,11]   // 9 10
public class FindMissingNumbers {
    public static void main(String[] args) {

        int[] num = {7,8,6,11};
        int min = Arrays.stream(num).min().getAsInt();
        int max = Arrays.stream(num).max().getAsInt();

        System.out.println(findMissingNumbers(num, min, max));
        System.out.println(
                findMissingNumbersUsingCustomFunctionalInterface(Arrays.stream(num).boxed().toList(), min, max));

    }

    private static List<Integer> findMissingNumbersUsingCustomFunctionalInterface(List<Integer> list, int min, int max) {

        MissingNumbersFinder missingNumbersFinder = (listt,maxx) -> {
            List<Integer> missing = new ArrayList<>();
            for (int i = min; i < max; i++) {
                if(!listt.contains(i)) {
                    missing.add(i);
                }
            }
            return missing;
        };

        List<Integer> missingNumbers = missingNumbersFinder.findMissingNumbers(list, max);
        return missingNumbers;

    }

    private static Set<Integer> findMissingNumbers(int[] num, int min, int max) {
        Set<Integer> set = new HashSet<>();

        for (int i = min; i <= max; i++) {
            set.add(i);
        }
        for (int a : num) {
            set.remove(a);
        }
        return set;
    }
}

@FunctionalInterface
interface MissingNumbersFinder {
    List<Integer> findMissingNumbers(List<Integer> inputList, int maxRange);
}


