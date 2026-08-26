package interview_ques;

import java.util.HashMap;
import java.util.Map;

public class PrintBinaryFormatAndCountZeros {
    public static void main(String[] args) {
        int i = 100;

        // First approach
        String finalResult = convertToBinaryString(i);
        System.out.println(finalResult);
        System.out.println("Count of zeros :: " + countZeros(finalResult));

        // Second Approach
        convertToBinaryString2(i);
    }

    private static String convertToBinaryString(int i) {
        String result = "";
        while(i !=0) {
            int rem = i%2;
            result = rem + result;
            i = i/2;
        }
        return result;
    }

    private static long countZeros(String finalResult) {
        return finalResult.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> c == '0')
                .count();
    }

    private static String convertToBinaryString2(int i) {
        return Integer.toBinaryString(i);
    }
}
