package leetcode;

// Example 1:
// Input: s = "the sky is blue"
// Output: "blue is sky the"

// Example 2:
// Input: s = "  hello world  "
// Output: "world hello"
// Explanation: Your reversed string should not contain leading or trailing spaces.

// Example 3
// Input: s = "a good   example"
// Output: "example good a"
// Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

public class ReverseWordsinAString {
    public static void main(String[] args) {
        // String str = " hello world  ";
        String str = "a good   example";
        System.out.println(reverseWords(str.trim()));
    }

    public static String reverseWords(String str) {
        // code to compact any whitespace between words and remove any at the string's beginning & end
        str = str.trim().replaceAll("\\s+", " ");
        String[] splitt = str.split(" ");

        String newStr = "";
        for (int i = splitt.length-1; i >=0; i--){
            str = splitt[i];
            newStr = newStr + " " +str ;
        }
        return newStr;
    }
}
