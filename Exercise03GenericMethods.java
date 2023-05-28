package eu.unicorn.tga.javatraining.generics;

import java.util.function.Predicate;

/*
  1] This set of exercises will focus on working with generic methods
     1.1] Create a generic static method called isEqual that will compare whether or the values of two generic parameters are equal and return a boolean indicating whether this is true.
     1.2] Call the method you created by inserting two strings into the parameter and storing the value in the isStringEqual variable.
          In this variant, the generic type is determined automatically according to the specified parameters.
     1.3] Try calling the isEqual method with an explicit specified generic type, namely String. The method allows you to specify only parameters of the String type.
          1.3.1] Enter String values for both parameters - the compiler should not give you an error
          1.3.2] Enter different types of parameters (at least one different from String) - the compiler should report an error. Comment out the line for revision purposes.
 */
public class Exercise03GenericMethods {

  // 1.1]
  public static <T> boolean isEqual(T a, T b) {
    return a.equals(b);
  }

  public static void main(String[] args) {
    // 1.2]
    String str1 = "Hello";
    String str2 = "hello";
    boolean isStringEqual = isEqual(str1, str2);
    System.out.println("Is string equal? " + isStringEqual);

    // 1.3]
    String str3 = "Hello";
    String str4 = "hello";

    boolean isStringEqual2 = GenericWrapper.isEqual(str3, str4);
    System.out.println("Are the strings equal? " + isStringEqual2);

    // int num = 5;
    // boolean isStringNumEqual = GenericWrapper.<String>isEqual(str3, num); //error: incompatible types: int cannot be converted to String
    // System.out.println("Are the string and integer equal? " + isStringNumEqual);
  }

  private static class GenericWrapper {

    public static <T> boolean isEqual(T obj1, T obj2) {
      return obj1.equals(obj2);
    }
  }
}
