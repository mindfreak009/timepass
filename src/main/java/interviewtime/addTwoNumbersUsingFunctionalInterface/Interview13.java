package interviewtime.addTwoNumbersUsingFunctionalInterface;

public class Interview13 {
    public static void main(String[] args) {
        ReturnOneElement r = (a, b) -> a+b;

        // Call the add method using the lambda expression
        int result = r.addTwoNumbers(10, 15);

        System.out.println(result);
    }
}
