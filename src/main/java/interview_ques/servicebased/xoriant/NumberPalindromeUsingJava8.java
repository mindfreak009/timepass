package interview_ques.servicebased.xoriant;

import java.util.stream.IntStream;

public class NumberPalindromeUsingJava8 {
    public static void main(String[] args) {

        String num = "12321";
        System.out.println(isPalindrome(num));
        System.out.println(isPalindromeUsingStreams(num));
    }

    public static boolean isPalindromeUsingStreams(String num) {
        return IntStream.range(0, num.length() / 2)
                .noneMatch(i -> num.charAt(i) != num.charAt(num.length() - i - 1));
    }

    public static boolean isPalindrome(String num) {
        int left = 0;
        int right = num.length() - 1;

        while (left < right) {
            if (num.charAt(left) != num.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
