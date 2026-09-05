package interview_ques.servicebased.iris;

public class AdditionOfAllNumbers {
    public static void main(String[] args) {
        // int i = 212;
        int i = 198769;
        System.out.println(additionOfAllDigits(i));
    }

    public static int additionOfAllDigits(int i) {
        // converting int to a String number.
        String str = Integer.toString(i);
        // variable addCount to store the final result
        int addCount = 0;
        for (int j = 0; j < str.length(); j++) {
            // check to only allow numeric numbers to be added.
            if(Character.isDigit(str.charAt(j))) {
                addCount+= Character.getNumericValue(str.charAt(j));
            }
        }
        return addCount;
    }
}
