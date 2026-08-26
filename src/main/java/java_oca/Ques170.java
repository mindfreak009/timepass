package java_oca;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Output:  2014-07-31T01:01:00


public class Ques170 {
    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.of(2014, 7, 31,1,1);
        dt.plusDays(30);
        dt.plusMonths(1);
        System.out.println(dt.format(DateTimeFormatter.ISO_DATE_TIME));
    }
}
