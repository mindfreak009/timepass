package interview;

// ram is a good person though he does not like shyam as he works in different project
// different

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// interchange 'r' with 'o' and vice versa if you encounter r and o in same word and replace 'f' with 't' and vice versa
// if you encounter f and t
public class Interview99 {
    public static void main(String[] args) {
        String s = "ram is a good person though he does not like shyam as he works in different project";
        System.out.println(replaceCharacters(s));
    }

    public static String replaceCharacters(String str) {

        StringBuilder sb = new StringBuilder(str);
        List<Character> list = List.of('r', 'o', 'f', 't');
        //StringBuilder sb = new StringBuilder();
        String[] splitt = str.split(" ");
        System.out.println(splitt[0]);


        for (int i = 0; i < splitt.length; i++) {
            boolean containsRO = splitt[i].contains("r") &&  splitt[i].contains("o");
            boolean containsFT = splitt[i].contains("f") &&  splitt[i].contains("t");

            char ch = str.charAt(i);
            int j = splitt[i].length()-1;

            if(ch == 'r'  && str.charAt(j) == 'o' ||  ch == 'o' && str.charAt(j) == 'r' && i!=j)  {
                swapCharacters(ch, str.charAt(j), splitt[i]);
                j--;
            } else if(ch == 't' && str.charAt(j) == 'f' ||  ch == 'f' && str.charAt(j) == 't' && i!=j){
                swapCharacters(ch, str.charAt(j), splitt[i]);
                j--;
            }

        }
        return sb.toString();
    }

    public static String swapCharacters(char c, char d, String str) {
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char temp = c;
            c = d;
            d = temp;
        }
        return Arrays.toString(ch);
    }
}
