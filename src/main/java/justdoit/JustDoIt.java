package justdoit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class JustDoIt {
    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));

        System.out.println(new Date());

//        String datum = "Wed Dec 20 17:15:54 IST 2023";
//        String daa = new SimpleDateFormat("YYYY_MM_DD").format(datum);
//        System.out.println(daa);

        // SimpleDateFormat df = new SimpleDateFormat("\n Time：yyyy-MM-dd HH:mm:ss");
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println("============================");
        System.out.println(dateFormat2.format(new Date()));
        // String finalDate = dateFormat.format(new Date());
       //  System.out.println(finalDate);

        String newTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
        System.out.println("=============================");
        System.out.println(newTime);

      //  System.out.println(getTime(6687));

        List<Integer> list = Arrays.asList(1,2,3);
        List<String> collect = list.stream().map(i -> i + ((i % 2 == 0) ? "e" : "o")).collect(Collectors.toList());
        System.out.println(collect);
    }

    private static String getTime(long millis) {

       //  long seconds = (millis / 1000) % 60;
        // long minutes = ((millis / 1000) / 60) % 60;
       // long hours = ((millis / 1000) / 60) / 60;

        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

        System.out.println("--------------------------------------------------------------------");
       return String.format("%02dh : %02dm : %02ds : %02dms", hours, minutes, seconds);

//        long min = TimeUnit.MILLISECONDS.toMinutes(millisecond);
//        long seconds = TimeUnit.MILLISECONDS.toSeconds(millisecond) -
//                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisecond));
//        long mili = TimeUnit.SECONDS.toMillis(seconds);
//
//
//        return min + ":" + seconds + ":" +mili;
    }
//    private static String millisecondsToTime(long milliseconds) {
//        long minutes = (milliseconds / 1000) / 60;
//        long seconds = (milliseconds / 1000) % 60;
//        String secondsStr = Long.toString(seconds);
//        String secs;
//        if (secondsStr.length() >= 2) {
//            secs = secondsStr.substring(0, 2);
//        } else {
//            secs = "0" + secondsStr;
//        }
//
//        return minutes + ":" + secs;
//    }
}
