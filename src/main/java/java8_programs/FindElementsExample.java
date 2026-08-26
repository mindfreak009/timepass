package java8_programs;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindElementsExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,2,1);

        // findFirst() and findAny() methods
        Optional<Integer> integerList = list.stream().findFirst();
        if(integerList.isPresent()) {
            System.out.println(integerList.get());
        } else {
            System.out.println("Stream is empty");
        }

        Optional<Integer> element = list.stream().findAny();
        if(element.isPresent()) {
            System.out.println(element.get());
        } else {
            System.out.println("Stream is empty");
        }


    }
}
