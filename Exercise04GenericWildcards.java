package eu.unicorn.tga.javatraining.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/*
    In these exercises we will discuss working with generics and wildcards  (unbound, upper and lower bound)
    1] Unbound wildcard (? character)
       1.1] Create three different collections of the List type with generic types String, Integer, Object and insert values into them.
       1.2] Create a static method named printListItems, which has as a type parameter a generic List with unbound character (collection of any type) called list.
            The method will iterate through the parameter named list and print the contents of the collection to the console.
            Notice that the unbound operator is used for traversing various collections of unknown types and for working with elements - reading, as Object type,
            because we don't know what type comes up in the collection. Writing to an unbound collection is impossible for this reason.
       1.3] Call the printListItems method for all three declared collections.
    2] Upper bound wildcards
       2.1.1] Create a static method named sumAsDouble, which will be of generic type T and type T uses an upper bound wildcard bound to class Number (<T extends Number>), returns Number
              and has two parameters of type T. The method adds the two generic parameters by calling the doubleValue() method on the parameters.
       2.1.2] Call the sumAsDouble method and set the arguments to the values of the Number descendants.
              FYI, the upper bound wildcard allows you to set the given generic type and its descendants to method parameters (or return) and to use methods of the specified
              generic type from generic variables but not of already inserted descendants.
       2.1.3] Try to call the sumAsDouble method with arguments other than the Number type and its descendants - due to the upper bound check it is not possible to insert an ancestor
              or another data type. Comment out method calls with incompatible type for revision purposes.
       2.2.1] Create a static method named sumNumbers, which has the return type void and accepts as parameter the Collection type with Number upper bound named collection.
              The sumNumbers method performs a sum of all elements of the collection (the result is a double sum) and prints it to the console.
       2.2.2] Call the sumNumbers method, where when calling it, insert generic collections of the Number type (use different data types of elements inside it), Integer and Double as parameters.
    3] Lower bound wildcards
       3.1] Create a static method named addCatObject, which has the return type void and two input parameters. The first parameter is a List with lower bound Cat type named catList,
            the second parameter is a Cat type named cat. Within the method, store a new element of the cat parameter into the catList parameter. Next, type the string "addCatObject method iteration" into the console.
            and iterate through the catList collection - it will list all instances that are occupied.
       3.2] This step already contains all the logic needed to call the addCatObject method. After implementing step 3.1], uncomment the appropriate method call and follow
            the behavior of the lower bound wildcard when working with different types of collections.
   */
public class Exercise04GenericWildcards {

  public static void main(String[] args) {
    unboundWildcards();
    upperBoundWildcards();
    lowerBoundWildcards();
  }

  private static void unboundWildcards() {
    // 1.1] and 1.3]
    List<String> stringList = new ArrayList<>();
    stringList.add("Hello");
    stringList.add("world");

    List<Integer> integerList = new ArrayList<>();
    integerList.add(1);
    integerList.add(2);

    List<Object> objectList = new ArrayList<>();
    objectList.add("Hello");
    objectList.add(2);

    printListItems(stringList);
    printListItems(integerList);
    printListItems(objectList);

  }

  private static void upperBoundWildcards() {
    // 2.1.2] and 2.1.3]
    Integer num1 = 5;
    Double num2 = 4.2;
    final Number number = sumAsDouble(num1, num2);
    System.out.println("sumAsInt result: " + number);

    // String str = "test";
    // sumAsDouble(num1, str); //error: method sumAsDouble in class Exercise04GenericWildcards cannot be applied to given types;

    // 2.2.2]
    List<Integer> intList = Arrays.asList(1, 2, 3);
    List<Double> doubleList = Arrays.asList(1.5, 2.5, 3.5);
    sumNumbers(intList);
    sumNumbers(doubleList);
  }

  private static void lowerBoundWildcards() {
    // 3.2]
    final List<? super Cat> cats = new ArrayList<>(List.of(new Cat(), new RedCat(), new Animal(), new Dog()));
    final List<Cat> cats1 = new ArrayList<>(List.of(new Cat()));
    final List<Animal> animals = new ArrayList<>(List.of(new Dog(), new Cat(), new Animal(), new RedCat()));
    final List<RedCat> redCats = new ArrayList<>(List.of(new RedCat()));
    final List<Dog> dogs = new ArrayList<>(List.of(new Dog()));

    System.out.println("lowerBoundWildcards cats list");
    addCatObject(cats, new RedCat());
    System.out.println("lowerBoundWildcards cats1 list");
    addCatObject(cats1, new Cat());
    System.out.println("lowerBoundWildcards animals list");
    addCatObject(animals, new Cat());
    // addCatObject(redCats, new Cat()); // error: incompatible types: List<RedCat> cannot be converted to List<? super Cat>
    // addCatObject(dogs, new Cat()); // error: incompatible types: List<Dog> cannot be converted to List<? super Cat>
  }

  // 1.2]
  public static void printListItems(List<?> list) {
    for (Object element : list) {
      System.out.println(element);
    }
  }

  // 2.1.1]
  public static <T extends Number> Number sumAsDouble(T num1, T num2) {
    double sum = num1.doubleValue() + num2.doubleValue();
    return sum;
  }

  // 2.2.1]
  public static void sumNumbers(Collection<? extends Number> collection) {
    double sum = 0;
    for (Number num : collection) {
      sum += num.doubleValue();
    }
    System.out.println("Sum is: " + sum);
  }

  // 3.1]
  public static void addCatObject(List<? super Cat> catList, Cat cat) {
    catList.add(cat);
    System.out.println("addCatObject method iteration");
  }


  private static class Animal {}
  private static class Cat extends Animal {}
  private static class RedCat extends Cat {}
  private static class Dog extends Animal {}
}