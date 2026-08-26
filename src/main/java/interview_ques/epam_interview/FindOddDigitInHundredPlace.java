package interview_ques.epam_interview;

import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// Print the whole number if the number in the hundreds place is an ODD number.
// Else just discard the number
// The counting for the hundreds place should begin from LEFT to RIGHT.


// Constraints:
// 1. You cannot convert the number to String
// 2. You cannot convert the number to char

public class FindOddDigitInHundredPlace {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(3247, 8796, 431, 2395, 817, 41, 221222, 6453, 121);


        //List<Integer> oddDigitInHundredPlaceImproved = findOddDigitInHundredPlace_Improved(myList);

        for (Integer number : myList) {
            // To get the length of number
            int count = getLengthOfNumber(number);
            System.out.println("count :: " + count);

            // Perform the calculation
            List<Integer> finalResult = doCalculation(number, count);

            for (int i = 0; i < finalResult.size(); i++) {
                if(!finalResult.contains(0)) {
                    System.out.println(finalResult);
                }
            }
        }
    }

    private static List<Integer> doCalculation(Integer number, int count) {

        List<Integer> finalResult = new ArrayList<>();
        Stack<Integer> stack;

        int counter = count;
        int tempVar = number;

        for (int i = 0; i < counter; i++) {
            stack = new Stack<>();

            while(tempVar > 0) {
                    // Finding the remainder (Last Digit)
                    int remainder = tempVar % 10;
                    stack.push(remainder);

                    // Removing the last digit/current last digit
                     tempVar = tempVar / 10;
                     // Decreasing the count
                     counter--;
            }
            finalResult.add(findOddDigitInHundredPlace(stack, number, count));
        }

        return finalResult;
    }

    private static int findOddDigitInHundredPlace(Stack<Integer> stack, int originalNumber, int count) {

        // 3247, 8796, 431, 2395, 817, 41, 221222, 6453
       // System.out.println("stack :: " +stack);
        for (int i = 0; i < stack.size() ; i++) {
            if(count == 3) {
                if((stack.firstElement())%2 !=0) {
                    return originalNumber;
                }
            } else if(count > 3) {
                int internalCounter = 1;
                while(!stack.isEmpty()) {
                    stack.pop();
                    internalCounter++;

                    if(internalCounter == 3 && stack.pop()%2 !=0) {
                        return originalNumber;
                    }
                    count--;
                }
            }
        }
        return 0;
    }

    private static int getLengthOfNumber(int tempNumber) {
        int count = 1;
        while (tempNumber >= 10) {
            tempNumber = tempNumber / 10;
            count++;
        }
        return count;
    }
}