package eu.unicorn.tga.javatraining.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Exercise00Collections {

  /*
  1] Try to create different types of collections, namely List, Set, Map. Create new instances in different ways using constructor and List, Set, Map classes and their static methods.
  2] Add new elements to collections (watch out for immutable collections, where you should expect different behavior than mutable collections)
  3] Create List and Set collections from the array
   */
  public static void main(String[] args) {
    // 1]
    List<String> stringMutableList = new ArrayList<>();// use the constructor to allocate the variable
    Set<String> stringMutableSet = new HashSet<>(); // use the constructor to allocate the variable
    Map<String, String> stringMutableMap = new HashMap<>(); // use the constructor to allocate the variable

    List<String> stringImmutableList = List.of("apple", "pear", "oragne");// use a List static method to allocate the variable
    Set<String> stringImmutableSet = Set.of("foo", "bar", "baz"); // use a List static method to allocate the variable
    Map<String, String> stringImmutableMap = Map.of("key1", "value1", "key2", "value2"); // use a List static method to allocate the variable

    // 2]
    stringMutableList.add("banana");
    stringMutableSet.add("quz");
    stringMutableMap.put("key3", "value3");
    // stringImmutableList
    List<String> newList = new ArrayList<>(stringImmutableList);
    newList.add("quz");
    // stringImmutableSet
    Set<String> newSet = new HashSet<>(stringImmutableSet);
    newSet.add("banana");
    // stringImmutableMap
    Map<String, String> newMap = new HashMap<>(stringImmutableMap);
    newMap.put("key3", "value3");

    // 3]
    int[] array = {1, 2, 3, 4, 5};
    List<Integer> listFromIntArray = new ArrayList<>();
    for (int i : array) {
      listFromIntArray.add(i);
    }
    Set<Integer> setFromIntArray = new HashSet<>();
    for (int i : array) {
      setFromIntArray.add(i);
    }

  }

}
