package generics;

enum Operation {
    ADD, SUBTRACT, MULTIPLY, DIVIDE;

    public <T extends Number> double apply(T a, T b) {
        switch (this) {
            case ADD:
                return a.doubleValue() + b.doubleValue();
            case SUBTRACT:
                return a.doubleValue() - b.doubleValue();
            case MULTIPLY:
                return a.doubleValue() * b.doubleValue();
            case DIVIDE:
                return a.doubleValue() / b.doubleValue();
            default:
                throw new AssertionError("Unknown Operation :: " +this);
        }
    }
}

public class enumExample {
    public static void main(String[] args) {
        System.out.println(Operation.ADD.apply(10,20));
        System.out.println(Operation.SUBTRACT.apply(10,20));
        System.out.println(Operation.MULTIPLY.apply(10,20));
        System.out.println(Operation.DIVIDE.apply(10,20));

    }
}
