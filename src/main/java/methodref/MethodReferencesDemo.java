package methodref;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

interface Printable {
    void print(String msg);
}

public class MethodReferencesDemo {

    public static int addition(int a, int b) {
        return (a+b);
    }

    public void display(String msg) {
        msg = msg.toUpperCase();
        System.out.println(msg);
    }

    public static void main(String[] args) {
        // 1. Method reference to a static method
        // lambda expression
        Function<Integer, Double>  function = (input) -> Math.sqrt(input);
        System.out.println(function.apply(36));

        // using method reference
        Function<Integer, Double>  functionMethodRef = Math::sqrt;
        System.out.println(functionMethodRef.apply(64));

        // lambda expression
        BiFunction<Integer, Integer, Integer> biFunction = (a,b) -> MethodReferencesDemo.addition(a, b);
        System.out.println(biFunction.apply(10,20));

        // using method references
        BiFunction<Integer, Integer, Integer> biFunction2 = MethodReferencesDemo::addition;
        System.out.println(biFunction2.apply(50,100));


        // 2. Reference to an instance method of a particular object
        MethodReferencesDemo methodReferencesDemo = new MethodReferencesDemo();

        // lambda expression
        Printable printable = (msg) -> methodReferencesDemo.display(msg);
        printable.print("hello world");

        // using method reference
        Printable printableMethodRef = methodReferencesDemo::display;
        printable.print("hello world");


        //3. Reference to the instance method of an arbitary object
        // Sometimes, we call a method of argument in the lambda expression
        // In that case, we can use a method reference to call an instance method
        // of an arbitary object of a specific type.

        Function<String, String> stringFunction = (input) -> input.toLowerCase();
        System.out.println(stringFunction.apply("HELLO WORLD"));

        // using method reference
        Function<String, String> stringFunctionMethodRef = String::toLowerCase;
        System.out.println(stringFunctionMethodRef.apply("ALTIMETRIK"));

        String[] strArray = {"A", "E", "I", "O", "U", "a", "e", "i", "o", "u" };

        // using lambda
        Arrays.sort(strArray, (str1, str2) ->  str1.compareToIgnoreCase(str2));

        // using method reference
        Arrays.sort(strArray, String::compareToIgnoreCase);
        System.out.println();


        //4. Reference to a constructor
        List<String> stringList = new ArrayList<>();
        stringList.add("Banana");
        stringList.add("Apple");
        stringList.add("Watermelon");
        stringList.add("Pineapple");
        stringList.add("Mango");
        stringList.add("Jackfruit");

        Function<List<String>, Set<String>>  setFunction = (fruitsList) -> new HashSet<>(fruitsList);
        System.out.println(setFunction.apply(stringList));

        //using method reference
        Function<List<String>, Set<String>>  setFunctionMethodRef =  HashSet::new;
        System.out.println(setFunctionMethodRef.apply(stringList));
    }
}
