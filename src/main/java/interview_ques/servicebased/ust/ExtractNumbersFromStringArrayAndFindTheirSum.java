package interview_ques.servicebased.ust;

import java.util.Arrays;

public class ExtractNumbersFromStringArrayAndFindTheirSum {

    public static void main(String[] args) {

        String[] input = {"SRini@123", "#Moksha@0104", "0401@Jambi", "Sairam@04#01$21", "Admin@1111"};
        int sum = Arrays.stream(input) // Create a stream from the array
                .flatMapToInt(str ->
                        str.chars() // Get the character stream of each string
                                .filter(Character::isDigit) // Filter only digit characters
                                .map(Character::getNumericValue)) // Convert characters to their integer values
                .sum(); // Sum up all the integers
        System.out.println("sum :: " +sum);
    }
}

//        Arrays.stream(input)
//                .filter(i -> (i>=0 || i<=9)) ;



//            for (int j = 0; j < str.length(); j++) {
//                int c = (int) str.charAt(i);
//                System.out.println("c :: " +c);
//                if (c <= 49 && c >= 58) {
//                    sum += c;
//                }
//            }


//    int summ = 0;
//        for (int i = 0; i < input.length; i++) {
//        String str = input[i];
//        String stringNow = str.replaceAll("[^0-9]", "");
//
//        summ+= Integer.parseInt(stringNow);
//        System.out.println(summ);


