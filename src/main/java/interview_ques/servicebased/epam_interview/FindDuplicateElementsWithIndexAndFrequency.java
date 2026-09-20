package interview_ques.servicebased.epam_interview;


import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class FindDuplicateElementsWithIndexAndFrequency {
    public static void main(String[] args) {
        int[] nums = {10,20,10,30,20,40,10,50,40};  // Output: [0, 3] [1, 2]
        List<int[]> result = findDuplicates(nums);
        System.out.println(
                result.stream()
                        .map(Arrays::toString)
                        .collect(Collectors.joining(System.lineSeparator()))
        );
    }

    // We are not using Arrays.stream(nums) because it only give the values of the array, but our problem statement requires the indexes as well.
    // Hence, we are using IntStream.range(0, nums.length) function to get (index, frequency)
    // boxed() is used to convert primitive int to Integer object, since collect() method works only on Objects.
    public static List<int[]> findDuplicates(int[] nums) {

        return IntStream.range(0, nums.length)
                .boxed()
                .collect(Collectors.groupingBy(
                        index -> nums[index],
                        LinkedHashMap::new,
                        Collectors.toList()
                ))
                .values()
                .stream()
                .filter(integerList -> integerList.size() > 1)
                .map(integerList -> new int[]{
                        integerList.get(0),  // first index
                        integerList.size()   // frequency
                })
//              .map(entry -> new int[]{
//                        entry.getValue().get(0),  // first index
//                        entry.getValue().size()   // frequency
//              })
                .collect(Collectors.toList());
    }
}
