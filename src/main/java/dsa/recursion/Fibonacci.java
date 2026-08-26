package dsa.recursion;

public class Fibonacci {
    public static void main(String[] args) {
        int num = 12;
        System.out.println(fibonacci(num));
        fib(num);

    }

    private static int fibonacci(int num) {

        if(num == 0 || num == 1)
            return 1;

        int num1 = fibonacci(num - 1);
        int num2 = fibonacci(num - 2);

        return  num1 + num2;
    }

    private static int fib(int num) {
        int prev = 0;
        int next = 1;
        int total = prev + next;

        for (int i = 2; i <= num; i++) {
            prev = next;
            next = total;
            total = prev + next;
        }
        System.out.println("fib :: " +total);
        return total;
    }
}
