package eu.unicorn.tga.javatraining.functionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Exercise02BuiltInFunctionalInterfaces {
  /*
  1] Declare the functional interface Function so that it accepts Integer, returns String and create a simple implementation using lambda expression or method reference.
     The functional interface created in this way will convert Integer to String and return it. Then call the functional interface and check the result.
  2] Get to know the basic functional interfaces that are often used in Java - declare the given functional interface and then call it
      2.1] Predicate - create an implementation that decides if the age is older than 18 (Predicate is often used in Streams and e.g. filter methods)
      2.2] Consumer - create an implementation which prints any text (input parameter) to the console (Consumer is often used in Streams and e.g. forEach method)
      2.3] Supplier - create an implementation that returns random numbers in a range 100 - 200 (Supplier is used in Streams e.g. in the generate method)
      2.4] Function - create an implementation that takes an input parameter (string) and returns the string "Hello $inputParameter$" (Function is often used in Streams and e.g. map method)
  3] Let's create a slightly more complex example focusing on the use of functional interfaces
     3.1] Let's create a class Student, which will have the firstName, lastName, score and a constructor, which accepts all the named fields. The Student class will also contain a printer method
          without return type with a parameter of type Consumer<Student> and a parameter named studentPrinter. The printer method will print the given student instance to the console according to
          the Consumer parameter (this will achieve dynamic behavior).
     3.2] Let's create another overloaded version of the printer method, which has a declaration public void printer(List<Consumer<Student>> studentPrinters). This variant of the printer method iterates over the list of consumers
          and calls the iterated consumer at each iteration, taking the current student instance as a parameter. From the Student class, this will be all.
     3.3] Create a collection of 3 students and iterate over them using the forEach method. In the iteration, call the printer method from the Student class and insert Consumer<Student> as a parameter, which will be described later in the text.
          This will ensure that each Student will behave according to the behavior (algorithm) that you insert externally and is not part of the Student class.
          In the same way, use the second overloaded printer method, which takes the Student Consumer List. Create the list of consumers from the consumers described below.

          Printers (Consumer<Student>) do the following:
            - a printer that prints the student's first and last name
            - a printer that prints the student's name, surname and score
   */
  private static class Student {
    // 3.1] and 3.2]
      private String firstName;
      private String lastName;
      private int score;

      public Student (String firstName, String lastName, int score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
      }

    public void printer(Consumer<Student> studentPrinter) {
      studentPrinter.accept(this);
    }

    public static void printer(List<Consumer<Student>> studentPrinters, Student student) {
      for (Consumer<Student> studentPrinter : studentPrinters) {
        studentPrinter.accept(student);
      }
    }

    public String getFirstName() {
      return firstName;
    }

    public String getLastName() {
      return lastName;
    }

    public int getScore() {
      return score;
    }
  }

  public static void main(String[] args) {
    // 1]
    Function<Integer, String> integerToString = i -> i.toString();
    String result = integerToString.apply(42);
    System.out.println(result);

    // 2]
    // 2.1]
    Predicate<Integer> isOlderThan18 = age -> age > 18;

    boolean resultAge = isOlderThan18.test(20);
    System.out.println(resultAge); // Output: true

    boolean resultAgeTwo = isOlderThan18.test(16);
    System.out.println(resultAgeTwo); // Output: false

    // 2.2]
    Consumer<String> printConsumer = text -> System.out.println(text);
    printConsumer.accept("Hello, world!");

    // 2.3]
    Supplier<Integer> randomNumberSupplier = () -> {
      Random random = new Random();
      return random.nextInt(101) + 100;
    };
    int randomNumber = randomNumberSupplier.get();
    System.out.println(randomNumber);

    // 2.4]
    Function<String, String> stringFunction = text -> "Hello," + " " + text + "!";
    String resultStringFunction = stringFunction.apply("Radek");
    System.out.println(resultStringFunction);

    // 3.3]
    List<Student> students = new ArrayList<>();
    students.add(new Student("Jan", "Novak", 85));
    students.add(new Student("Jana", "Kralova", 95));
    students.add(new Student("Bohdan", "Slama", 75));


    Consumer<Student> studentNamePrinter = student ->
        System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());

    Consumer<Student> studentInfoPrinter = student ->
        System.out.println("Name: " + student.getFirstName() + " " + student.getLastName() + ", Score: " + student.getScore());

    students.forEach(student -> student.printer(studentNamePrinter));
    students.forEach(student -> student.printer(studentInfoPrinter));
  }

}
