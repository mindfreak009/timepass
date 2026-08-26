package java_oca;

import java.util.function.Supplier;


// Which statement on line1 is calling the method of the supplier object correctly?

public class Ques190 {
    public static void main(String[] args) {
        Supplier supplier = () -> "Hello World";

        // line 1
        System.out.println(supplier.get());         // this line is calling the supplier object correctly
    }
}
