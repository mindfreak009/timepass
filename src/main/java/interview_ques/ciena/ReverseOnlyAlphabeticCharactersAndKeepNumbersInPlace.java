package interview_ques.ciena;

// Ouput:D1C2B3A4
public class ReverseOnlyAlphabeticCharactersAndKeepNumbersInPlace {
    public static void main(String[] args) {
        String s = "A1B2C3D4";
        System.out.println(reverseAlphabetsOrderButKeepNumbers(s));
    }

    private static String reverseAlphabetsOrderButKeepNumbers(String s) {
        // Convert the string to a char array
        char[] ch = s.toCharArray();

        // List to collect the alphabetic characters in the string
        StringBuilder alphabets = new StringBuilder();

        // First, collect all alphabetic characters from the string
        for (char c : ch) {
            if (Character.isAlphabetic(c)) {
                alphabets.append(c);
            }
        }

        // Reverse the collected alphabetic characters
        alphabets.reverse();

        // StringBuilder to build the result
        StringBuilder sb = new StringBuilder();
        int alphabetIndex = 0;

        // Iterate over the original char array and replace alphabetic characters with the reversed ones
        for (char c : ch) {
            if (Character.isAlphabetic(c)) {
                sb.append(alphabets.charAt(alphabetIndex++));  // Append from the reversed alphabet list
                //alphabetIndex++;
            } else {
                sb.append(c);  // Keep the digits in their original position
            }
        }

        return sb.toString();
    }

}
