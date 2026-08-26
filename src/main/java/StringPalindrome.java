public class StringPalindrome {

    public static void main(String[] args) {

        Integer nineA = new Integer(9);
        Integer nineB = new Integer(9);

        System.out.println("== operator :: " + (nineA == nineB));
        System.out.println("equals() :: " +nineA.equals(nineB));


        // APPROACH 1: Palindrome program
        String myString = "madam";
        StringBuffer buffer = new StringBuffer(myString);
        String reverseStr = buffer.reverse().toString();

        if(myString.equals(reverseStr)) {
            System.out.println("String is PALINDROME");
        } else {
            System.out.println("String is NOT an PALINDROME");
        }

        // APPROACH 2: Palindrome program
        String stringg = "madam";
        String reverseString = "";
        for (int i=stringg.length() -1; i>=0; i--) {
            reverseString = reverseString + stringg.charAt(i);
        }
        if (stringg.equals(reverseString)) {
            System.out.println("IT IS PALINDROME");
        }


        // Using lambda expression - count occurence of character in a String
        String str = "My name is Anthony Gonsalves";
        long count = str.chars().filter(ch -> ch == 'n').count();
        System.out.println("count :: " +count);

        int countChar = 0;
        for (int i=0; i<str.length(); i++) {
            char c = str.toLowerCase().charAt(i);
            System.out.println("char :: " +c);
            if(c == 'm') {
                countChar++;
            }
        }
        System.out.println("countChar :::" + countChar);
    }
}
