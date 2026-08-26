package random_coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusMinusNumbers {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(-4, 3, -9, 0, 4, 1));
        plusMinus(list);
    }

    public static void plusMinus(List<Integer> arr) {
        // Write your code here

        double positiveNums = 0;
        double negativeNums = 0;
        double zeroNums = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > 0) {
                positiveNums++;
            } else if (arr.get(i) < 0) {
                negativeNums++;
            } else {
                zeroNums++;
            }

        }
        System.out.printf("%.6f", positiveNums/arr.size());
        System.out.println();
        System.out.printf("%.6f", negativeNums/arr.size());
        System.out.println();
        System.out.printf("%.6f",  zeroNums/ arr.size());
    }
}
