package dsa.maths;

public class DigitManipulation {
    public static void main(String[] args) {
        // findDigitsUsingFormula(1714);  // 4
       // findDigitsUsingFormula(1000);   // 4
        findDigitsUsingFormula(0000); // 1
    }

    public static void findDigitsUsingFormula(int num) {
        // workaround for negative numbers
        if(num<0) {
            num = -1 * num;
        }

        // this formula won't work for negative numbers
        int res = (int) Math.log10(num)+1;
        System.out.println("Number of digits : " +res) ;
    }
}
