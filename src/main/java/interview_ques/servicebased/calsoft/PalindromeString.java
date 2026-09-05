package interview_ques.servicebased.calsoft;

// Decide String is palindrome or not

//ABCCBA

// 12321


public class PalindromeString {
    public static void main(String[] args) {
            String s = "ABCCCA";
           // String s = "ABCBA";
            System.out.println(palindromeCheck(s));
    }

    public static boolean palindromeCheck(String str) {

     String first = str;
     StringBuilder sb = new StringBuilder(str);
     sb.reverse();
     System.out.println(sb);

     return first.contentEquals(sb);
    }
}
