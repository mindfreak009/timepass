package interview_ques.coforge;

import java.util.*;


public class Interview1 {
    public static void main(String[] args) {

        // 2. Print sum of a list of integer using streams
        List<Integer> values = new ArrayList<>();
        values.add(3);
        values.add(17);
        values.add(13);
        values.add(9);
        values.add(18);

        // FIRST APPROACH
        System.out.println(values.stream()
                .mapToInt(Integer:: intValue)
                .sum());

        // SECOND APPROACH
        System.out.println(values.stream()
                .reduce(0, Integer :: sum));
        System.out.println("======================================");

        // 3. Find second largest string from a list of Strings
        List<String> emp = new ArrayList<>();
        emp.add("rajat");
        emp.add("amit");
        emp.add("jaysha");
        emp.add("kshitiz");
        emp.add("rohitsharma");

        // select max(marks) from emp ORDER BY DESC LIMIT (0, 1);

        emp.stream()
                .sorted((s1, s2) -> s2.length()-s1.length())
                .skip(1)
                .limit(1)
                .forEach(System.out::println);
        System.out.println("======================================");
                        //.skip(1)
                        //.limit(1)
                //.findFirst()
                //.get());

        //  4.Print distinct cars from a list of cars
        List<String> emp2 = new ArrayList<>();
        emp2.add("bmw");
        emp2.add("audi");
        emp2.add("audi");
        emp2.add("maruti");
        emp2.add("maruti");
        emp2.add("suzuki");
        emp2.add("toyota");

        emp2.stream()
                .distinct()
                .forEach(System.out::println);
        System.out.println("==================================");


       // 5.Print string with it's character count from a list of String
        List<String> emp3 = new ArrayList<>();
        emp3.add("bmw");
        emp3.add("audi");
        emp3.add("audi");
        emp3.add("maruti");
        emp3.add("maruti");
        emp3.add("suzuki");
        emp3.add("toyota");

//        System.out.println(emp3.stream()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

        // Remove duplicates and sort the list
          emp3.stream()
                .distinct()           // Remove duplicates
                .sorted()             // Sort the list alphabetically
                .forEach(brand -> System.out.println(brand + ": " +brand.length() + " characters"));
                // the last line prints each string along with its character count



    }
}
