package eu.unicorn.tga.javatraining.regularexpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
  1] Find all substrings of the str that contain only digits and have at least four characters.
 */
public class Exercise02SimpleMatcher {

  public static void main(String[] args) {
    String str = "First number 123, second number 4567, third number 56789, fourth number 67, 1a2b3c4d5";

    List<String> result = new ArrayList<>();
    Pattern pattern = Pattern.compile("\\d+");
    Matcher matcher = pattern.matcher(str);

    while (matcher.find()) {
      String numStr = matcher.group();
      if (numStr.length() >= 4) {
        result.add(numStr);
      }
    }

    for (String subStr : result) {
      System.out.println(subStr);
    }
    // Expected result: "4567","56789"
  }
}
