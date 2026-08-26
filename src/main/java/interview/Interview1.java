package interview;

import java.util.Arrays;

public class Interview1 {
    public static void main(String[] args) {

        int[] marks = {1, 4, 88, 2, 66};
        System.out.println(findMaxMarks(marks));
    }

    public static int findMaxMarks(int[] marks) {
        return Arrays.stream(marks)
                .max()
                .getAsInt();
    }


}
