package immutable_object;

import java.util.ArrayList;
import java.util.List;

final public class Student {

    final private String name;
    final private int age;
    final private long percentage;
    final private List<String> studentList;

    public Student(String name, int age, long percentage, List<String> studentList) {
        this.name = name;
        this.age = age;
        this.percentage = percentage;

        // performing deep copy of studentList object
        List<String> tempList = new ArrayList<>();
       // studentList.forEach(item -> tempList.add(item));
        for(String str : studentList) {
            tempList.add(str);
        }
        this.studentList = tempList;
    }

    public void display() {
        System.out.println(this.name);
        System.out.println(this.age);
        System.out.println(this.percentage);
        System.out.println(this.studentList);

    }
    public String getName() { return name; }

    public int getAge() { return age; }

    public long getPercentage() { return percentage; }

    public List<String> getStudentList() {
        // performing deep copy of studentList object
        List<String> tempList = new ArrayList<>();
        for(String str : studentList) {
            tempList.add(str);
        }
        return tempList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", percentage=" + percentage +
                ", studentList=" + studentList +
                '}';
    }
}
