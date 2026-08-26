package dsa.queue.priorityqueue;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class NewStudent implements Comparable<NewStudent> {
    private String name;
    private int  marks;

    public NewStudent(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student name : " + this.name + " , marks : " + this.marks;
    }

    @Override
    public int compareTo(NewStudent that) {
        // return this.marks - that.marks; // increasing order  (ASCENDING)

        if(this.marks==that.marks) {
            return this.name.compareTo(that.name);  // negative, 0, positive
        }
        return this.marks - that.marks; // increasing order  (ASCENDING)
       // return that.marks - this.marks; // decreasing order  (DESCENDING)
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof NewStudent) {
            NewStudent that = (NewStudent)obj;
            boolean isNameSame = (this.name.compareTo(that.name)==0);
            if(this.marks == that.marks && isNameSame) {
                return true;
            }
        }
        return false;
    }
}

public class MyPriorityQueue {
    public static void main(String[] args) {
        // min Priority Queue
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        minPq.offer(1);
        minPq.offer(2);
        minPq.offer(10);
        minPq.offer(7);
        System.out.println("min priority element :: " + minPq.peek());

        // max Priority Queue
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        maxPq.offer(1);
        maxPq.offer(2);
        maxPq.offer(10);
        maxPq.offer(0);
        System.out.println("max priority element :: " + maxPq.peek());

        PriorityQueue<NewStudent> minStudentPq = new PriorityQueue<>();
        minStudentPq.offer(new NewStudent("Aman", 70));
        minStudentPq.offer(new NewStudent("Amit", 70));
        minStudentPq.offer(new NewStudent("Hema", 97));
        minStudentPq.offer(new NewStudent("Lucy", 43));

        System.out.println(minStudentPq.peek());
        //System.out.println(minStudentPq.contains(newStudent));

    }
}
