package interview_ques.productbased.mastercard;


public class MasterCardInterviewQuestion3 {
    public static void main(String[] args) {

        String[] str = {"aab", "aac", "aad", "aaz", "aaz"};
        String firstTwoLetters = str[0].substring(0, 2);
        System.out.println(checkFirstTwoLettersAreSame(str, firstTwoLetters));
    }

    private static boolean checkFirstTwoLettersAreSame(String[] str, String firstTwoLetters) {
        boolean allSame = true;
        for(String st : str) {
            if(!st.contains(firstTwoLetters)) {
                allSame = false;
                break;
            }
        }
        return allSame;
    }
}
