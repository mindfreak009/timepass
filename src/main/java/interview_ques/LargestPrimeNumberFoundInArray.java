package interview_ques;

// Implement a Java method that takes an integer array and returns the largest prime number found in the array.
//  If there is no prime number, return -1

public class LargestPrimeNumberFoundInArray {
    public static void main(String[] args) {


       // System.out.println(Math.sqrt(5));
       // System.out.println("=========================================");
        int[] arr = {1, 6, 17, 61, 5, 0, 2};
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(Math.sqrt(arr[i]));
//        }
        System.out.println("========================================");
        System.out.println("Largest PrimeNumber  ::: " +findLargestPrimeNumberFoundInArray(arr));
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int findLargestPrimeNumberFoundInArray(int[] arr) {
        int largestPrimeNum = -1;
       for(int num : arr) {
           if(isPrime(num) && num > largestPrimeNum) {
               largestPrimeNum = num;
           }
       }
       return largestPrimeNum;
    }
}
