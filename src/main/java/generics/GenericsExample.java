package generics;

public class GenericsExample<T> {
    public static void main(String[] args) {
        GenericsExample<Integer> integer = new GenericsExample<>();
        System.out.println((int)integer.getResult(1, 2));
       // System.out.println(integer.getResult(4.0, 2.0));
    }


    public <T extends Number> double  getResult (T one, T two) {
        if(one instanceof Integer && two instanceof Integer)
            return one.intValue() + two.intValue();
        else if(one instanceof Double && two instanceof Double)
            return one.doubleValue() + two.doubleValue();
        else if(one instanceof Float && two instanceof Float)
            return one.floatValue() + two.floatValue();
        return 0;
    }
}
