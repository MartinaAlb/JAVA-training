package eu.unicorn.tga.javatraining.regularexpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
  1] Split a timestamp with format yyyy-MM-dd HH:mm:ss into separate year, month, day, hours, minutes and seconds and parse them to Integers.
     so that the result will be a list of 6 Integers.
 */
public class Exercise06SplitDateTime {

  public static void main(String[] args) {
    String str = "2023-03-20 18:56:43";

    List<Integer> result = new ArrayList<>();
    Pattern pattern = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})");
    Matcher matcher = pattern.matcher(str);
    if (matcher.find()) {
      for (int i = 1; i <= matcher.groupCount(); i++) {
        result.add(Integer.parseInt(matcher.group(i)));
      }
    }

    for (Integer datePart : result) {
      System.out.print(datePart);
      if (result.indexOf(datePart) < result.size() - 1) {
        System.out.print(",");
      }
    }
    System.out.println();
    // Expected result: 2023,3,20,18,56,43
  }
}
