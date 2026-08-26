package streams_hidden_features;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


// Stream.ofNullable feature was introduced in Java 9.

public class StreamOfNullable {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "basant", null, "dell", "lenovo", null);

        List<String> collect = list.stream()
                .filter(Objects::nonNull)
                // .filter(i -> i != null)
                .collect(Collectors.toList());  // can be replaced with "toList()";
        System.out.println("list without null values :: " + collect);
        System.out.println("========================================================================");

        // we are not using map() function,  because it would return List<Stream<String>> as output
        List<String> collect1 = list.stream()
                .flatMap(Stream::ofNullable)
                .collect(Collectors.toList());
        System.out.println("list without null values :: " +collect1);
    }
}
