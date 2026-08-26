package java_oca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Output:  HiHowAreYouRemoved


public class Ques153 {
    public static void main(String[] args) {
        String[] arr = {"Hi", "How", "Are", "You"};
        List<String> arrList = new ArrayList<>(Arrays.asList(arr));

        System.out.println(arrList.size());

        if(arrList.removeIf(s -> {
            System.out.print(s);
            return s.length() <= 2;
        }));

        System.out.println("Removed");

    }
}
