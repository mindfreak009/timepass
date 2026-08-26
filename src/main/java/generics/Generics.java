package generics;


import io.swagger.models.auth.In;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

class Displayer<T> {
    T num;

//    public Displayer(T num) {
//        this.num = num;
//    }

    public void setNum(T num) {
        this.num = num;
    }

    public void display() {
        System.out.println("element -> " +this.num);
    }
}



public class Generics {
    public static void main(String[] args) {
        Displayer<Integer> d1 = new Displayer<>();
        d1.setNum(10);
        d1.display();

        Displayer<Double> d2 = new Displayer<>();
        d2.setNum(9.87);
        d2.display();






        // ================================================================================
        // First non-repeat character in string
        String str = "ilovejavatechie";

       // Character key = str.chars()
       //         .mapToObj(s -> (char) s)
        String key = Arrays.stream(str.split(""))
                    .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                    .entrySet()
                    .stream()
                    .filter(i -> i.getValue() == 1)
                    //.map(Map.Entry::getKey)
                    .findFirst()
                    .get()
                    .getKey();

        System.out.println(key);



        //Arrays.stream(num.split(""))


    }
}
