package eu.unicorn.tga.javatraining.regularexpressions;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*
  1] OPTIONAL - Find all valid Czech dates. Assume that valid date is a date in format dd.MM.YYYY.
     For simplification ignore leap years and fact that February has fewer days than the other months.
*/
public class Exercise08AdvancedFilterByPattern {

  public static void main(String[] args) {
    List<String> dates = List.of("10.12.1992","31.12.2021","4.25.1999","32.11.2022");

    Pattern pattern = Pattern.compile("^(0?[1-9]|[12][0-9]|3[01])\\.(0?[1-9]|1[012])\\.\\d{4}$"); //
    List<String> result = dates.stream()
        .filter(pattern.asPredicate())
        .collect(Collectors.toList());

    for (String subStr : result) {
      System.out.println(subStr);
    }

    // Expected result: "10.12.1992","31.12.2021"
  }
}
