// nerozumim zadani 3.2]In the case of an own custom object type Human. Remember that your own object type (Human) must not violate the equals and hashcode contract.
//     //           What happens if the equals and hashcode contract is broken? Try both scenarios.

package eu.unicorn.tga.javatraining.collections;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Exercise02Set {

  public static void main(String[] args) {
    exercise1();
    exercise2();
  }

  private static void exercise1() {
    // 1a] Write a program to traverse (iterate) a HashSet of integers, then write iterated values to the console
    Set<Integer> integers = new HashSet<>(Set.of(3, 1, 7, 5));
      for (int i : integers) {
        System.out.println(i);
      }

    // 1b] Print the number of items in the collection
    System.out.println("Number of items: " + integers.size());

    // 1c] Add a duplicate item that is already in the collection
    integers.add(1);

    // 1d] Print the number of items in the collection and think about the result
    System.out.println("Number of items: " + integers.size()); // set can not storage duplicity

    // 2] Do the same with TreeSet and see what the differences are from the HashSet implementation
    integers = new TreeSet<>(Set.of(3, 1, 7, 5));
    for (int i : integers) {
      System.out.println(i);
    }
    System.out.println("Number of items: " + integers.size());
    integers.add(3);
    System.out.println("Number of items: " + integers.size());
  }

  private static void exercise2() {
    //Check if an element exists in the HashSet (the HashSet has to contain minimum of 5 elements)
    // 3.1] In the case of a primitive type (Integer or String for example)
    Set<Integer> integers = new HashSet<>(Set.of(3, 1, 7, 5));
      if (integers.size() >= 5) {
        System.out.println("Contains element 3: " + integers.contains(3));
      }
      else System.out.println("HashSet contains les than 5 elements");

    // 3.2]In the case of an own custom object type Human. Remember that your own object type (Human) must not violate the equals and hashcode contract.
    //           What happens if the equals and hashcode contract is broken? Try both scenarios.

    Human peter = new Human(18, "Peter", "Scarab");

    Set<Human> humans = new HashSet<>(Set.of(
        new Human(18, "Peter", "Scarab"),
        new Human(10, "John", "Smith"),
        new Human(26, "Luc", "Brown"),
        new Human(22, "Ada", "Williams"),
        new Human(17, "Lauren", "Davis")
    ));

      boolean containsPeter = humans.contains(new Human(18, "Peter", "Scarab"));

      System.out.println("Contains human named Peter: " + containsPeter);
    }

  private static class Human {
    private final int age;
    private final String firstName;
    private final String surname;

    public Human(int age, String firstName, String surname) {
      this.age = age;
      this.firstName = firstName;
      this.surname = surname;
    }

    @Override
    public String toString() {
      return "Human{" +
          "age=" + age +
          ", name='" + firstName + '\'' +
          ", surname='" + surname + '\'' +
          '}';
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Human))
        return false;
      Human human = (Human) o;
      return age == human.age && firstName.equals(human.firstName) && surname.equals(human.surname);
    }

    @Override
    public int hashCode() {
      return Objects.hash(age, firstName, surname);
    }
  }
}