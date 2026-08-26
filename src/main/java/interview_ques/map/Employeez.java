package interview_ques.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Employeez  {
    int id;
    String name;
    Integer salary;
    String designation;
    List<String> emails = new ArrayList<>();

    Employeez(){

    }
    Employeez(int salary){
        this.salary = salary;
    }

    Employeez(int id,String name,Integer salary, String designation, String email1, String email2){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.designation = designation;
        emails.add(email1);
        emails.add(email2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name); // Use name to compute hashCode, matching equals
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employeez e2)) {
            return false;
        }
        // Employeez e2 = (Employeez) o;
        // return Objects.equals(this.name, e2.name); // Use Objects.equals for null-safe comparison
        return Objects.equals(this.name, e2.name); // Use Objects.equals for null-safe comparison
    }

    public String toString(){
        return this.name +" "+ this.designation +" "+ this.salary +" "+ this.emails;
    }
}

class EmployeezMain {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(7);
        list.add(2);
        list.add(12);
        list.add(2);
        list.add(24);
        list.add(4);

        Stream<Integer> stream =  list.stream();
        System.out.println(stream.count());
        list.stream().
                filter(a -> a%2==0).
                forEach(a -> System.out.println(a));
        System.out.println("================================================");


        list.stream().
                filter(a -> a%2==0).
                distinct().
                forEach(a -> System.out.println(a));
        System.out.println("================================================");



        list.stream().
                filter(a -> a%2==0).
                distinct().
                sorted((a,b) -> b-a).
                forEach(a -> System.out.println(a));
        System.out.println("================================================");


        list.stream().
                filter(a -> a%2==0).
                distinct().
                sorted((a,b) -> b-a).
                map(a -> a*2).
                forEach(a -> System.out.println(a));
        System.out.println("================================================");


        int sum = list.stream().
                filter(a -> a%2==0).
                distinct().
                map(a -> a*2).
                reduce(1,(a,b) -> a+b);

        System.out.println(sum);
        System.out.println("================================================");

        List<Integer> resList = list.stream().
                filter(a -> a%2==0).
                distinct().
                map(a -> a*2).
                collect(Collectors.toList());

        System.out.println(resList);
        System.out.println("================================================");


        List<Employeez> empList = new ArrayList<>();
        empList.add(new Employeez(1,"aman", 70000,"sde1","aman1@gmail.com","aman2@gmail.com"));
        empList.add(new Employeez(2,"amit", 80000,"lead","amit1@gmail.com","amit2@gmail.com"));
        empList.add(new Employeez(3,"varun", 90000,"sde1","varun11@gmail.com","varun91@gmail.com"));
        empList.add(new Employeez(4,"rahul", 70000,"sde2","rahul@gmail.com","rahul12@gmail.com"));
        empList.add(new Employeez(5,"aman", 70000,"sde1","aman15@gmail.com","aman25@gmail.com"));

        empList
                .stream()
                .filter(a -> a.designation.equals("sde1"))
                .forEach(System.out::println);
        System.out.println("================================================");

        empList
                .stream()
                .filter(a -> a.designation.equals("sde1"))
                .distinct()
                .forEach(System.out::println);
        System.out.println("================================================");

    // Doubling the salary of the sde1 employees and returning the entire Employeez object
        empList
                .stream()
                .filter(a -> a.designation.equals("sde1"))
                .distinct()
                .sorted((a,b) -> b.salary-a.salary)
               // .map(i -> i.salary*2)     This code would only RETURN the increased salary and NOT the employee object
                // .peek(i -> i.salary*=2)  This works perfectly fine !!
                .map(i -> {
                    i.salary*=2;
                    return i;
                })
                .forEach(System.out::println);
        System.out.println("================================================");

        Employeez employeez = empList
                .stream()
                .filter(a -> a.designation.equals("sde1"))
                .distinct()
                .sorted((a,b) -> b.salary-a.salary)
                // .map(i -> i.salary*2)     This code would only RETURN the increased salary and NOT the employee object
                // .peek(i -> i.salary*=2)  This works perfectly fine !!
                .map(i -> {
                    i.salary*=2;
                    return i;
                })
                .reduce(new Employeez(0), (a,b) -> new Employeez(a.salary+b.salary));
        //System.out.println(employeez);
        System.out.println("====================================================================");



    }
}
