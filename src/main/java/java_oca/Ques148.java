package java_oca;

import java.time.LocalDate;

// Output:   2012-01-30

public class Ques148 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2012, 1, 30);
        date.plusDays(10);
        System.out.println(date);
    }
}
