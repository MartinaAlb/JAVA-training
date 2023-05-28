package eu.unicorn.tga.javatraining.streamapi;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
  Try different ways of creating a stream:
  1] From a collection like List/Set through stream method
  2] Stream.of method
  3] Stream.builder method
  4] Stream.generate method
  5] Stream.iterate method
  6] Stream.empty method
  7] IntStream.range method
 */
public class Exercise01StreamCreation {

  public static void main(String[] args) {
    printHeader("Type1 - List/Set through stream method");
    List<String> collection = List.of("a", "b", "c");
    Stream<String> streamOfCollection = collection.stream();

    printHeader("Type2 - Stream.of method");
    Stream<String> streamOfArray = Stream.of("a", "b", "c");

    printHeader("Type3 - Stream builder method");
    Stream<String> streamBuilder =
        Stream.<String>builder().add("a").add("b").add("c").build();

    printHeader("Type4 - Stream generate method");
    Stream<String> streamGenerated =
        Stream.generate(() -> "element").limit(10);

    printHeader("Type5 - Stream iterate method");
    Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);

    printHeader("Type6 - Stream empty method");
    Stream<String> streamOfArrayEmpty = Stream.empty();

    printHeader("Type7a - IntStream method");
    IntStream intStream = IntStream.range(1, 3);

  }

  private static void printHeader(String message) {
    System.out.println("==============================");
    System.out.println(message);
  }
}
