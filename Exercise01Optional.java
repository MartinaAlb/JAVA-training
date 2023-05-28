package eu.unicorn.tga.javatraining.optional;

import java.util.Optional;

/*
  1] Create an Optional that is
      1.1] Empty
      1.2] Non-empty and does not allow null values (only data without null values)
      1.3] Non-empty and allows null values
  2] Create an Optional with an inserted value and then check if the Optional contains the value and if so, perform the action of writing the value to the console.
     Avoid using the Optional methods isPresent/isEmpty/get.
  3] Create Optionals with an empty and filled value, then return the value from the Optional. In both cases, return the value from the Optional by calling only one method offered by the Optional.
     If the Optional is empty in the method you are using, return the default value you defined. So if Optional is empty return the default value you defined, otherwise return the Optional value.
     There are two methods for these purposes in Optional, use one of them and think about the difference from the other method.
  4] Do a similar task as in the previous point and use the ifPresentOrElse method with the difference that it takes Consumer as parameters - what it should do in case that Optional contains the value and
     Runnable in case it does not contain the value. For implementation, it is convenient to use Lambda Expression
  5] Let's try working with exceptions in the Optional. Create an empty Optional and try working with orElseThrow. To prevent the program from crashing, catch the exception in the try/catch block and
     print it to the console.
  6] Now it's the turn of the map method. Create an Optional containing the string, then call the map method which converts the string to upper case (use the method reference notation) and only if
     Optional contains a value, print it to the console.
*/
public class Exercise01Optional {

  public static void main(String[] args) {
    // 1]
    Optional<String> empty = Optional.empty();
    System.out.println(empty);

    Optional<String> opt = Optional.of("Radek");
    System.out.println(opt);

    String nullName = null;
    String name = Optional.ofNullable(nullName).orElseGet(() -> "John");
    System.out.println("Name: " + name);

    // 2]
    Optional<String> optional = Optional.of("zkusebni text");
    optional.ifPresent(value -> System.out.println(value.length()));

    // 3]
    Optional<String> emptyOptional = Optional.empty();
    Optional<String> filledOptional = Optional.of("hello world");

    String emptyValue = emptyOptional.orElse("default value");
    String filledValue = filledOptional.orElse("default value");

    System.out.println("Empty Optional value: " + emptyValue);
    System.out.println("Filled Optional value: " + filledValue);

    // 4]
    String nullName4 = null;
    Optional<String> optionalNullableString = Optional.ofNullable(nullName4);
    optionalNullableString.ifPresentOrElse(
        (name4) -> {
          System.out.println("Name: " + name4);
        },
        () -> {
          System.out.println("Name not present");
        }
    );

    // 5]
    Optional<String> emptyOptional5 = Optional.empty();
    try {
      String value = emptyOptional5.orElseThrow(() -> new Exception("Optional is empty"));
      System.out.println("Value: " + value);
    } catch (Exception e) {
      System.out.println("Caught exception: " + e.getMessage());
    }

    // 6]
    Optional<String> optionalString = Optional.of("hello, world!");
    optionalString.map(String::toUpperCase).ifPresent(upperCaseString -> {
      System.out.println("Uppercase string: " + upperCaseString);
    });
  }

}
