package interview_ques.productbased.zyx;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamInterviewQuestion {
    static class EmployeeObject {
        private Integer id;
        private String name;
        private Integer age;
        private String gender;
        private String department;
        private Integer yearOfJoining;
        private Double salary;

        public EmployeeObject(Integer id, String name, Integer age, String gender, String department, Integer yearOfJoining, Double salary) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.department = department;
            this.yearOfJoining = yearOfJoining;
            this.salary = salary;
        }

        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public Integer getAge() {
            return age;
        }
        public void setAge(Integer age) {
            this.age = age;
        }
        public String getGender() {
            return gender;
        }
        public void setGender(String gender) {
            this.gender = gender;
        }
        public String getDepartment() {
            return department;
        }
        public void setDepartment(String department) {
            this.department = department;
        }
        public Double getSalary() {
            return salary;
        }
        public void setSalary(Double salary) {
            this.salary = salary;
        }

        public Integer getYearOfJoining() {
            return yearOfJoining;
        }

        public void setYearOfJoining(Integer yearOfJoining) {
            this.yearOfJoining = yearOfJoining;
        }

        @Override
        public String toString() {
            return "EmployeeObject{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", gender='" + gender + '\'' +
                    ", department='" + department + '\'' +
                    ", yearOfJoining=" + yearOfJoining +
                    ", salary=" + salary +
                    '}';
        }
    }

    static List<EmployeeObject> employeeObjectList = new ArrayList<EmployeeObject>();

    public static void main(String[] args) {
        employeeObjectList.add(new EmployeeObject(111, "Jeya", 30, "Female", "HR", 2011, 25000.0));
        employeeObjectList.add(new EmployeeObject(122, "Polish", 29, "Male", "Sales", 2015, 18500.0));
        employeeObjectList.add(new EmployeeObject(133, "Thomas", 26, "Male", "Administartion", 2012, 18700.0));
        employeeObjectList.add(new EmployeeObject(144, "Gowthami", 29, "Female", "Development", 2014, 33500.0));
        employeeObjectList.add(new EmployeeObject(155, "Nisha", 25, "Female", "HR", 2013, 22000.0));
        employeeObjectList.add(new EmployeeObject(166, "Issac", 40, "Male", "Maintenance", 2016, 12000.0));
        employeeObjectList.add(new EmployeeObject(177, "Sharmila", 30, "Female", "Finance", 2010, 29000.0));
        employeeObjectList.add(new EmployeeObject(188, "Linga", 33, "Male", "Development", 2015, 35000.0));
        employeeObjectList.add(new EmployeeObject(199, "John", 34, "Male", "Sales", 2016, 14500.0));
        employeeObjectList.add(new EmployeeObject(200, "Jeyam", 36, "Male", "Maintenance", 2015, 17000.0));
        employeeObjectList.add(new EmployeeObject(211, "kumar", 37, "Male", "Administartion", 2014, 18700.0));
        employeeObjectList.add(new EmployeeObject(222, "Joshi", 23, "Male", "Development", 2016, 29000.0));
        employeeObjectList.add(new EmployeeObject(233, "Reddy", 29, "Male", "Finance", 2013, 27000.0));
        employeeObjectList.add(new EmployeeObject(244, "Denwer", 28, "Male", "Sales", 2017, 18000.));
        employeeObjectList.add(new EmployeeObject(255, "Alia", 26, "Female", "Administartion", 2018, 13000.0));
        employeeObjectList.add(new EmployeeObject(266, "Sangavi", 36, "Female", "Development", 2015, 29000.0));
        employeeObjectList.add(new EmployeeObject(277, "Anuja", 32, "Female", "Development", 2012, 38000.0));


        // 1. Calculate the Average Salary based on the Gender
        Map<String, Double> avgSalaryBasedOnGender =
                employeeObjectList.stream()
                .collect(Collectors.groupingBy(EmployeeObject::getGender,
                        Collectors.averagingDouble(EmployeeObject::getSalary)));
        System.out.println("AverageSalaryBasedOnGender ::: " + avgSalaryBasedOnGender);
        System.out.println("============================================================================");

        // 2. List the Name of Employees based on their Department
        Map<String, List<EmployeeObject>> collect =
                employeeObjectList.stream()
                .collect(Collectors.groupingBy(EmployeeObject::getDepartment));

        for (Map.Entry<String, List<EmployeeObject>> entry : collect.entrySet()) {
            System.out.println("Department Name is "+entry.getKey());
            System.out.println("=================================");

            List<EmployeeObject> list = entry.getValue();
            for ( EmployeeObject empObjList: list) {
                System.out.println("Employee name :: " +empObjList.getName());
            }
        }
        System.out.println("====================================================================");


        // 3. Employees who are under 25 years old and those who are over 25 years old should be kept apart.
        Map<Boolean, List<EmployeeObject>> partitioningByAgeGreaterThan25 =
                employeeObjectList.stream()
                .collect(Collectors.partitioningBy(x -> x.getAge() > 25));

        for (Map.Entry<Boolean, List<EmployeeObject>>  entry : partitioningByAgeGreaterThan25.entrySet()) {
            if (entry.getKey())
                System.out.println("Age Greater than 25 years :");
            else
                System.out.println("Age less than or Equal to 25 years :");

            List<EmployeeObject> employeeObjectsList = entry.getValue();
            for ( EmployeeObject emp : employeeObjectsList ) {
                System.out.println("Emp Names ::: " +emp.getName() + "--" +emp.getAge() +" yrs");
            }

        }


    }
}
