package java_oca;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


// Which action enables to print AB ?

public class Ques182 {
    public static void main(String[] args) {
        List<String> lst = Arrays.asList("A", "B", "C", "D");
        Iterator<String> itr = lst.iterator();
        while (itr.hasNext()) {
            String e = itr.next();
            if (e == "C") {
                break;
            } else {
                // continue;             // Commenting this line, helps to print AB
               System.out.print(e);
            }
        }
    }
}
