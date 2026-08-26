package java_oca;


// Question:
// After, line s1 = s2, how many objects are eligible for garbage collection ?


// Object Allocation:
//   new Student() creates new objects and assigns them to the variables s1, s2, and s3.
//   After Student s1 = new Student();, there is an object created and referred to by s1.
//   After Student s2 = new Student();, there is another object created and referred to by s2.
//   After Student s3 = new Student();, a third object is created and referred to by s3.

//  So, initially, three separate Student objects are created and referenced by s1, s2, and s3.

// Assignment Statements:
//  s1 = s3;
//  s1 now points to the same object as s3.
//  So, s1 points to the third Student object, the one originally referred to by s3.

//  s3 = s2;
//  Now, s3 points to the same object as s2.

// So, s3 and s2 both point to the second Student object.
// s1 = s2;:

// Now, s1 points to the same object as s2 (the second Student object).
// So, s1, s2, and s3 all point to the second Student object.

// Garbage Collection Eligibility:
// At this point, all the references (s1, s2, and s3) are pointing to the second Student object.
// This means the first (new Student() from s1 originally) and third (new Student() from s3 originally) objects are no longer referenced by any variable.

// Therefore, 2 objects are eligible for garbage collection after the line s1 = s2;:

// The first object, originally referenced by s1, is now unreferenced.
// The third object, originally referenced by s3, is now unreferenced.

// Final Answer:
//   2 objects are eligible for garbage collection.

class Student {
   String name;
   int age;
}

public class Ques180 {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();

        s1 = s3;
        s3 = s2;
        s1 = s2;
    }
}
