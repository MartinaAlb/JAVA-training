package eu.unicorn.tga.javatraining.datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/*
  1] Input for this program is an array of pairs - local date time / format (expect it to be compatible with DateTimeFormatter.ofPattern())
     Implement a program that outputs dates from that array sorted chronologically.
 */
public class Exercise02SimpleLocalDateTime {
  public static void main(String[] args) {
    String[][] input = {
        {"2023-03-19T22:05:30","yyyy-MM-dd'T'HH:mm:ss"},
        {"19:00:30 02-18-2023","HH:mm:ss MM-dd-yyyy"},
        {"21:05:30 2023-03-19","HH:mm:ss yyyy-MM-dd"},
        {"21:00:30 18-02-2023","HH:mm:ss dd-MM-yyyy"},
    };


    List<LocalDateTime> result = new ArrayList<>();
    DateTimeFormatter inputFormatter;

    for (String[] pair : input) {
      inputFormatter = DateTimeFormatter.ofPattern(pair[1]);
      LocalDateTime dateTime = LocalDateTime.parse(pair[0], inputFormatter);
      result.add(dateTime);
    }

    result.sort(LocalDateTime::compareTo);

    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    for (LocalDateTime dtm : result) {
      System.out.println(dtm.format(outputFormatter));
    }

    /* Expected output:
       2023-02-18T19:00:30
       2023-02-18T21:00:30
       2023-03-19T21:05:30
       2023-03-19T22:05:30
     */
  }
}
