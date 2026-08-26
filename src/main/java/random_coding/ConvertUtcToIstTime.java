package random_coding;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.List.*;

public class ConvertUtcToIstTime {

    public static void main(String[] args) throws ParseException {

        List<String> namesList = Arrays.asList("Bob", "Jamie", "Jill", "Rick");
        System.out.println("namesList : " + namesList);
        List<String> namesListUpperCase = namesList
                .parallelStream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("namesListUpperCase : " + namesListUpperCase);

        int totalCount = 0;
        int count = 141999/100;

        if(141999%100 !=0) {
            count = count+1;
        }

        System.out.println("count ::: " +count);
        System.out.println("result ::: " +141999%100);
        System.out.println("first  ::: " + (67%100==0));
        // Date date = "2019-06-04T06:24:29Z";

        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        System.out.println("utilDate:" + utilDate);
        System.out.println("sqlDate:" + sqlDate);

        String strrr = convertToNewFormat("2019-06-04T06:24:29Z");
        System.out.println("new string :::: " +strrr);
//        LocalDateTime ldtInTijuana = LocalDateTime.parse("2022-11-22T17:15:00Z")
//                .atOffset(ZoneOffset.UTC)
//                .atZoneSameInstant(ZoneId.of("Asia/Kolkata"))
//                .toLocalDateTime();
//        System.out.println("1) " +ldtInTijuana);
//
//        // Custom format
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
//        String formatted = ldtInTijuana.format(formatter);
//        System.out.println("2) " + formatted);

        String s = checkNull(null);
        System.out.println("s :::: " +s);

        // **** YOUR CODE **** BEGIN ****
        long ts = System.currentTimeMillis();
        Date localTime = new Date(ts);
        String format = "yyyy/MM/dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);

        // Convert Local Time to UTC (Works Fine)
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date gmtTime = new Date(sdf.format(localTime));
        System.out.println("Local:" + localTime.toString() + "," + localTime.getTime() + " --> UTC time:"
                + gmtTime.toString() + "," + gmtTime.getTime());

        // **** YOUR CODE **** END ****

        // Convert UTC to Local Time
        Date fromGmt = new Date(gmtTime.getTime() + TimeZone.getDefault().getOffset(localTime.getTime()));
        System.out.println("UTC time:" + gmtTime.toString() + "," + gmtTime.getTime() + " --> Local:"
                + fromGmt.toString() + "-" + fromGmt.getTime());


        String startDateTimeUtc = "2019-05-09T15:09:43Z";

        System.out.println("standard Time :: " + getStandardTime(startDateTimeUtc));

        // LocalDateTime localDateTime = Instant.now().atOffset(ZoneOffset.UTC).toLocalDateTime();
//        LocalDateTime localDateTime = LocalDateTime.("2019-05-09T15:09:43Z").atOffset(ZoneOffset.UTC).toLocalDateTime();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
 //       System.out.println("here ::: " +localDateTime.format(formatter));


        String inputValue = "2019-05-09T15:09:43Z";
        Instant timestamp = Instant.parse(inputValue);
        ZonedDateTime losAngelesTime = timestamp.atZone(ZoneId.of("Asia/Kolkata"));
        System.out.println("aasdad ::: " + losAngelesTime);

        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
        System.out.println("timestamp :::" +timeStamp);


        String convertTime = convertISOTimeToServerTime(inputValue);
        System.out.println("convertTime :::: " + convertTime);


        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZ");
        Date result;
        try {
            result = df.parse("2013-03-13T20:59:31+0000");
            System.out.println("date: "+result); //prints date in current locale
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            System.out.println(" finally :::  " + sdf.format(result)); //prints date in the format sdf
        } catch (Exception e) {
            System.out.println("e ::: " +e);
        }

        StringBuilder sb = new StringBuilder();
        String str = "2013-03-13T20:59:31";
        String split[] = str.split("T");
        sb.append(split[0]);
        sb.append(" ");
        sb.append(split[1]);

        System.out.println("new sssss ::: " + sb);


//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
//        LocalDateTime maxDate = pubDates.stream().map(s -> LocalDateTime.parse(s, formatter))
//                .max(LocalDateTime::compareTo).get();

        // Convert UTC to Local Time
        SimpleDateFormat ss =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(inputValue);
        System.out.println("ooooo :: " + offsetDateTime.getYear()  +"-" + offsetDateTime.getDayOfMonth() + "-" + offsetDateTime.getMonthValue() );

//
//        Date fromGmt = new Date(gmtTime.getTime() + TimeZone.getDefault().getOffset(localTime.getTime()));
//        System.out.println("UTC time:" + gmtTime.toString() + "," + gmtTime.getTime() + " --> Local:"
//                + fromGmt.toString() + "-" + fromGmt.getTime());

//        LocalDateTime.parse( "2016-09-25 17:26:12".replace( " " , "T" ))
//                .atZoneSameInstant( ZoneId.systemDefault() )
//                .format( DateTimeFormatter.ofLocalizedDateTime( FormatStyle.MEDIUM ) );

    }


