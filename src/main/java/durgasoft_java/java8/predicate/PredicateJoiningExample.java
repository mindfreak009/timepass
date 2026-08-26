package durgasoft_java.java8.predicate;

import java.util.function.Predicate;

public class PredicateJoiningExample {
    public static void main(String[] args) {

        int[] x = {0, 5, 10, 15, 20, 25, 30};
        Predicate<Integer> predicate1 = i-> i>10;
        Predicate<Integer> predicate2 = i-> i%2==0;

        System.out.println("The numbers greater than 10 are: ");
        m1(predicate1, x);

        System.out.println("The even numbers are: ");
        m1(predicate2, x);

        System.out.println("The numbers NOT greater than 10 are: ");
        m1(predicate1.negate(), x);

        System.out.println("The numbers Greater than 10 AND Even numbers are: ");
        m1(predicate1.and(predicate2), x);

        System.out.println("The numbers Greater than 10 OR Even numbers are: ");
        m1(predicate1.or(predicate2), x);


        String[] names = {"Sunny", "Kajol", "Mallika", "Katrina", "Kareena"};
        System.out.println("After this block :: ");
        Predicate<String> startsWithK = s->s.charAt(0) == 'K';
        for (String str: names) {
            if(startsWithK.test(str)) {
                System.out.println(str);
            }
        }

        String[] strNames = {"Sunny", "", "Mallika", "Katrina", "Kareena", null};
        Predicate<String> containsNullOrEmptyString = s->s!=null && s.length()!=0;
        for (String str: strNames) {
            if(containsNullOrEmptyString.test(str)) {
                System.out.println("here we are ::" + str);
            }
        }
    }


    public static void m1(Predicate<Integer> p, int[] x) {
        for (int x1 : x) {
            if(p.test(x1)) {
                System.out.println(x1);
            }
        }
    }
}
