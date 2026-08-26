package random_coding;

import java.util.Arrays;
// prints   stringList ::: [1, 2, 3, 4, 5]
public class SortNumbersOnlyFromString {
    public static void main(String[] args) {

        String[] str = {"1", "3", "7abc", "4", "2", "xyz8", "5" };

        String[] sortedNumbers = Arrays.stream(str)
                .filter(s -> s.matches("\\d"))   // keep only numeric strings
                .map(Integer::parseInt) // convert numeric strings to integers
                .sorted()
                .map(String::valueOf) //convert sorted integers back to strings
                .toArray(String[]::new);

        System.out.println("stringList ::: " +Arrays.toString(sortedNumbers));


    }
}
