package random_coding;

import java.util.HashSet;
import java.util.Set;

public class CommonNumberSum {
    public static void main(String[] args) {
        String str1 = "12ABC45XY";
        String str2 = "23XY59";

        Set<Integer> commonNumbers = findCommonNumbers(str1, str2);

        int sum = commonNumbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Common numbers: " + commonNumbers);
        System.out.println("Sum of common numbers: " + sum);
    }

    private static Set<Integer> findCommonNumbers(String str1, String str2) {
        Set<Integer> numbers1 = extractNumbers(str1);
        Set<Integer> numbers2 = extractNumbers(str2);

        numbers1.retainAll(numbers2); // Find the common numbers
        System.out.println("numbers1 :::" +numbers1);
        return numbers1;
    }

    private static Set<Integer> extractNumbers(String str) {
        Set<Integer> numbers = new HashSet<>();
        StringBuilder currentNumber = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNumber.append(c);
            } else if (currentNumber.length() > 0) {
                numbers.add(Integer.parseInt(currentNumber.toString()));
                currentNumber.setLength(0); // Clear the currentNumber buffer
            }
        }

        if (currentNumber.length() > 0) {
            numbers.add(Integer.parseInt(currentNumber.toString())); // Handle the last number
        }

        System.out.println(numbers);
        return numbers;
    }
}