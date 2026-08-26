package java8_programs;

import java.util.*;
import java.util.stream.Collectors;
// Given a string {"Dell", "Lenovo", "HP"};
// Output :::  Dell, Lenovo, HP
public class ConvertStringArrayToSingleString {
    public static void main(String[] args) {
        String[] strArray = {"Dell", "Lenovo", "HP"};
        String str = Arrays.stream(strArray)
                .collect(Collectors.joining(", "));

        /* ALTERNATIVE WAY OF PREVIOUS LINE */
        // String str = String.join(", ", strArray);

        System.out.println("new string ::: " +str);
        System.out.println("==========================================================");


    }
}
