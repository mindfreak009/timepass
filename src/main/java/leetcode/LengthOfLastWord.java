package leetcode;

// Input: s = "Hello World"
// Output: 5
// Explanation: The last word is "World" with length 5.

// Input: s = "   fly me   to   the moon  "
// Output: 4
// Explanation: The last word is "moon" with length 4.

// Input: s = "luffy is still joyboy"
// Output: 6
// Explanation: The last word is "joyboy" with length 6.

public class LengthOfLastWord {
    public static void main(String[] args) {
        String s =  "   fly me   to   the moon  ";
        System.out.println(findLengthOfLastWord(s));
    }

    private static int findLengthOfLastWord(String s) {
        s = s.trim();

        int count = 0;
        for (int i = s.length() -1; i > 0; i--) {
            if(s.charAt(i) != ' '){
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}
