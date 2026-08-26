package leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//  Given an integer array nums where every element appears three times except for one,
//  which appears exactly once. Find the single element and return it.
public class SingleNumberII {
    public static void main(String[] args) {
        // int[] nums = {2,2,3,2};
        int[] nums = {0,1,0,1,0,1,99};
        // System.out.println(singleNumber(nums));
        System.out.println("Answer is ::: " + singleNumberSecondApproach(nums));
    }

    // 2. SECOND APPROACH
    private static int singleNumberSecondApproach(int[] nums) {
        Map<Integer, Long> collect = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("map here :: " + collect);

        return collect.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(-1);
    }
}
