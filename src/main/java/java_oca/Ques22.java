package java_oca;

// What is the result ?
// Output: 5

// The loop will terminate once it reaches the while loop condition

public class Ques22 {
    public static void main(String[] args) {
        int num = 5;
        do {
            System.out.println(num-- + " ");
        } while (num == 0);
    }
}
