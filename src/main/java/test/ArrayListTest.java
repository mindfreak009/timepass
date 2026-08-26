package test;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(50);
        list.add(60);
        System.out.println(list);  // Output: [10, 20, 30, 50, 60]

        list.removeLast();
        System.out.println(list);  // Output: [10, 20, 30, 50]

        list.removeFirst();
        System.out.println(list);  // Output: [20, 30, 50]


    }
}
