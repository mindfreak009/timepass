package interview_ques;

public class FindOutput {
    public static void main(String[] args) {
        String exp = "10*20/2*5/4*2";
        // String exp "10*20/2*5/4*2";

       // String exp = "10*20/2*5/4*2";
        try {
            double result = evaluateExpression(exp);
            System.out.println("The result of the expression " + exp + " is: " + result);
        } catch (Exception e) {
            System.out.println("Error evaluating expression: " + e.getMessage());
        }
    }

    public static double evaluateExpression(String expression) throws Exception {
        // Handle multiplication and division from left to right
        double result = 0;
        char operator = '*';
        String[] tokens = expression.split("(?<=\\D)");

        // Initial value is the first number
        result = Double.parseDouble(tokens[0].trim());

        for (int i = 1; i < tokens.length; i += 2) {
            operator = tokens[i].trim().charAt(0);
            double nextNumber = Double.parseDouble(tokens[i + 1].trim());

            switch (operator) {
                case '*':
                    result *= nextNumber;
                    break;
                case '/':
                    if (nextNumber == 0) {
                        throw new ArithmeticException("Division by zero.");
                    }
                    result /= nextNumber;
                    break;
                default:
                    throw new Exception("Unsupported operator: " + operator);
            }
        }

        return result;
    }
}

