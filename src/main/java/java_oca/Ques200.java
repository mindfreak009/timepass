package java_oca;

import java.util.ArrayList;
import java.util.List;


// Output: -1

class Productz {
    int id;
    String name;

    public Productz(int id, String name) {
        this.id = id;
        this.name = name;
    }
}


public class Ques200 {
    public static void main(String[] args) {
        List<Productz> lst = new ArrayList<>();
        lst.add(new Productz(10, "IceCream"));
        lst.add(new Productz(11, "Chocolate"));

        Productz p1 = new Productz(10, "IceCream");
        System.out.println(lst.indexOf(p1));
    }
}
