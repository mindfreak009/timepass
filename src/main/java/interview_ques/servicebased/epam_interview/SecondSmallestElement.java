package interview_ques.servicebased.epam_interview;

import java.util.Arrays;
import java.util.List;

public class SecondSmallestElement {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 1, 4,3,16,27,48,9,48);
        int number = list.stream()
                .distinct()
                .sorted()
                .skip(1)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No element present in array"));
        System.out.println(number);
    }
}
