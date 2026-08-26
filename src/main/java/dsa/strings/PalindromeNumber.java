package dsa.strings;

public class PalindromeNumber {
    public static void main(String[] args) {
            int num = 123123;
       // int num = 121;
        System.out.println(isPalindrome(num));
    }

    public static boolean isPalindrome(int x) {
       // converting number to String
        String num = String.valueOf(x);
        System.out.println(num);

//        String palindromicSeries = "0,1,2,3,4,5,6,7,8,9";
//        for(int i=0; i<palindromicSeries.length(); i++) {
//            if(x == palindromicSeries.charAt(i)) {
//                return true;
//            }
//        }

        for(int i=0; i<num.length()/2; i++) {
            if(num.charAt(i) == num.charAt(num.length()-i-1)) {
                return true ;
            }
        }
        return false;
    }
}
