package immutable_object;

import java.util.ArrayList;
import java.util.List;

// 1. Declare the class as FINAL so it can't be extended
// 2. Make all fields as PRIVATE so that direct access is not allowed.
// 3. Don't provide setter methods for variables.
// 4. Make all mutable fields FINAL so that a field's value can be assigned only once.
// 5. Initialize all fields using a constructor method performing deep copy.
// 6. Perform deep copy in getter of mutable fields.

// Creating a copy of object in a different memory location. This is called a Deep copy.
// Creating a new reference that points to the same memory location. This is also called a Shallow copy.

public class ImmutableTemplate {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Jungle Book");
        Student student = new Student("Harry", 21, 65, list);

        // student.display();
        System.out.println(student);
        System.out.println("=================================");

        List<String> studentList =  student.getStudentList();
        System.out.println("studentList :::: " +studentList);
        studentList.clear();
        System.out.println("=================================");

        System.out.println("studentList size ::: " +studentList.size());
        student.display();
        System.out.println(student);
        System.out.println("=================================");

    }
}
