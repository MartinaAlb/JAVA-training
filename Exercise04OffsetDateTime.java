package eu.unicorn.tga.javatraining.datetime;


import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/*
  1] Assume that you have an offset date/time represented by a string in UTC format. https://en.wikipedia.org/wiki/Coordinated_Universal_Time
     Write a program that takes that date/time and prints it in CET in format HH:mm:ss.SSS dd.MM.yyyy. https://en.wikipedia.org/wiki/Central_European_Time
 */
public class Exercise04OffsetDateTime {
  public static void main(String[] args) {
    String utcDateStr = "2023-03-22T23:05:15.123Z";

    OffsetDateTime utcDateTime = OffsetDateTime.parse(utcDateStr);
    OffsetDateTime cetDateTime = utcDateTime.atZoneSameInstant(ZoneId.of("CET")).toOffsetDateTime();

    // 2]
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS dd.MM.yyyy");
    String cetDateString = formatter.format(cetDateTime);


    // Expected output: 00:05:15.123 23.03.2023
    System.out.println(cetDateString);
  }
}
