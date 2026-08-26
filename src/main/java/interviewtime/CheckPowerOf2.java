package interviewtime;

// n=10
public class CheckPowerOf2 {
    public static void main(String[] args) {
        int n = 16;

        // Check if n is a power of 2
        // Optimised way :::
        if (n > 0 && (n & (n - 1)) == 0) {
            System.out.println(n + " is a power of 2");
        } else {
            System.out.println(n + " is NOT a power of 2");
        }

        int result = checkPowerOf2(n);
        if(result == 0) {
            System.out.println("Not a power of 2");
        } else {
            System.out.println("Power of 2");
        }

    }

    public static int checkPowerOf2(int num) {
        // Base case: If num is 1, it's a power of 2
        if (num == 1) {
            return 1; // It is a power of 2 (2^0)
        }

        // If num is less than 1 or odd, it is not a power of 2
        if (num <= 0 || num % 2 != 0) {
            return 0; // Not a power of 2
        }

        // Recursive step: Divide by 2 and check again
        return checkPowerOf2(num / 2);
    }
}
