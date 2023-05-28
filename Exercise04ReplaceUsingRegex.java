package eu.unicorn.tga.javatraining.regularexpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
  1] Replace all commas that are surrounded by digits both from the right and the left side by dots.
     Example: Comma in "5,5" has to replaced by dot, so the result is "5.5".
     Comma in "a,5" must not be replaced because it is not surrounded from both sides.
     The same applies for ",5" and "5,".
 */
public class Exercise04ReplaceUsingRegex {

  public static void main(String[] args) {
    String str = "1,2;a,b.2,4,d,e,5,5.5;123,456";

    Pattern pattern = Pattern.compile("(?<=\\d),(?=\\d)");
    Matcher matcher = pattern.matcher(str);
    ;
    String result = matcher.replaceAll(".");

    System.out.println(result);

    // Expected result: "1.2;a,b.2.4,d,e,5.5.5;123.456"
  }
}
