package interview_ques.cg;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CheckPalindromeAndReturnTrueIfItCanBeMadePalindrome {
    public static void main(String[] args) {

        String str = "abadaba";
        // String str = "abadaba";
        System.out.println("checkIfPalindrome :: " + checkIfPalindrome(str));

        String s = "HappynewYear";
        Map<Character, Long> collect = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Character> collect1 = s.chars()
                .mapToObj(c -> (char) c)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect1);

        collect.entrySet()
                .stream()
                .filter(i -> i.getValue() < 1 || i.getValue() == 1)
                .map(Map.Entry::getKey)
                .forEach(i ->System.out.print(i + " "));
    }

    private static boolean checkIfPalindrome(String str) {

        boolean b = false;
        for (int i = 0; i < str.length()/2; i++) {
            char c = str.charAt(i);
            if(c == str.charAt(str.length()-1-i)) {
                b =  true;
            } else {
                b = false;
            }
        }

        if (!b) {
            checkIfStringCanBeMadePalindrome(str);
        }
        return b;
    }

    private static boolean checkIfStringCanBeMadePalindrome(String originalStr) {
        return false;

    }
}
