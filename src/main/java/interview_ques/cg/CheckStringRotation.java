package interview_ques.cg;

public class CheckStringRotation {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "cdab";
        String s3 = "ABAD";
        String s4 = "ADAB";
        String s5 = "ABCD";
        String s6 = "ACBD";

        System.out.println(checkStringRotation(s1, s2));
        System.out.println(checkStringRotation(s3, s4));
        System.out.println(checkStringRotation(s5, s6));
    }

    private static boolean checkStringRotation(String s1, String s2) {

        if(s1.length() != s2.length()) {
            return false;
        }
        String doubled = s1+s1;
        if (doubled.contains(s2)){
            return true;
        }
        return false;
    }
}
