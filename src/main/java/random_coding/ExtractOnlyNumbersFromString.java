package random_coding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractOnlyNumbersFromString {
    public static void main(String[] args) {
        String str1 = "12ABC45XY";
        String str2 = "23XY59";

       String st = str1.replaceAll("\\D+", "");
       // str1 = str1.replaceAll("\\D+","");
       // System.out.println("st :: " +str1);
        System.out.println("st :: " +st);

        String numbersFromStr1 = extractNumbers(str1);
        String numbersFromStr2 = extractNumbers(str2);

        System.out.println("Numbers from str1: " + numbersFromStr1);
        System.out.println("Numbers from str2: " + numbersFromStr2);

        System.out.println(extractOnlyNumbers(str2));
    }

    public static String extractNumbers(String input) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);

        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            result.append(matcher.group());
        }

        return result.toString();
    }

    public static String extractOnlyNumbers(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
           char ch = str.charAt(i);

           // getting the ascii value of the primitive numbers
           if( ch >= 49  && ch <= 57) {
               sb.append(ch);
               sb.append(" ");
           }
        }
        return sb.toString();
    }
}
