package interview_ques.productbased.mastercard;

// MasterCard Interview Question

// Output: aaabbbccccdd
public class ConvertNumberToAsManyCharacters {
    public static void main(String[] args) {
        String input = "3a3b4c2d";

        // FIRST APPROACH
        String decompressed = decompressString(input);
        System.out.println("decompressed :::: " + decompressed);

        // SECOND APPROACH
        String decompressString = convertNumsToItsEquivalentCharacters(input);
        System.out.println("Returned string :::: " + decompressString);

    }

    public static String convertNumsToItsEquivalentCharacters(String input) {
        StringBuilder sb = new StringBuilder();

        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                // Getting the exact value of number as it is.. Converting from char to num;
                count = input.charAt(i) - '0' ;
            } else {
                for (int j = 0; j < count; j++) {
                    sb.append(c);
                }
                count = 0;
            }
        }

        return sb.toString();
    }

    public static String decompressString(String input) {
        StringBuilder decompressed = new StringBuilder();
        int count = 0;

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                count = count * 10 + (c - '0');
                System.out.println("count here ::: " +count);
            } else {
                for (int i = 0; i < count; i++) {
                    decompressed.append(c);
                }
                count = 0;
            }
        }

        return decompressed.toString();
    }
}
