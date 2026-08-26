package java_oca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Output: An exception is thrown at runtime

public class Ques35 {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.of(6, 20, 2014);
        LocalDate date3 = LocalDate.parse("2014-06-20", DateTimeFormatter.ISO_DATE);
        System.out.println("date1 = " +date1);
        System.out.println("date2 = " +date2);
        System.out.println("date3 = " +date3);

        // Assume that the datetime is "June 20, 2014", what is the result?
    }
}
