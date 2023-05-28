package eu.unicorn.tga.javatraining.regularexpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
  1] OPTIONAL - Find all phone numbers within a given string. Phone number has to be nine digits long with +420 prefix or nine digits long without any prefix.
     Phone number must be followed by anything else then a digit (or not followed by anything at all).
     For example in string "+4201234567890" the "+420123456789" should not be found because it violates the rule that it must not be followed by a digit.
 */
public class Exercise07AdvancedMatcher {

  public static void main(String[] args) {
    String str = "My phone number is +420777888999, and my another number is 777888999." +
        "Well and I also have +42077788899 or  +42777666555 or +4201234567890";

    List<String> result = new ArrayList<>();
    Pattern pattern = Pattern.compile("(\\+420\\d{9}\\D)|(\\D\\d{9}\\D)");
    Matcher matcher = pattern.matcher(str);

    while (matcher.find()) {
      String phoneNumber = matcher.group().replaceAll("[^\\d\\+]", "");
      result.add(phoneNumber);
    }


    for (String phoneNumber : result) {
      System.out.println(phoneNumber);
    }

    // Expected result: "+420777888999","777888999"
  }
}
