package java8_programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortOnNameThenAge {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Rashmika", 28));
        personList.add(new Person("Pushpa", 32));
        personList.add(new Person("Samantha", 32));
        personList.add(new Person("Pushpa", 22));
        personList.add(new Person("Harry", 17));


        // First approach: using Collections.sort() method
        Collections.sort(personList,
                Comparator.comparing(Person::getName).thenComparing(Person::getAge));
        System.out.println(personList);

        System.out.println("===============================================");

        // Second approach:
        // Comparator<Person> byName = (x,y) -> x.getName().compareTo(y.getName());
        // Comparator<Person> byAge = (x,y) -> Integer.compare(x.getAge(), y.getAge());
        // Comparator<Person> byAge = (x,y) -> x.getAge()-y.getAge();
        Comparator<Person> byName = Comparator.comparing(Person::getName);
        Comparator<Person> byAge = Comparator.comparingInt(Person::getAge);
        personList.stream()
                .sorted(byName.thenComparing(byAge))
                .forEach(System.out::println);

        // Third approach :
        System.out.println("===============================================");
        personList.stream()
                .sorted(Comparator.comparing(Person::getName)
                        .thenComparing(Person::getAge))
                .forEach(System.out::println);
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
