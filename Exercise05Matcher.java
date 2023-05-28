package eu.unicorn.tga.javatraining.regularexpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
  1] Find all occurrences of substring "error" within given string. The search must not be case-sensitive.
     i.e. "erRor", "ERROR", "eRRoR", etc. are valid occurrences.
 */
public class Exercise05Matcher {

  public static void main(String[] args) {
    String str = "Error, ERROR, ErroR, error,eRRor,something, errrr";


    List<String> result = new ArrayList<>();
    Pattern pattern = Pattern.compile("(?i)error");
    Matcher matcher = pattern.matcher(str);
    while (matcher.find()) {
      result.add(matcher.group());
    }
    for (String subStr : result) {
      System.out.println(subStr);
    }
    // Expected result: "Error","ERROR","ErroR","error","eRRor"
  }
}
