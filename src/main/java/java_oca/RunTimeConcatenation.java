package java_oca;

// When you do (Variable + String) Compile-Time Concatenation, it will return TRUE, in case of Memory Location comparison

import java.util.ArrayList;
import java.util.List;

public class RunTimeConcatenation {
    public static void main(String[] args) {
        String a = "abcd";
        String b = "abcd123";
        String c = a + 123;
        System.out.println(b == c);

//        List<String> list = new ArrayList<>();
//        list.add("A");
//        list.add("B");
//        list.add("C");
//        list.add("D");
//        list.add("A");
//
//        if(list.remove("A")) list.remove("B");
//        System.out.println(list);
    }
}
