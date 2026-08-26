package interview_ques;

public class ReturnVowelsFromName {
    public static void main(String[] args) {
        String str = "Prakash Pangeni";
        System.out.println(findVowelsFromName(str));
    }

    private static String findVowelsFromName(String str) {

        StringBuilder vowels = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') {
                vowels.append(c);
                vowels.append(" ");
            }
        }
        return vowels.toString();
    }
}
