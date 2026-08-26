package java_oca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Output:
// An Exception is thrown at runtime

public class Ques3 {
    public static void main(String[] args) {
        String date = LocalDate
                .parse("2014-05-04")
                .format(DateTimeFormatter.ISO_DATE_TIME);
                // .format(DateTimeFormatter.ISO_DATE);   // Output: 2014-05-04
        System.out.println(date);
    }
}
