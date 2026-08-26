package streams_hidden_features;

import java.util.stream.IntStream;

public class IntStream_for_PrintingTableOf2 {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10)
                .map(i -> i*2)
                .forEach(res -> System.out.println("2 * " +res/2 + " = " + res));
    }
}
