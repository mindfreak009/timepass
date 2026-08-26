package interview_ques.m2p;

public class Palindrome {
    public static void main(String[] args) {
      //   String str = "level";
      //   String str = "abba";
           String str = "class";
        System.out.println(stringPalindromeCheck(str));
    }

    private static boolean stringPalindromeCheck(String str) {
        boolean b = false;
        int j = 0;
        for (int i = str.length()-1; i >= 0; i--) {
            if(i!=j && str.charAt(i) != str.charAt(j)) {
                return false;
                // break;
            } else {
                j++;
                b = true;
            }
        }
        return b;
    }
}
