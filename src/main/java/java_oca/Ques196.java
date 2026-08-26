package java_oca;

import java.util.ArrayList;
import java.util.List;


// Output:  [JavaGroup, ExpertGroup]

public class Ques196 {
    public static void main(String[] args) {
        List<String> arrList = new ArrayList<>();
        arrList.add("Tech");
        arrList.add("Expert");
        arrList.set(0, "Java");
        arrList.forEach(a -> a.concat("Forum"));    // Result of this operation is ignored
        arrList.replaceAll(s -> s.concat("Group"));

        System.out.println(arrList);

    }
}
