package eu.unicorn.tga.javatraining.regularexpressions;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
  1] OPTIONAL -  Assume that you have an html in a string variable. Find all element names used in that html.

     Hint: See Quantifier types and use appropriate greedy, reluctant or possessive quantifiers.
 */
public class Exercise10UsingQuantifierTypes {

  public static void main(String[] args) {
    String html = "<html>"
        + "  <header/>"
        + "  <body>"
        + "    <p>paragraf</p>"
        + "    <br/>"
        + "    <p>second paragraf</p>"
        + "  </body>"
        + "</html>";


    Set<String> result = new HashSet<>();
    Pattern pattern = Pattern.compile("<[^\\/].*?>");
    Matcher matcher = pattern.matcher(html);

    while (matcher.find()) {
      String tag = matcher.group();
      result.add(tag);
    }

    for (String tag : result) {
      System.out.println(tag);
    }
    // Expected result: "<html>","<header/>","<body>","<p>","<br/>"
  }
}
