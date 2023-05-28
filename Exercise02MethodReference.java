package eu.unicorn.tga.javatraining.lambda;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 Create a shortened Lambda Expression notation - Method Reference.
    1] Write using method reference, which uses String.toUpperCase method
    2] Write using method reference, which uses the System.out.println method
    3] Write using method reference, use the StringWrapper class constructor statement
 */
public class Exercise02MethodReference {

  public static void main(String[] args) {
    // 1, 2
    Stream.of("This", "is", "a", "string")
        .map(String::toUpperCase)
        .forEach(System.out::println);

    // 3
    final List<StringWrapper> stringWrappers = Stream.of("This is a String1", "This is a String2")
        .map(StringWrapper::new)
        .collect(Collectors.toList());
    System.out.println(stringWrappers);
  }

  private static class StringWrapper {
    private final String wrapperedString;

    @Override
    public String toString() {
      return "StringWrapper{" +
          "wrapperedString='" + wrapperedString + '\'' +
          '}';
    }

    public StringWrapper(String wrapperedString) {
      this.wrapperedString = wrapperedString;
    }


  }

}
