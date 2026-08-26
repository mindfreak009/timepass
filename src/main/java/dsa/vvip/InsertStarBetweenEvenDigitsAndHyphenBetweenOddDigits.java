package dsa.vvip;

//  Ex1: Input: "98234925928"
//  Output: 98*234925-92*8

//  Ex2: Input: "2397492834092"
//  Output: 23-9-7492*834092

// String Manipulation: Insert a '*' between consecutive even digits
//                      and    a '-' between consecutive odd digits.

public class InsertStarBetweenEvenDigitsAndHyphenBetweenOddDigits {
    public static void main(String[] args) {
        String num = "98234925928";

        System.out.println(insertStarAndHyphen(num));
        System.out.println(insertStarAndHyphen2(num));
    }

    private static String insertStarAndHyphen(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length()-1; i++) {
            int first = Integer.parseInt(String.valueOf(str.charAt(i)));
            int second = Integer.parseInt(String.valueOf(str.charAt(i+1)));

            if(first % 2 == 0 && second % 2 == 0) {
                sb.append(first).append("*");
            } else if(first%2 !=0 && second%2 !=0) {
                sb.append(first).append("-");
            } else {
                sb.append(first);
            }
        }
        // Append the last character since it doesn't have a "next" character
        sb.append(str.charAt(str.length() - 1));

        return sb.toString();
    }

    private static String insertStarAndHyphen2(String num) {
        StringBuilder sb = new StringBuilder();

        // Loop through the number string to compare each digit with the next one
        for (int i = 0; i < num.length() - 1; i++) {
            int first = Integer.parseInt(String.valueOf(num.charAt(i)));
            int second = Integer.parseInt(String.valueOf(num.charAt(i + 1)));

            // If both numbers are even, insert a star
            if (first % 2 == 0 && second % 2 == 0) {
                sb.append(first).append("*");
            }
            // If both numbers are odd, insert a hyphen
            else if (first % 2 != 0 && second % 2 != 0) {
                sb.append(first).append("-");
            }
            // If one is even and the other is odd, append the number without a symbol
            else {
                sb.append(first);
            }
        }

        // Append the last character since it doesn't have a "next" character
        sb.append(num.charAt(num.length() - 1));

        return sb.toString();
    }
}
