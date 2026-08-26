package interview_ques;

public class ConvertStringToIntWithoutPreDefinedFunctions {
    public static void main(String[] args) {
        String str = "20012";
        int result = stringToInt(str);
        System.out.println(result+38); // Output will be 12345
    }

    public static int stringToInt(String str) {
        int num = 0;
        boolean isNegative = false;

        // Check for negative sign
        if (str.charAt(0) == '-') {
            isNegative = true;
            str = str.substring(1); // Remove the negative sign for further processing
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // Convert the character to the corresponding digit
            int digit = ch - '0';

            // Build the number by shifting the existing number left and adding the new digit
            num = num * 10 + digit;
        }

        // If the number was negative, negate the result
        if (isNegative) {
            num = -num;
        }

        return num;
    }
}