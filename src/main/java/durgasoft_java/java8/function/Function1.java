package durgasoft_java.java8.function;

import java.util.function.Function;

public class Function1 {
    public static void main(String[] args) {
//            Function<Integer, String> func1 = (n) -> {
//                if(n%2==0) return "EVEN";
//                return "ODD";
//            };
//            System.out.println(func1.apply(5));

        // Passing Custom Object in the Function
        Student st = new Student("Rahul");
        Function<Student, String> func2 = (n) -> {
            if(n.getName().length()%2==0) return "EVEN";
            return "ODD";
        };
        System.out.println(func2.apply(st));
    }
}
