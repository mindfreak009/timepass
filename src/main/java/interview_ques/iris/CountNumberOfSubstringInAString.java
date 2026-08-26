package interview_ques.iris;

public class CountNumberOfSubstringInAString {
    public static void main(String[] args) {
        // Expected output : 3
        String s1 = "hellohellohelloel";
        String s2 = "el";

        int count = 0;
        int j = 1;

        for(int i=0; i<s1.length()-1; i++) {
            if(s1.charAt(i) == 'e' && s1.charAt(j)=='l'){
                j++;
                count++;
            } else {
                j++;
            }
        }
        System.out.println(count);

        System.out.println(s1.split(s2, -1).length-1);
    }
}
