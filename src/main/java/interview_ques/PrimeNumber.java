package interview_ques;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Find prime numbers using Sieve of Erasthonesis
// Time complexity: O(N)

public class PrimeNumber {
    public static void main(String[] args) {
        boolean[] isPrime = sieveOfEratosthenes(20);
        for (int i = 0; i < isPrime.length; i++) {
            // Printing only Prime Numbers
            if(isPrime[i])
              System.out.println( i + " " + isPrime[i]);
        }
    }

    static boolean[] sieveOfEratosthenes(int n) {
        boolean isPrime[] = new boolean[n+1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
       // isPrime[1] = false;

        for (int i = 2; i*i <=n; i++) {
            for (int j = 2*i; j <=n ; j=j+i) {
                isPrime[j] = false;
            }
        }
        return isPrime;
    }

}
