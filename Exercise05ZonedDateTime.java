package eu.unicorn.tga.javatraining.datetime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/*
  1] Assume that you have a local time in one particular city (primaryZonedDateTime). You have a list of time zones of several other cities (zoneIds).
     Write a program that prints local time for the given cities (time zones).
 */
public class Exercise05ZonedDateTime {
  public static void main(String[] args) {
    ZonedDateTime primaryZonedDateTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Europe/Rome"));
    System.out.println("Primary = Europe/Rome");
    System.out.println(primaryZonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    System.out.println();
    List<String> zoneIds = List.of("Europe/Paris","Europe/Prague","Europe/London","America/Chicago");

    for (String zoneId : zoneIds) {
      System.out.println(zoneId);
      ZonedDateTime zonedDateTime = primaryZonedDateTime.withZoneSameInstant(ZoneId.of(zoneId));
      System.out.println(zonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    /* Example of output (assuming that now it is 2023-03-19 23:08:02 in Rome)

    Primary = Europe/Rome
    2023-03-19 23:08:02

    Europe/Paris
    2023-03-19 23:08:02
    Europe/Prague
    2023-03-19 23:08:02
    Europe/London
    2023-03-19 22:08:02
    America/Chicago
    2023-03-19 17:08:02
    */
  }
}
