package eu.unicorn.tga.javatraining.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
  1] Try working with Collections. In the assignment you will find a List, which will contain elements of class Human. Then use a method in Collections/List that allows you to sort collections.
     You can do the same by calling the appropriate method on the List instance.

     For the first sorting, use this comparator.

     final Comparator<Human> humanComparator = Comparator.comparing((Human h) -> h.firstNane)
             .thenComparing(h -> h.surname)
             .thenComparingInt(h -> h.age);

  2] Try shuffling the List and sorting by age in ascending order, the second criterion for sorting will be descending sorting by surname.
  3] Next, sort the list first by last name in descending order and then by first name in ascending order. You can change the comparator at will and test its effect on the sorting.
     Check the other methods offered by Collections and List class/interface.
*/
public class Exercise04CollectionSorting {

  public static void main(String[] args) {
    List<Human> humans = new ArrayList<>(List.of(
        new Human(18, "Peter", "Smith"),
        new Human(10, "John", "Smith"),
        new Human(26, "John", "Brown"),
        new Human(22, "Ada", "Williams"),
        new Human(18, "Lauren", "Davis")
    ));
    System.out.println("\nHumans");
    humans.forEach(System.out::println);
    final Comparator<Human> humanComparator = Comparator.comparing((Human h) -> h.firstNane)
        .thenComparing(h -> h.surname)
        .thenComparingInt(h -> h.age);
    humans.sort(humanComparator);
    System.out.println("\nAfter sorting by firstname (ascending)");
    humans.forEach(System.out::println);

    Collections.shuffle(humans);
    Comparator<Human> ageSurnameComparator = Comparator.comparingInt(Human::getAge)
        .thenComparing(Human::getSurname, Comparator.reverseOrder());
    humans.sort(ageSurnameComparator);
    System.out.println("\nShuffled and sorted by age (ascending) and surname (descending):");
    humans.forEach(System.out::println);

    Comparator<Human> surnameFirstNameComparator = Comparator.comparing(Human::getSurname, Comparator.reverseOrder())
        .thenComparing(Human::getFirstNane);
    Collections.sort(humans, surnameFirstNameComparator);
    System.out.println("\nSorted by surname (descending) and first name (ascending):");
    humans.forEach(System.out::println);
  }

  private static class Human {

    private final int age;
    private final String firstNane;
    private final String surname;

    public Human(int age, String firstNane, String surname) {
      this.age = age;
      this.firstNane = firstNane;
      this.surname = surname;
    }

    public int getAge() {
      return age;
    }

    public String getFirstNane() {
      return firstNane;
    }

    public String getSurname() {
      return surname;
    }

    @Override
    public String toString() {
      return "Human{" +
          "age=" + age +
          ", name='" + firstNane + '\'' +
          ", surname='" + surname + '\'' +
          '}';
    }
  }
}