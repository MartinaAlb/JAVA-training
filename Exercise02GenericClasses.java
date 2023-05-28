package eu.unicorn.tga.javatraining.generics;

/*
The purpose of this exercise is to try working with generic classes and interfaces.

1] Working with a generic class.
   1.1] Create a generic class that can store and return a generic type - the name of the class will be GenericWrapper. The class contains the generic type T and also includes fields of this type called value.
        To set a generic value in the class, a parametric constructor is used that accepts this value as a parameter. To return the state of the generic field, the class will have
        method called getValue. The get method does not accept any parameter and only returns the generic field.
   1.2] To test this, create a new instance of the GenericWrapper generic class with 2 different types (2 instances) and store the individual calls of the get method in a variable.
2] Working with a generic interface.
   2.1] Create a generic interface called SimpleCalculator that contains the generic compute method. The compute method accepts two parameters of the generic type and returns the generic type at the same time.
        The generic interface created in this way is also marked as a functional interface using the appropriate annotation.
   2.2] Create two instances of the SimpleCalculator functional interface using Lambda Expression. The first instance will be of generic type Double named doubleAddSimpleCalculator. The second instance will be of generic type Integer
        named integerMultiplySimpleCalculator. The doubleAddSimpleCalculator instance will add the two given parameters and return the result sum. An instance of integerMultiplySimpleCalculator will add the two specified
        parameters and return the resulting multiple. In both cases, store the results in variables.
 */
public class Exercise02GenericClasses {

  public static void main(String[] args) {
    // 1.2]
    GenericWrapper<String> stringWrapper = new GenericWrapper<>("Hello, world!");
    String stringValue = stringWrapper.getValue();
    System.out.println(stringValue);

    GenericWrapper<Integer> intWrapper = new GenericWrapper<>(42);
    int intValue = intWrapper.getValue();
    System.out.println(intValue);

    // 2.2]
    SimpleCalculator<Double> doubleAddSimpleCalculator = (a, b) -> a + b;
    double doubleResult = doubleAddSimpleCalculator.compute(2.0, 3.5);
    System.out.println(doubleResult);
    SimpleCalculator<Integer> integerMultiplySimpleCalculator = (a, b) -> a * b;
    int integerResult = integerMultiplySimpleCalculator.compute(4, 7);
    System.out.println(integerResult);
  }

  // 1.1]
  private static class GenericWrapper<T> {
    private T value;

    public GenericWrapper(T value) {
      this.value = value;
    }

    public T getValue() {
      return value;
    }
  }

  // 2.1]
  private interface SimpleCalculator<T> {
    T compute(T a, T b);
  }
}