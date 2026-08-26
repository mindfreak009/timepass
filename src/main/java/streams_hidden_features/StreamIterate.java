package streams_hidden_features;

import java.util.stream.Stream;

public class StreamIterate {
    public static void main(String[] args) {
        int j = 1;
        Stream.iterate(3, i -> i*j)
                .limit(10)
                .forEach(System.out::println);
    }
}
