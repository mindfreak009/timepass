package java_oca;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// Output:  Compilations fails in Ques171 class


@Getter
@Setter
@ToString
class Empl {
    private String name;
    private int age;
    private int salary;

    public Empl(String name, int age) {
        setName(name);
        setAge(age);
        setSalary(2000);
    }

    public Empl(String name, int age, int salary) {
        this(name, age);
        setSalary(salary);
    }

    public void printDetails() {
        System.out.println(name + " : " + age + " : " + salary );
    }
}

public class Ques171 {
    public static void main(String[] args) {
       // Empl e1 = new Empl();     // because of this, the code fails to compile!
        Empl e2 = new Empl("Jack", 50);
        Empl e3 = new Empl("Chloe", 40, 5000);

        System.out.println(e2);
        System.out.println(e3);
    }
}
