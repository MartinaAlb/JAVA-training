package eu.unicorn.tga.javatraining.regularexpressions;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*
  1] Business logic of the exercise is intentionally simplified.
     Assume that valid IP address has following structure: [part].[part].[part].[part] where [part] contains one to three digits.
     Examples of valid IP addresses: 1.2.3.4, 192.1.1.12,123.123.123.123.
     Examples of invalid IP addresses: 1.2.3, 1.2.3.4.5, 192.168.1.1234.
     From the given list of string filter only those that represents valid IP addresses.
 */
public class Exercise03FilterByPattern {

  public static void main(String[] args) {
    List<String> strs = List.of("192.1.2.1","192.1.1","1.1.1.1","a.1.2.3.4","1.2.3.4.5","1.1.a.a","1234");

    Pattern pattern = Pattern.compile("^(\\d{1,3}\\.){3}\\d{1,3}$");
    List<String> result = strs.stream()
        .filter(pattern.asPredicate())
        .collect(Collectors.toList());

    for (String str : result) {
      System.out.println(str);
    }

    // Expected result: "192.1.2.1","1.1.1.1"
  }
}
