package interview_ques.mastercard;

// Expected output: 3a3b3c2d7a6b
public class MasterCardInterviewQuestion {
    public static void main(String[] args) {
        String input = "aaabbbcccddaaaaaaabbbbbbb";

        char ch1 = input.charAt(0);
        int count = 1;

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < input.length(); i++) {
            char ch2 = input.charAt(i);
            if(ch1 != ch2) {
                sb.append(count).append(ch1);
                count = 1;
                ch1 = ch2;
            } else {
                count++;
            }
        }
        // Append the count and last character
        sb.append(count).append(ch1);
        System.out.println(sb);
    }
}
