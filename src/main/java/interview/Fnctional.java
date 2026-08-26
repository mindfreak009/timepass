package interview;

@FunctionalInterface
public interface Fnctional {

    int addTwoNumbers(int a, int b);

    default Object addTwoNum() {
        return "HEllo World";
    }

    static boolean addTwoNumbr() {
        return false;
    }

    // abstract int addThreeNumbers(int a, int b);


}
