package interview_ques;

// For example, if n = 7, then the program should output 1 2 2 3 3 3 4.
// Sample Input 1: 7
// Sample Output 1:  1 2 2 3 3 3 4

import java.util.Scanner;

public class SequnceOfNumbersBasedOnUserInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your number :");
        int totalNum = sc.nextInt();


        int counter = 0;
       // boolean shouldBreak = false;

        for(int i = 1; i <= totalNum; i++){
            for(int j = 1; j <= i; j++){
                if(counter == totalNum){
                    //shouldBreak = true;
                    break;
                }
                counter++;
                System.out.print(i + " ");
            }
//            if(shouldBreak){
//                break;
//            }
        }
    }
}
