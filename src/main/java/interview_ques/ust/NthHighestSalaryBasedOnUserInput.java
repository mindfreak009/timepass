package interview_ques.ust;

import java.util.*;
import java.util.stream.Collectors;

// If number 1 is given, then print the highest salary
// If number 2 is given ,then second highest salary
// .... and so on..

public class NthHighestSalaryBasedOnUserInput {
    public static void main(String[] args)  {
        Map<String, Integer> map = new HashMap<>();
        map.put("Nani", 10000);
        map.put("Chintu", 20000);
        map.put("Kanni", 40000);
        map.put("Harika", 15000);
        map.put("Srinivas", 15000);
        map.put("Srini", 20000);

        int num = 2;
        List<String> nthHighestSalary = findNthHighestSalary(map, num);
        System.out.println(nthHighestSalary);
    }

    private static List<String>  findNthHighestSalary(Map<String, Integer> map, int num) {
        List<Integer> uniqueSalaries = map.values()
                .stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();    // replacement for collect(Collectors.toList());

        System.out.println("uniqueSalaries ::  " + uniqueSalaries);

        // Check if the requested Nth salary exists
        if (num <= 0 || num > uniqueSalaries.size()) {
            return Collections.emptyList(); // Return an empty list if invalid input
        }

        // Find the Nth highest salary
        int nthHighestSalary = uniqueSalaries.get(num - 1);

        System.out.println("nthHighestSalary :: " +nthHighestSalary);

        // Collect names of employees with the Nth highest salary
        return map.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(nthHighestSalary))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
