package dsa.strings;

// Time complexity - O(N)
// because O(N)/2 is basically O(N) because we ignore the constant.

public class Palindrome {
    public static void main(String[] args) {
         String str = "abcdcba";
        // String str = "abccba";
        // String str = "";
        // String str = null;
        int num[] = {1234321};
       // System.out.println(isPalindrome(str));
        System.out.println(isNumberPalindrome(num));

    }

    static boolean isNumberPalindrome(int[] num) {
        if(num == null  || num.length == 0) {
            return false;
        }

        for (int i = 0; i <= num.length / 2 ; i++) {
            // char start = str.charAt(i);
            int start = num[i];
            System.out.println("start ::" +start);

            int end = num.length - 1 - i;
            System.out.println("end ::" +end);

            if(start != end) {
                return false;
            }
        }
        return true;
    }

    static boolean isPalindrome(String str) {
        if(str == null || str.length() == 0) {
            return false;
        }

        str = str.toLowerCase();
        for (int i = 0; i <= str.length() / 2 ; i++) {
            char start = str.charAt(i);
            char end = str.charAt(str.length() - 1 - i);

            if(start != end) {
                return false;
            }
        }
        return true;
    }
}
