package java8_programs;

public class ReverseGivenStringInPlace {
    public static void main(String[] args) {
        String str = "Hello";
        System.out.println(reverseString(str));
    }

    public static String reverseString(String str) {
        // Convert string to a character array
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = str.length()-1;

        // Swap characters until the pointers meet in the middle
        while(left < right) {
            // Temporary variable to hold one character during the swap
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            // Move pointers toward the center
            left++;
            right--;
        }
       // return Arrays.toString(charArray);
        return new String(charArray);
    }
}
