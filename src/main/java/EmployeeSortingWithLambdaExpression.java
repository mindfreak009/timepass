import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeSortingWithLambdaExpression {

    int empNum;
    String empName;

    public EmployeeSortingWithLambdaExpression(int empNum, String empName) {
        this.empNum = empNum;
        this.empName = empName;
    }

    public int getEmpNum() {
        return empNum;
    }

    public void setEmpNum(int empNum) {
        this.empNum = empNum;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Override
    public String toString() {
        return "EmployeeSortingWithLambdaExpression{" +
                "empNum=" + empNum +
                ", empName='" + empName + '\'' +
                '}';
    }
}


class Test {
    public static void main(String[] args) {
        EmployeeSortingWithLambdaExpression emp = new EmployeeSortingWithLambdaExpression(100, "Peter");
        System.out.println(emp);

        List<EmployeeSortingWithLambdaExpression> employeeList = new ArrayList<>();
        employeeList.add(new EmployeeSortingWithLambdaExpression(200, "Deepika"));
        employeeList.add(new EmployeeSortingWithLambdaExpression(400, "Sunny"));
        employeeList.add(new EmployeeSortingWithLambdaExpression(100, "Mallika"));
        employeeList.add(new EmployeeSortingWithLambdaExpression(300, "Katrina"));
        employeeList.add(new EmployeeSortingWithLambdaExpression(500, "Harry"));

        System.out.println("Before Sorting ::");
        System.out.println(employeeList);

        System.out.println("After Sorting ::");
        Collections.sort(employeeList, (a1, a2)-> (a1.empNum < a2.empNum)?-1 : (a1.empNum > a2.empNum)?1 : 0);
        System.out.println(employeeList);



    }
}
