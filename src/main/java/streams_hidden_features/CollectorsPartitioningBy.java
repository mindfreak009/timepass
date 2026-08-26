package streams_hidden_features;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsPartitioningBy {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3, 0, -1, 4,5,6, 16, 7,8,9);

        Map<Boolean, List<Integer>> map =
                numbers.stream()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0));

        System.out.println("even numbers :: " +map.get(Boolean.TRUE));
        System.out.println("odd numbers :: " +map.get(Boolean.FALSE));

       
    }
}
