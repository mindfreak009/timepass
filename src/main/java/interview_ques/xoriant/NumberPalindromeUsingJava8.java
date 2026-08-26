package interview_ques.xoriant;

import java.util.stream.IntStream;

public class NumberPalindromeUsingJava8 {
    public static void main(String[] args) {

        String num = "12321";
        boolean b = IntStream.range(0, num.length() / 2)
                .noneMatch(i -> num.charAt(i) != num.charAt(num.length() - i - 1));

        if(b) {
            System.out.println("Number is palindrome");
        } else {
            System.out.println("Number is NOT palindrome");
        }

//        num.chars().forEach(i -> {
//                    i = 0;
//
//                    char first = num.charAt(i);
//                    char last = num.charAt(num.length()-i-1);
//
//                    if(first != last) {
//                        break;
//                    }
//                    System.out.println("It is palindrome");
//                     i++;
//                });

//        IntStream.rangeClosed(0, num)
//                .forEach(i -> {
//                    int low = num;
//                    int temp = num
//                })
//
    }
}
