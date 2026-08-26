package interview_ques.proofpoint;

//   abcdef == (abc + def)^2
//   Example: 998001 == (998 + 001)^2

import java.util.ArrayList;
import java.util.List;

public class PrintAllSixDigitNumsWhereSumOfFirst3DigitAndLast3DigitSquaredEqualTo6DigitNumberItself {
    public static void main(String[] args) {
        int startNumber = 100000;
        int endNumber = 999999;
        List<Integer> listOfNumbers = new ArrayList<>() ;

        for(int i=startNumber; i < endNumber; i++){

            /* Converting int to String  */
            // String numberStr = String.valueOf(i);
            // String numberStr = Integer.toString(i);
            String numberStr = i + "";

            // substring '2nd parameter' is exclusive
            int firstThreeNumbers= Integer.parseInt(numberStr.substring(0,3));
            int secondThreeNumbers = Integer.parseInt(numberStr.substring(3,6));

            int calculatedNumber = firstThreeNumbers + secondThreeNumbers;
            if(Math.pow(calculatedNumber,2)==i){
                listOfNumbers.add(i);
            }
        }
        System.out.println(listOfNumbers);
    }
}
