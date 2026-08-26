package java_oca;

// Output
// 1:2:3:

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Ques74 {
    private int  c = 21;

    public static void main(String[] args) {
        int nums1[] = {1,2,3};
        int nums2[] = {1,2,3,4,5};
        nums2 = nums1;
        for (int x: nums2) {
            System.out.print(x + ":");
        }

        StringBuilder sb = new StringBuilder("hello");
        System.out.println(sb);
        sb.delete(0, 1000);
        System.out.println("sb now :: " + sb);

       // LocalTime localTime = LocalTime.of(1990, Month.DECEMBER, 15);

        System.out.println(LocalDateTime.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDate.now());

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(0, "Diya");
        arrayList.add(1, "Wadhwani");
       // arrayList.add(3, "hello");                // this line throws "IndexOutOfBoundsException"

        System.out.println(arrayList);



        ArrayList<int[]> i = new ArrayList<>();


    }
}
