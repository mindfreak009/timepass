package leetcode;
// Constraints:
//  -2^31 <= x <= 2^31 - 1

// Follow up: Could you solve it without converting the integer to a string?

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println("result is ::: " +isPalindrome(45061));
    }

    public static boolean isPalindrome(int num) {
        int originalNumber = num;
        int finalResult = 0;

        while(num > 0) {
            finalResult = finalResult * 10 + num%10;
            num = num/10;
        }

        if(finalResult == originalNumber) {
            return  true;
        }

        return false;
    }
}
