package multithreading.threading;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelismExample {
    public static void main(String[] args) {

        List<String> namesList = Arrays.asList("Bob", "Jamie", "Jill", "Rick");
        List<String> namesListUpperCase = namesList
                .parallelStream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("namesListUpperCase : " +namesListUpperCase);
        // namesListUpperCase : [BOB, JAMIE, JILL, RICK]



    }
}
