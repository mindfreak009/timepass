package interview_ques.productbased.paypal;

// Input:  256
// Output : 4
// 256 => 13 => 4

public class AddAllDigitsOfNumbersToSingleDigit {
    public static void main(String[] args) {
        //String num = "25118";
        String num = "10";
        int singleNum = 0;

        for (int i = 0; i < num.length() ; i++) {
            singleNum+= Integer.parseInt(String.valueOf(num.charAt(i)));

            if(singleNum > 9) {
                singleNum = 1 + (singleNum-1)%9;
            }
        }
        System.out.println(singleNum);
        //System.out.println(singleNum + 100);
    }
}
