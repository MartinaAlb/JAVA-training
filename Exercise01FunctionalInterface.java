package eu.unicorn.tga.javatraining.functionalinterface;

/*
  1a] Create your own functional interface, which will be properly annotated. The interface will be called Calculator and will have the int compute(int value1, int value2) method.
  1b] Create different instances of this interface using a lambda expression.
  2] Interface static methods - add two static methods to the created functional interface and call them. The design and implementation of the static methods is up to you.
  3] Interface default methods - add two default methods to the created functional interface and call them. The design and implementation of the default methods is up to you.
*/
public class Exercise01FunctionalInterface {

  public static void main(String[] args) {
    // 1b] call the add method
    Calculator addition = (value1, value2) -> value1 + value2;
    int result = addition.compute(10, 5);
    System.out.println("The result of the addition operation is: " + result);

    // 2] call the static methods
    System.out.println("The result of the division operation is: " + Calculator.division(10, 5));
    System.out.println("The result of the multiplication operation is: " + Calculator.multiplication(10, 5));

    // 3] call the default method
    Calculator calculator = new Calculator() {
      @Override
      public int compute(int value1, int value2) {
        return 0;
      }
    };
    System.out.println(calculator.hello());
    System.out.println(calculator.substraction(10, 5));
  }

    // 1a], 2], 3]
    @FunctionalInterface
    interface Calculator {

      int compute(int value1, int value2);

      default String hello() {
        return ("Hello!");
      }

      default int substraction(int value1, int value2) {
        return (value1 - value2);
      }

      static int multiplication(int value1, int value2) {
        return (value1 * value2);
      }

      static int division(int value1, int value2) {
        return (value1 / value2);
      }
    }
}