    public java.sql.Timestamp justIn(Date date) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");

        String DateToStoreInDataBase= sdf.format(date); // java.util.Date
        System.out.println(DateToStoreInDataBase);

        Timestamp ts = Timestamp.valueOf(DateToStoreInDataBase); // java.sql.Timestamp
        System.out.println(ts);
        return ts;

//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZ");
//        Date result;
//        try {
//            result = df.parse("2013-03-13T20:59:31+0000");
//            System.out.println("date:"+result); //prints date in current locale
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
//            System.out.println(sdf.format(result)); //prints date in the format sdf
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static String convertISOTimeToServerTime(String utcTime) {
        String regex = "Z";
        utcTime = utcTime.replaceAll(regex, "");
// yyyy-MM-dd'T'HH:mm:ssZv
        DateTimeFormatter inputDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        DateTimeFormatter outputDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

//        OffsetDateTime timeAtInputOffset = OffsetDateTime.parse(utcTime, inputDateFormat);
//        OffsetDateTime timeAtLocalOffset = timeAtInputOffset.withOffsetSameInstant(ZoneOffset.ofHoursMinutes(5, 30));

//        LocalDateTime dateTime = LocalDateTime.parse(utcTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        System.out.println("dareTimmmm ::: "+dateTime);

        return "";
        // return timeAtLocalOffset.format(outputDateFormat);


    }

    public static String timeConverter(String time) {
        return Instant.parse( time )   // Parse this String in standard ISO 8601 format as a `Instant`, a point on the timeline in UTC. The `Z` means UTC.
                .atOffset( ZoneOffset.UTC )                                // Change from `Instant` to the more flexible `OffsetDateTime`.
                .format(                                                   // Generate a String representing the value of this `OffsetDateTime` object.
                        DateTimeFormatter.ofPattern( "yyyy-MM-dd HH:mm:ss" ));

        //Instant.parse( "2018-05-23T23:18:31.000Z" )
    }

    private static String getStandardTime(String dateStr) {
       // SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dddd'T'HH:mm:ssZ");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = null;
        try {
            date = df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        df.setTimeZone(TimeZone.getTimeZone(ZoneId.of("Asia/Kolkata")));
        String formattedDate = df.format(date);
        return formattedDate;
    }

    private static String checkNull(String s) {
        if(s == null || s.trim().isEmpty()){
            return null;
        } else {
            System.out.println("reached here :::: ");
            return "I am here ";
        }
    }

    public static String convertToNewFormat(String sourceDateTime) throws ParseException {
        System.out.println("sourceDateTime ::: " + sourceDateTime);
//        TimeZone utc = TimeZone.getTimeZone("UTC");
//        /// SimpleDateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//        SimpleDateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.'Z'");
//        SimpleDateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        sourceFormat.setTimeZone(utc);
//        Date convertedDate = sourceFormat.parse(dateStr);
//        return destFormat.format(convertedDate);

       // String sourceDateTime           = "2018-05-23T23:18:31.000Z";
       //  DateTimeFormatter sourceFormat  = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//        DateTimeFormatter sourceFormat  = DateTimeFormatter.ofPattern(sourceDateTime);
//        DateTimeFormatter targetFormat  = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

//        LocalDateTime dateTime          = LocalDateTime.parse(sourceDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.'X'"));
//        System.out.println("dateTime ::: " +dateTime);
//        String formatedDateTime         = dateTime.atZone(ZoneId.of("UTC")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        System.out.println( "for,ateted date :::: " + formatedDateTime);

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
//        //dates to be compare
//        Date date1 = sdf.parse(sourceDateTime);
//
//        Date date2 = sdf.parse("2020-06-18");



        System.out.println("zonedDate Time" + //ZonedDateTime.parse("2018-05-23T23:18:31.000Z")
                ZonedDateTime.parse((CharSequence) sourceDateTime)
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)));

        return  "";  // formatedDateTime;
    }

}
