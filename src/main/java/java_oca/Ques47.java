package java_oca;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Person {
    String name;
    int age;

    public Person(String n, int a) {
        name = n;
        age = a;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void checkAge(List<Person> list , Predicate<Person> predicate) {
        for (Person p : list) {
            if(predicate.test(p)) {
                System.out.println(p.name + " ");
            }
        }
    }
}

public class Ques47 {
    public static void main(String[] args) {
        List<Person> iList = Arrays.asList(
                new Person("Hank", 45),
                new Person("Charlie", 40),
                new Person("Smith", 38)
        );

        // line n1

        // Example Predicate: Check if age is greater than 40
        Predicate<Person> isOlderThan40 = p -> p.getAge() > 40;

        // Call the checkAge method with the list and predicate
        Person.checkAge(iList, isOlderThan40); // This will print "Hank "
    }
}
