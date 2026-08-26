package java_oca;


// Output: Compilation fails only at n2


public class Ques176 {
    public static void main(String[] args) {
        int ans = 4;
        try {
            int num = 10;
            int div = 0;
            ans = num / div;
        } catch (ArithmeticException ae) {
            ans = 0;                                // line n1
        } catch (Exception e) {
            System.out.println("Invalid calculation");
        }

        System.out.println("Answer is :: " + ans);   // line n2
    }
}
