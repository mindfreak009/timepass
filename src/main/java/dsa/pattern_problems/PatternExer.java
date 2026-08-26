package dsa.pattern_problems;

import java.util.ArrayList;
import java.util.List;

// Input: "I Am Not String"
// Output: "gnirtS toN mA I"

public class PatternExer {
    public static void main(String[] args) {
        String str = "I Am Not String";
        System.out.println("str.len :: " + str.length());
        // output: g ni rtS toNmAI

        printAnswer(str);
    }

    private static void printAnswer(String str) {
        StringBuilder sb = new StringBuilder();

        // To find the spaces index:
//        List<Integer> spacesIndex = new ArrayList<>();
//        for (int i = 0; i < str.length(); i++) {
//            char c = str.charAt(i);
//            if(c == ' '){
//                spacesIndex.add(i);
//            }
//        }
//        System.out.println(spacesIndex);

        for (int i = str.length()-1; i >=0 ; i--) {
//            if(i == spacesIndex.get(i)) {
//                sb.append(" ");
//            }
            sb.append(str.charAt(i));
        }
        System.out.println(sb.toString());
    }
}
