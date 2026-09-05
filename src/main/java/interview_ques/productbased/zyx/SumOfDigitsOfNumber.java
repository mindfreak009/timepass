package interview_ques.productbased.zyx;

public class SumOfDigitsOfNumber {
    public static void main(String[] args) {
        int num = 73;
        int sum = 0;
        while(num !=0){
            int lastDigit = num%10;
            sum+= lastDigit;
            num = num/10;
        }
        System.out.println("Sum :: " +sum);
    }

}
