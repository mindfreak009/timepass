package test;

//	Input: 27061994 ==> 2 + 7 + 0 + 6 + 1 + 9 + 9 + 4 = 38
//            38 ==> 3 + 8 = 11
//            11 ==> 1 + 1 = 2.
//            Output: 2

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass {
    public static void main(String[] args) {
        // [1, 2, 3] ======> [1o, 2e, 3o]
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        List<String> collect = list
                .stream()
                .map(i -> (i%2==0) ? i+"e" : i+ "0" )
                .collect(Collectors.toList());

        System.out.println(collect);

        String num = "27061994";
        int total = Integer.parseInt(num);

         while(total >=9) {
             total = getTotal(String.valueOf(total));
         }

        System.out.println("total :: " +total);
    }

    public static int getTotal(String num) {
        int total = 0;
        for (int i=0; i<num.length(); i++) {
            int number = Integer.parseInt(String.valueOf(num.charAt(i)));
            total = total + number;
        }
        return total;
    }
}
