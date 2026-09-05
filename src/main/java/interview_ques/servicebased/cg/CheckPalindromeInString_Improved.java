package interview_ques.servicebased.cg;

// Two pointers

// Time Complexity : O(N)
public class CheckPalindromeInString_Improved {
    public static void main(String[] args) {
        String s = "abcdcba";
        // String s = "abda";
        boolean b = true;
        for (int i = 0; i <= s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - i -1) ) {
                b = false;
                break;
            }
        }
        if (b == true) {
            System.out.println("It is palindrome");
        } else {
            System.out.println("It is not palindrome");
        }
    }
}
