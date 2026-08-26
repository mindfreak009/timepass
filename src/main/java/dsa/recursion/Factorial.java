package dsa.recursion;

public class Factorial {
    public static void main(String[] args) {
        int num = 5;
        System.out.println(factorialNum(num));
        System.out.println(factorialIterativeApproach(num));
    }

    private static int factorialNum(int num) {

        if(num == 1)
            return 1;

        int temp = factorialNum(num - 1);
         return  num * temp;

    }

    // Better performance
    public static int factorialIterativeApproach(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
