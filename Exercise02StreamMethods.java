package eu.unicorn.tga.javatraining.streamapi;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
  Try some methods used in the Stream API (forEach, map, filter, max, min, distinct, collect, ...).
  The Stream API very often uses Lambda expression, or also shortened Method reference. These topics will be discussed in the exercises and in the book later.
  To create the exercises, either study the topics (more appropriate) or use the classic new Interface approach for now.
*/
public class Exercise02StreamMethods {

  public static void main(String[] args) {
    // 1]
    Stream<Integer> forEachStream = Stream.of(1, 2, 3, 4, 5);
    forEachStream.forEach(i -> System.out.print(i + " "));
    System.out.println();

    // 2]
    final Stream<String> mapStream = Stream.of("This", " is ", "Stream", ".map ", "example");
    mapStream.map(s -> s.toUpperCase())
        .forEach(s -> System.out.print(s));
    System.out.println();

    // 3]
    final Stream<Integer> filterStream = Stream.of(5, 8, 11, 10, 4, 13);
    filterStream.filter(s -> s > 10)
        .forEach(s -> System.out.print(s + " "));
    System.out.println();

    // 4]
    final Stream<Integer> maxStream = Stream.of(5, 8, 11, 10, 4, 13);
    Optional<Integer> max = maxStream.max(Integer::compareTo);
    System.out.println("Maximum value: " + max.orElse(null));

    final Stream<Integer> minStream = Stream.of(5, 8, 11, 10, 4, 13);
    Optional<Integer> min = minStream.min(Integer::compareTo);
    System.out.println("Minimum value: " + min.orElse(null));

    // 5]
    final Stream<Integer> distinctStream = Stream.of(5, 8, 11, 8, 10, 4, 11, 13);
    Stream<Integer> uniqueStream = distinctStream.distinct();
    uniqueStream.forEach(s -> System.out.print(s + " "));

    // 6]
    final Stream<String> collectListStream = Stream.of("This", " is ", "Stream", ".collect ", "method", "example");
    List<String> list = collectListStream.collect(Collectors.toList());
    System.out.println("\nList: " + list);
    final Stream<String> collectSetStream = Stream.of("This", " is ", "Stream", ".collect ", "method", "example");
    Set<String> set = collectSetStream.collect(Collectors.toSet());
    System.out.println("Set: " + set);
    final Stream<String> collectMapStream = Stream.of("This", " is ", "Stream", ".collect ", "method", "example");
    Map<String, String> map = collectMapStream
        .distinct()
        .collect(Collectors.toMap(s -> s, Function.identity()));
    System.out.println("Map: " + map);

    // 7]
    final Stream<Integer> reduceStream = Stream.of(1, 2, 3, 4);
    int sum = reduceStream.reduce(0, (x, y) -> x + y);
    System.out.println("Sum: " + sum);

    // 8]
    final Stream<Integer> consumedStream = Stream.of(1, 2, 3, 4);
    final long itemCount = consumedStream.count();
    System.out.println("Item count: " + itemCount);

    /*
    final long itemCountTwo = consumedStream.count();
    System.out.println("Item count two: " + itemCountTwo);
    consumedStream uz byl vyuzit
    */

    // 9]
    final Stream<Integer> parallelStream = Stream.of(5, 8, 11, 8, 10, 4, 11, 13);
    parallelStream.parallel().forEach(i -> System.out.println(i));
  }
}
