package java_oca;

import java.time.LocalDate;

public class Ques258 {
    private static int b = 10;
    public static void main(String[] args) {
        int a = '7';
        System.out.println(a);

        switch (a) {
            case '7' :
                System.out.println(1);
                break;
            case 7 :
                System.out.println(2);
                break;
        }
        char ch = '1';
        char ch1 = 'a';
        char ch2 = '\u0349';
        System.out.println(ch2);
        System.out.println("b :: " + b);

        String str = "Hello";
        String str1 = "" + "Hello";

        System.out.println(str.equals(str1));

        LocalDate date = LocalDate.of(2024, 10, 2);
        System.out.println(date.getMonthValue());

    }
}
