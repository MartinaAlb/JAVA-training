package eu.unicorn.tga.javatraining.regularexpressions;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*
  1] Find all strings containing only digits in the strs list.
 */
public class Exercise01SimpleFilterByPattern {

  public static void main(String[] args) {
    List<String> strs = List.of("a123","123a","1a23","123","0123456789","abc","0.1");

    Pattern pattern = Pattern.compile("^[0-9]+$"); // TODO 1]
    List<String> result = strs.stream()
        .filter(pattern.asPredicate())
        .collect(Collectors.toList());

    for (String str : result) {
      System.out.println(str);
    }

    // Expected result: "123","0123456789"
  }
}
