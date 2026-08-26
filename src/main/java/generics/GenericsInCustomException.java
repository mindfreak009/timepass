package generics;

public class GenericsInCustomException {
    public static void main(String[] args) {

        try {
            throw new MyException(123);
        } catch (MyException e) {
            System.out.println("Caught Exception :: "+e.getMessage());
        }

        try {
            throw new MyException("Hello");
        } catch (MyException e) {
            System.out.println("Caught Exception :: "+e.getMessage());
        }

    }
}

// The below code is perfectly fine because we are not defining Generics at class-level
class MyException extends Exception {
    public <T> MyException(T value) {
        super("Exception related to value : "
                + value.toString()
                + " of type: "
                + value.getClass().getName()
        );
    }
}
