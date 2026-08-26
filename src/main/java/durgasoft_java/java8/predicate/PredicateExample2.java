package durgasoft_java.java8.predicate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample2 {

    public static void main(String[] args) {
        Predicate<Collection> predicate = c -> c.isEmpty();

        List list1 = new ArrayList();
        list1.add("A");
        System.out.println(predicate.test(list1));


        List list2 = new ArrayList();
        System.out.println(predicate.test(list2));


    }


}
