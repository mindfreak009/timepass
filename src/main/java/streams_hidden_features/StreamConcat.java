package streams_hidden_features;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamConcat {
    public static void main(String[] args) {
        // List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);

        Stream<Integer> firstStreaa =  Stream.of(1,2,3,4);
        Stream<Integer> secondStream = Stream.of(5, 6, 7, 8);
        Stream<Integer> concatStream = Stream.concat(firstStreaa, secondStream);
        Integer[] array = concatStream.toArray(Integer[]::new);

       // int sum = concatStream.mapToInt(Integer::intValue).sum();
       // System.out.println("sum :: " + sum);
        System.out.println(Arrays.toString(array));
    }
}
