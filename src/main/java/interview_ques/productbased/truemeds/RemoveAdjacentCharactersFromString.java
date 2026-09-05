package interview_ques.productbased.truemeds;

import java.util.LinkedHashSet;
import java.util.Set;

// Output : bxe
public class RemoveAdjacentCharactersFromString {
    public static void main(String[] args) {
        String input = "bxd  daaccce";
        System.out.println(removeAdjacentCharactersFromString(input));
    }

    private static String removeAdjacentCharactersFromString(String str) {
        StringBuilder sb = new StringBuilder();
        int j = 1;

        // set to hold unique characters
        Set<Character> set = new LinkedHashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(!Character.isWhitespace(c) && str.charAt(i) != str.charAt(j)){
                if(!set.contains(c)) {
                    set.add(c);
                } else {
                    set.remove(c);
                }
                j++;
            } else {
                set.remove(c);
            }
        }
        sb.append(set);
        return sb.toString();
    }
}
