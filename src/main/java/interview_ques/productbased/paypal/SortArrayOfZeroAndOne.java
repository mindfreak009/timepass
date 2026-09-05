package interview_ques.productbased.paypal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SortArrayOfZeroAndOne {
    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 2, 3, 0, 0, 4, 0};

        Integer[] arr = Stream.concat(
                Arrays.stream(nums).filter(i -> i != 0).boxed(),
                Arrays.stream(nums).filter(i -> i == 0).boxed()
        ).toArray(Integer[]::new);

        System.out.println("Final output" + Arrays.toString(arr));

        Integer[] integers = convertLogic(nums);
        System.out.println("Second approach :: " + Arrays.toString(integers));
    }



    public static Integer[] convertLogic(int[] nums) {
        List<Integer> nonZeros = new ArrayList<>();
        List<Integer> zeros = new ArrayList<>();

        for (int num : nums) {
            if (num != 0) {
                nonZeros.add(num);
                // zeros.add(num);
            } else {
                zeros.add(num);
                // nonZeros.add(num);
            }
        }

       // nonZeros.addAll(zeros);
       // System.out.println("nonZeros ::: " +nonZeros);
        zeros.addAll(nonZeros);
       // zeros.addAll(nonZeros);

      //  return nonZeros.toArray(new Integer[0]);
      //  return nonZeros.toArray(new Integer[0]);
        return zeros.toArray(new Integer[0]);
    }
}
