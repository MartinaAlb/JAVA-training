package eu.unicorn.tga.javatraining.regularexpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
  1] Convert all substrings enclosed in square brackets to upper case.
 */
public class Exercise09AnotherReplaceUsingRegex {

  public static void main(String[] args) {
    String text = "[error] NullPointerException at... [eRRoR] NullPointerException at... [INfo] NullPointerException at...";
    List<String> result = new ArrayList<>();
    Pattern pattern = Pattern.compile("\\[[^\\]]*\\]");
    Matcher matcher = pattern.matcher(text);

    StringBuffer sb = new StringBuffer();
    while (matcher.find()) {
      matcher.appendReplacement(sb, matcher.group().toUpperCase());
    }
    matcher.appendTail(sb);
    System.out.println(sb.toString());

    // Expected result: "[ERROR] NullPointerException at... [ERROR] NullPointerException at... [INFO] NullPointerException at...";
  }
}
