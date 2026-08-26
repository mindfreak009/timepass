package interview_ques;

// Day of week are represented in 3 letter strings {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
// Write a function that given a String S representing the day of the week and an integer 'K'
// (between 0 and 500 inclusive),  returns the day of the week that is 'K' days later.

// For e.g.. given S="Wed" and K=2, the function should return "Fri"
// Given S="Fri" and K= 23, the function should return "Mon"

import java.util.HashMap;
import java.util.Map;

public class ReturnDayOfWeek {
    public static void main(String[] args) {

        String day = "Fri";
        int k = 3;

        String s = returnDayOfWeek(day, k);
        System.out.println(s);
    }

    private static String returnDayOfWeek(String day, int K) {
        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

        Map<String, Integer> map = new HashMap<>();
        map.put("Mon", 1);
        map.put("Tue", 2);
        map.put("Wed", 3);
        map.put("Thu", 4);
        map.put("Fri", 5);
        map.put("Sat", 6);
        map.put("Sun", 7);

        // Find the starting index of the given day
        int startIdx = map.get(day);

        // Skip Saturday (6) and Sunday (7) by iterating only through valid days
        int resultIdx = startIdx;
        int daysMoved = 0;

        while (daysMoved <= K) {
            resultIdx = (resultIdx + 1) % days.length;

            // Skip Saturday and Sunday
            if (resultIdx == 6 || resultIdx == 7) {
                continue;
            }
            daysMoved++;
        }
        return days[resultIdx];

       // return days[(map.get(day) + K) % days.length];
    }
}
