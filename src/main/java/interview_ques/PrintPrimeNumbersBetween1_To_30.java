package interview_ques;

import java.util.ArrayList;
import java.util.List;

public class PrintPrimeNumbersBetween1_To_30 {
    public static void main(String[] args) {
        int start = 1;
        int end = 30;
        List<Integer> res = printPrimenumbers(start, end);
        System.out.println(res);
    }

    private static List<Integer> printPrimenumbers(int start, int end) {
        List<Integer> primeNumbersList = new ArrayList<>();

        if(start == 1)
            start = start +1;

        for (int i = start; i <= end; i++) {
            int count = 0;

            for (int j = 2; j*j <= i ; j++) {
                if(i%j == 0) {
                    count++;
                    break;
                }
            }

            if(count == 0) {
                primeNumbersList.add(i);
            }

        }
//        for (int i = start+1; i*i <= end; i++) {
//            for (int j = 2*i; j <=end ; j=j+i) {
//                //isPrime[j] = false;
//            }
//        }
        return primeNumbersList;
    }
}
