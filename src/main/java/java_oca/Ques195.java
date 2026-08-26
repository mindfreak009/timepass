package java_oca;

// Output:  Compile time error occurs

public class Ques195 {
    public static void main(String[] args) {
        int sum = 0;
        for (int xVal = 1; xVal <=5 ; xVal++) {
            sum += xVal;
        }

       // System.out.println("The sum of " + xVal + " numbers is : " +sum);    // Compile time error occurs
    }
}
