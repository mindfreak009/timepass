package interview_ques;

public class PerfectTriangle {
    public static void main(String[] args) {
        int rows = 10; // Number of rows in the triangle

        // Outer loop to iterate over rows
        for (int i = 1; i <= rows; i++) {
            // Inner loop to print spaces
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            // Inner loop to print numbers
            int num = i;
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }
            // Move to the next line after each row
            System.out.println();
        }
    }
}
