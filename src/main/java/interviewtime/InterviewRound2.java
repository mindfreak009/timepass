package interviewtime;

// Output: olleh
public class InterviewRound2 {
    public static void main(String[] args) {
        String str = "hello";
        String reversedStr = reverseString(str);
        //System.out.println("Reversed String: " + reversedStr);
    }

    // Method to reverse a string using recursion
    public static String reverseString(String str) {
        // Base case: if the string is empty or has one character, return the string itself
        if (str.isEmpty()) {
            return str;
        }

        // Recursive case: reverse the substring excluding the first character,
        // then append the first character at the end
        String sub = reverseString(str.substring(1)) + str.charAt(0);
        System.out.print(sub);

       // return reverseString(str.substring(1)) + str.charAt(0);
        return "";
    }
}
