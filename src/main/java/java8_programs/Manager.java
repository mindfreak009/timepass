package java8_programs;

import java.util.*;
import java.util.stream.Collectors;

public class Manager {

    int id;
    String name;
    int age;
    String gender;
    String department;
    int yearOfJoining;
    double salary;

    public Manager(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Id : "+id
                +", Name : "+name
                +", age : "+age
                +", Gender : "+gender
                +", Department : "+department
                +", Year Of Joining : "+yearOfJoining
                +", Salary : "+salary;
    }

    public static void main(String[] args) {
        List<Manager> managerList = new ArrayList<Manager>();

        managerList.add(new Manager(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        managerList.add(new Manager(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        managerList.add(new Manager(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        managerList.add(new Manager(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        managerList.add(new Manager(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        managerList.add(new Manager(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        managerList.add(new Manager(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        managerList.add(new Manager(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        managerList.add(new Manager(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        managerList.add(new Manager(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        managerList.add(new Manager(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        managerList.add(new Manager(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        managerList.add(new Manager(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        managerList.add(new Manager(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        managerList.add(new Manager(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        managerList.add(new Manager(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        managerList.add(new Manager(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        // Query 3.1 : How many male and female employees are there in the organization?
        Map<String, Long> noOfEmployee = managerList.stream().collect(Collectors.groupingBy(Manager::getGender, Collectors.counting()));
        noOfEmployee.entrySet().forEach(x -> {
            System.out.println(x.getKey() + "-" + x.getValue());
        });
        // System.out.println(noOfEmployee);
        System.out.println("====================================================");


        // Query 3.2 : Print the name of all departments in the organization?
        managerList.stream()
                .map(Manager::getDepartment)
                .distinct()
                .forEach(System.out::println);
        System.out.println("===============================================");


        // Query 3.3 : What is the average age of male and female employees?
        Map<String, Double> avgAgeOfMaleAndFemaleEmpl =
                managerList.stream()
                .collect(Collectors.groupingBy(Manager::getGender, Collectors.averagingInt(Manager::getAge)));
        System.out.println(avgAgeOfMaleAndFemaleEmpl);
        System.out.println("====================================");


        // Query 3.4 : Get the details of highest paid employee in the organization?
        Optional<Manager> highestPaidEmpl =
                managerList.stream()
                .max(Comparator.comparingDouble(Manager::getSalary));
        System.out.println(highestPaidEmpl);
        System.out.println("====================================");


        // Query 3.5 : Get the names of all employees who have joined after 2015?
        managerList.stream()
                .filter(x -> x.getYearOfJoining() > 2015)
                .map(Manager::getName)
                .forEach(System.out::println);
        System.out.println("=====================================================");

       // Query 3.6 : Count the number of employees in each department?
        Map<String, Long> noOfEmpInEachDept =
                managerList.stream()
                  .collect(Collectors.groupingBy(Manager::getDepartment, Collectors.counting()));
        System.out.println(noOfEmpInEachDept);
        System.out.println("=====================================================");


        // Query 3.7 : What is the average salary of each department?
        Map<String, Double> avgSalaryOfEachDept =
                managerList.stream()
                        .collect(Collectors.groupingBy(Manager::getDepartment,
                                Collectors.averagingDouble(Manager::getSalary)));
        System.out.println(avgSalaryOfEachDept);
        System.out.println("=====================================================");

       // Query 3.8 : Get the details of youngest male employee in the product development department?
        Optional<Manager> youngestMaleEmp =
                managerList.stream()
                .filter(x -> x.getGender() == "Male"
                        && x.getDepartment() == "Product Development")
                .min(Comparator.comparingInt
                        (Manager::getAge));
        System.out.println(youngestMaleEmp);
        System.out.println("=====================================================");


        // Query 3.9 : Who has the most working experience in the organization?
        Optional<Manager> mostWorkingExpEmployee =
                managerList.stream()
                .min(Comparator.comparingInt
                        (Manager::getYearOfJoining));
        System.out.println(mostWorkingExpEmployee);
        System.out.println("====================================================================");


        // Query 3.10 : How many male and female employees are there in the sales and marketing team?
        Map<String, Long> noOfMAndFemaleEmpInSalesAndMarkTeam =
                managerList.stream()
                .filter(x -> x.getDepartment() == "Sales And Marketing")
                .collect(Collectors.groupingBy(Manager::getGender,
                        Collectors.counting()));
        System.out.println(noOfMAndFemaleEmpInSalesAndMarkTeam);
        System.out.println("====================================================================");


        //Query 3.11 : What is the average salary of male and female employees?
        Map<String, Double> avgSalOfMaleAndFemaleEmp = managerList.stream()
                .collect(Collectors.groupingBy(Manager::getGender,
                        Collectors.averagingDouble(Manager::getSalary)));

        System.out.println(avgSalOfMaleAndFemaleEmp);
        System.out.println("====================================================================");

       // Query 3.12 : List down the names of all employees in each department?
        Map<String, Long> namesOfAllEmplInEachDept =
                managerList.stream()
                        .collect(Collectors.groupingBy(Manager::getDepartment, Collectors.counting()));
        System.out.println(namesOfAllEmplInEachDept);
        System.out.println("====================================================================");


        // Query 3.13 : What is the average salary and total salary of the whole organization?
        DoubleSummaryStatistics avgSalAndTotalSalOfWholeOrgn =
                managerList.stream()
                .collect(Collectors.summarizingDouble(Manager::getSalary));
        System.out.println("Average Salary :: " + avgSalAndTotalSalOfWholeOrgn.getAverage());
        System.out.println("Total Salary :: " + avgSalAndTotalSalOfWholeOrgn.getSum());
        System.out.println("====================================================================");

        //Query 3.14 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
        Map<Boolean, List<Manager>>   partitioningEmpByAge =
                managerList.stream()
                .collect(Collectors.partitioningBy(x -> x.getAge() > 25));

        Set<Map.Entry<Boolean, List<Manager>>> entrySett = partitioningEmpByAge.entrySet();
        for (Map.Entry<Boolean, List<Manager>> resultMap : entrySett) {
            if(resultMap.getKey()) {
                System.out.println("Employee older than 25 years");
            } else {
                System.out.println("Employee younger than OR equal to 25 years");
            }
            System.out.println("====================================================================");

            List<Manager> list = resultMap.getValue();
            for (Manager mgr : list) {
                System.out.println(mgr.getName());
            }
        }
        System.out.println("====================================================================");

        // Query 3.15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?
        Optional<Manager> oldestManager = managerList.stream()
                .max(Comparator.comparingInt(Manager::getAge));
        Manager manager = oldestManager.get();

        System.out.println("Manager age :: " +manager.getAge());
        System.out.println("Manager name :: " +manager.getName());
        System.out.println("Manager dept :: " +manager.getDepartment());
        System.out.println("====================================================================");


    }



}

