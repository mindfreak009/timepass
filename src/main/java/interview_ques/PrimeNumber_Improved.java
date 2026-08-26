package interview_ques;
import java.util.Scanner;


// Find prime numbers
// Time complexity: O(N)

public class PrimeNumber_Improved {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the starting range number: ");
        int low = scan.nextInt();

        System.out.println("Enter the ending range number: ");
        int high = scan.nextInt();

        // Sieve of Erasthones approach
        for (int i = low; i <=high ; i++) {
            int count = 0;

            // try to divide i and increase count
            for (int j = 2; j*j <= i ; j++) {
                if(i%j == 0) {
                    count++;
                    break;
                }
            }

            // try to divide i and increase count
            if(count == 0) {
                System.out.print(i + " ");

            }
        }
    }
}
