package ancestry_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CollectionWithLambda {

    public static void main(String[] args) {
        List<Integer> al = new ArrayList<Integer>();
        al.add(205);
        al.add(102);
        al.add(98);
        al.add(275);
        al.add(203);
        System.out.println("Elements of the ArrayList " +
                "before sorting : " + al);

        // Collections.sort(al, (a1,a2) -> (a1 > a2) ? -1 : (a1 < a2) ?1 : 0);
        Collections.sort(al, (a1,a2) -> (a2-a1));
        System.out.println("Elements of the ArrayList after" +
                " sorting : " + al);
    }
}
