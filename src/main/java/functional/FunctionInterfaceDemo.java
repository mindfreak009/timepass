package functional;

import java.util.function.Function;

class FunctionImpl implements Function<String, Integer> {

    @Override
    public Integer apply(String s) {
        return s.length();
    }
}

public class FunctionInterfaceDemo {
    public static void main(String[] args) {
        Function<String, Integer> functionProgram = (s) -> s.length();
        System.out.println(functionProgram.apply("Prakash"));

    }
}
