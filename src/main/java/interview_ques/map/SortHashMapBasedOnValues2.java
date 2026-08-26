package interview_ques.map;

import java.util.*;
import java.util.stream.Collectors;

// Descending sort based on city
public class SortHashMapBasedOnValues2 {
    public static void main(String[] args) {

        Map<Integer, Employee> map = new HashMap<>();
        map.put(1, new Employee(1, "abc", "Mumbai"));
        map.put(2, new Employee(2, "pqr", "Bangalore"));
        map.put(3, new Employee(3, "xyz", "Delhi"));
        map.put(4, new Employee(4, "mnp", "Pune"));

        LinkedHashMap<Integer, Employee> result = map
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue(Comparator.comparing(Employee::getCity))))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        result.forEach((k,v) -> System.out.println(k + ":" +v ));
    }
}


class Employee {
    int id;
    String name;
    String city;

    public Employee(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
