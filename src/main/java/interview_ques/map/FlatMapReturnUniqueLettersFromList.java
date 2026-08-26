package interview_ques.map;

import java.util.Arrays;
import java.util.List;

public class FlatMapReturnUniqueLettersFromList {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("STACK","OOOVER");
        list.stream()
                .map(i -> i.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::print);
    }
}
