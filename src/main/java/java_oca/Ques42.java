package java_oca;

// You must ensure that the maskcc method returns a string that hides all digits of the credit card number except the
// four last digits (and the hyphens that separate each group of four digits).

// Which two code fragments should you use at line n1, independently, to achieve this :


public class Ques42 {
    public static void main(String[] args) {
        System.out.println(maskCC("1234-5678-9101-1121"));
    }

    public static String maskCC(String creditCard) {
        String x = "XXXX-XXXX-XXXX-";
        // line n1
        // Code that can be entered

        // 1.  (Wrong option)   // Output: XXXX-XXXX-XXXX-1234-5678-9101-1121
        // StringBuilder sb = new StringBuilder(creditCard);
        // sb.substring(15,19);
        // return x + sb;

        // 2. (Right Option)  Output:  XXXX-XXXX-XXXX-1121
         StringBuilder sb1 = new StringBuilder(x);
         sb1.append(creditCard, 15,19);
         // return sb1.toString();

        // 3. (Right option)   // Output:  XXXX-XXXX-XXXX-1121
         return x + creditCard.substring(15,19);

        // 4.  (Wrong option)   // Output: XXXX-XXXX-XXXX-1234-5678-9101-1121
        // StringBuilder sb2 = new StringBuilder(creditCard);
        // StringBuilder s = sb2.insert(0, x);
        // return s.toString();

    }
}
