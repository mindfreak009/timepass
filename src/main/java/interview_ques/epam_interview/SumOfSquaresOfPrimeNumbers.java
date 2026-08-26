package interview_ques.epam_interview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SumOfSquaresOfPrimeNumbers {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        int start = arr.get(0);
        int end = arr.get(arr.size()-1); // Change the range as needed
        int sum = sumOfSquareOfPrimes(start, end);

        System.out.println("Sum of squares of prime numbers between " + start + " and " + end + " :: " + sum);

/*       Solution given to EPAM    */
//        List<Integer> result = arr.stream()
//                .filter(i -> (i % 2 == 0 || i % 3 == 0 || i % 5 == 0 || i % 7 == 0))
//                .map(i -> i * i)
//                .collect(Collectors.toList());
//        System.out.println(result);

    }

    // Method to check if a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        return IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(i -> number % i == 0);
    }

    // Method to find the sum of squares of prime numbers within a range
    public static int sumOfSquareOfPrimes(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(SumOfSquaresOfPrimeNumbers::isPrime)
                .map(n -> n * n)
                //.sum();
                .reduce(0, (a, b) -> a+b);
    }
}



/*       Solution given to EPAM    */

//        List<Integer> result = arr.stream()
//                .filter(i -> (i % 2 == 0 || i % 3 == 0 || i % 5 == 0 || i % 7 == 0))
//                .map(i -> i * i)
//                .collect(Collectors.toList());
//        System.out.println(result);