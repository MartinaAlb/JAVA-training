package eu.unicorn.tga.javatraining.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Exercise03Map {

  public static void main(String[] args) {
    exercise1();
    exercise2();
    exercise3();
  }

  private static void exercise1() {
    // 1] Write a program to add elements to the HashMap given the key and value, data type is String for both. Check if the HashMap is empty
    Map<String, String> map = new HashMap<>();
    map.put("key1", "value1");
    map.put("key2", "value2");
    map.put("key3", "value3");

    if (map.isEmpty()) {
      System.out.println("HashMap is empty.");
    } else {
      System.out.println("HashMap is not empty.");
      System.out.println("HashMap contents: " + map);
    }
  }

  private static void exercise2() {
    // 2] Write a program with Map interface and an appropriate implementation class where keys will be naturally sorted by default.
    //      Try it with primitive data type like String or Integer for example
    Map<String, Integer> map = new TreeMap<>();

    map.put("Alena", 30);
    map.put("Barbora", 25);
    map.put("Cecilie", 35);
    map.put("David", 20);

    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }

  private static void exercise3() {
// 3] Create a variable of the Map interface, which is implemented by the HashMap implementation.
    //      Use String as the key and as the values use a List of numbers.
    //      We can imagine that the Map key will be a name of a mobile operator and the values will be its mobile prefixes.
    //      Something like: "Vodafone": List of prefixes like [775, 776, ...], ....
    //      Try to find the given operator by its key and list all its assigned prefixes
    //      Iterate through the Map and list all the mobile operators and all the prefixes
    Map<String, List<Integer>> mobileOperators = new HashMap<>();

    mobileOperators.put("Vodafone", Arrays.asList(775, 776, 777));
    mobileOperators.put("O2", Arrays.asList(791, 792, 793));
    mobileOperators.put("T-Mobile", Arrays.asList(700, 701, 702));

    String operator = "Vodafone";
    List<Integer> prefixes = mobileOperators.get(operator);
    System.out.println(operator + " prefixes: " + prefixes);

    for (Map.Entry<String, List<Integer>> entry : mobileOperators.entrySet()) {
      System.out.println(entry.getKey() + " prefixes: " + entry.getValue());
    }
  }

}
