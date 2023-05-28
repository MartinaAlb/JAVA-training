package eu.unicorn.tga.javatraining.streamapi;

import java.util.stream.Stream;

public class Exercise03OrderedStreams {

  public static void main(String[] args) {

    Stream.of("A!", "a2", "Unicorn!", "b3", "c")
        .map(String::toUpperCase)
        .filter(s -> s.endsWith("!"))
        .forEach(s -> System.out.println("forEach: " + s));

    Stream.of("A!", "a2", "Unicorn!", "b3", "c")
        .filter(s -> s.endsWith("!"))
        .map(String::toUpperCase)
        .forEach(s -> System.out.println("forEach: " + s));
  }
}
