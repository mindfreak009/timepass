package java_oca;

// Which code modifications enable the code to print joe:true:100.0 ?

class Employz {

    String name;
    boolean contract;
    double salary;

    Employz() {
        // line n1
//      this.name = new String("Joe");
//      this.contract = new Boolean(true);
//      this.salary = new Double(100);
    }

    @Override
    public String toString() {
        return name + ": " + contract + ": " + salary;
    }
}

public class Ques25 {
    public static void main(String[] args) {
        Employz e = new Employz();
        // line n2
        e.name = "Joe";
        e.contract = true;
        e.salary = 100;

        System.out.println(e);

    }
}
