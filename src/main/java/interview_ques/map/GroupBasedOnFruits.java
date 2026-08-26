package interview_ques.map;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

class Employeee {
    private String name;
    private String city;
    private int age;

    public Employeee(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s(%s,%d)", name, city, age);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.city);
        hash = 79 * hash + this.age;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employeee other = (Employeee) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        return true;
    }
}

    public class GroupBasedOnFruits {
    public static void main(String[] args) {

        List<Employeee> emp = new ArrayList<>();
        emp.add(new Employeee("Dipak", "Delhi", 21));
        emp.add(new Employeee("Sumit", "Delhi", 26));
        emp.add(new Employeee("Karan", "Delhi", 41));
        emp.add(new Employeee("Mona", "Udaipur", 23));
        emp.add(new Employeee("Mona", "Udaipur", 23));
        emp.add(new Employeee("Rajesh", "Banglore", 23));
        emp.add(new Employeee("Niraj", "Banglore", 34));
        emp.add(new Employeee("Niraj", "Pune", 28));

        // Adding 10 to age of each employee, retaining the Employee object.
        emp.stream().map(e -> new Employeee(e.getName(), e.getCity(), e.getAge()+10))
                .forEach(System.out::println);
        System.out.println("=============================================================");

        // Given an employee list, sort employees based on age in descending order
        emp.stream().sorted(Comparator.comparingInt(Employeee::getAge)).
                map(e -> new Employeee(e.getName(), e.getCity(), e.getAge()))
                        .forEach(System.out::println);

        System.out.println("=============================================================");

        // Given an employee, group all employees based on age.
        Map<Integer, List<Employeee>> groupingByAge = emp.stream().collect(Collectors.groupingBy(Employeee::getAge));
        Map<Integer, Set<Employeee>> groupingByAge2 = emp.stream().collect(Collectors.groupingBy(Employeee::getAge, Collectors.toSet()));
        Map<Integer, Set<Employeee>> groupingByAge3 = emp.stream().collect(Collectors.groupingBy(Employeee::getAge, TreeMap::new, Collectors.toSet()));

        groupingByAge.entrySet().stream().forEach(System.out::println);
        System.out.println("collecting in set=============================================================");
        groupingByAge2.entrySet().stream().forEach(System.out::println);
        System.out.println("=============================================================");
        groupingByAge3.entrySet().stream().forEach(System.out::println);

        System.out.println("=============================================================");

        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(8);
        list.add(3);
        list.add(1);
        list.add(1);

        double avg = list.stream().mapToInt(x -> x).summaryStatistics().getAverage();
        System.out.println("max: " +avg);

        Integer secondSmallestElement = list.stream()
                .sorted()
                .distinct()
                .skip(1)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No element present in list"));

        System.out.println("Second smallest element in array is ::: " + secondSmallestElement);

        List<String> collect = emp.stream().map(e -> e.getCity()).collect(Collectors.toList());

        Employeee delhi = emp.stream().parallel().filter(e -> e.getCity().equalsIgnoreCase("delhi"))
                .findFirst().get();
        System.out.println("emp ::: " +delhi);
        emp.stream().collect(Collectors.groupingBy(e -> e.getCity(), Collectors.counting()));
        System.out.println(emp.stream().collect(Collectors.groupingBy(e -> e.getCity(), Collectors.counting())));

//        System.out.println(emp.stream()
//                .collect(Collectors.groupingBy(Employee::getName, Collectors.counting())));

        System.out.println(IntStream.iterate(1, e->e+2).limit(10).peek(System.out::println).sum());
       // System.out.println(emp.stream().collect(Collectors.joining(",")));

        System.out.println("here we are ::: " + LongStream.rangeClosed(1, 50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply));


    }
}
