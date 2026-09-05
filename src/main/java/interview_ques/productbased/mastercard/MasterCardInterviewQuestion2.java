package interview_ques.productbased.mastercard;

// Expected output - aaabbbccccdd

public class MasterCardInterviewQuestion2 {
    public static void main(String[] args) {
        String input = "3a3b4c2d5e";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length() -1 ; i=i+2) {
            char ch1 = input.charAt(i);
            char ch2 = input.charAt(i+1);

            int count = Character.getNumericValue(ch1);
            while(count > 0){
                sb.append(ch2);
                count--;
            }
        }
        System.out.println(sb);
    }
}
