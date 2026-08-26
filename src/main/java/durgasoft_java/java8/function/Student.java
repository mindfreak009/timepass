package durgasoft_java.java8.function;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Student {

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name) {
        this.name = name;
    }
}
