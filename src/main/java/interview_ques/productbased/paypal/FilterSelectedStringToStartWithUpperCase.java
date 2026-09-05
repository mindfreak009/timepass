package interview_ques.productbased.paypal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// filter string which start with a UpperCase
public class FilterSelectedStringToStartWithUpperCase {
    public static void main(String[] args) {

        // O/P HELLO, WORLD
        List<String> str  = Arrays.asList("hello", "world", "australia", "america");

        Map<String, Long> map = new HashMap<>();
        str.stream()
                .filter(i -> !i.startsWith("a"))
                .map(i -> i.toUpperCase())
                .forEach(System.out::println);



    }
}
