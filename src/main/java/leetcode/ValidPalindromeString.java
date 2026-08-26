package leetcode;

public class ValidPalindromeString {
    public static void main(String[] args) {
        // String str = "@!Geeks-for'Geeks, 123";
        String str = "A man, a plan, a canal: Panama";
        str = str.replaceAll("[^a-zA-Z0-9]", "");

        boolean b = false;
        String newStr = "";
        System.out.println("in second line");
        for (int i = str.length() -1; i >=0 ; i--) {
            char c = str.charAt(i);
            newStr = newStr + c;

        }

        if(str.equalsIgnoreCase(newStr)) {
            b = true;
            System.out.println("here ::: " +b);
        }


    }
}
