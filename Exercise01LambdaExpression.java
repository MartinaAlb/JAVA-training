package eu.unicorn.tga.javatraining.lambda;

import static java.lang.Integer.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
  1] Create Lambda Expression and assign it to a variable and then call the available Lambda method - in these cases the accept method
     1.1] Non-parametric Lambda Expression
            a) Without return type, which prints "Lambda Expression without parameter and return type" to the console (use LambdaWithoutParameter)
            b) With a return type that returns a randomly generated number (use LambdaWithoutParameterAndReturn)
     1.2] Parametric Lambda Expression
            a) With one parameter, which prints to the console the string "Lambda Expression with one parameter $inputParameter$". $inputParameter$ is variable (use LambdaWithParameter)
            b) With two parameters, which prints to the console the text "Lambda Expression with two parameters $inputParameter1$ and $inputParameter2$" (use LambdaWithParameters)
            c) With two parameters and a return type that returns the sum of both parameters (use LambdaWithParametersAndReturn)
   2] Use Lambda Expression to print elements using the print method
   3] Create a custom Comparator using Lambda Expression so that you will compare the Stock class first by name and then by exchange
 */
public class Exercise01LambdaExpression {

  public static void main(String[] args) {
    // 1]
    LambdaWithoutParameter lambdaWithoutParameter = () ->
        System.out.println("Lambda Expression without parameter and return type");
    lambdaWithoutParameter.accept();

    LambdaWithoutParameterAndReturn lambdaWithoutParameterAndReturn = () ->
        (int) (Math.random() * 100);
    int randomNum = lambdaWithoutParameterAndReturn.accept();
    System.out.println("Random number generated by Lambda Expression with return type: " + randomNum);

    LambdaWithParameter lambdaWithParameter = (text) ->
        System.out.println("Lambda Expression with one parameter " + text);
    lambdaWithParameter.accept("example text");

    LambdaWithParameters lambdaWithParameters = (int a, int b) ->
        System.out.println("Lambda Expression with two parameters " + a + " " + b);
    lambdaWithParameters.accept(1, 2);

    LambdaWithParametersAndReturn lambdaWithParametersAndReturn = (int a, int b) -> {
      System.out.println("Lambda with parameters and return type Sum: " + sum(a, b));
      return a + b;
    };
    int result = lambdaWithParametersAndReturn.accept(1, 2);
    System.out.println("Lambda with parameters and return type Result: " + result);

    // 2]
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    numbers.forEach(number -> print(number));

  // 3]
  final List<Stock> stocks = new ArrayList<>(List.of(
      new Stock("Tesla", 196.89, "NASDAQ"),
      new Stock("Apple", 151.01, "NASDAQ"),
      new Stock("Tesla", 196.89, "XETRA"),
      new Stock("Alphabet", 94.57, "NASDAQ")
  ));
    Comparator<Stock> stockComparator = Comparator.comparing(Stock::getName)
        .thenComparing(Stock::getExchange);

    stocks.sort(stockComparator);

    stocks.forEach(System.out::println);

  }


  // Used in 1.1.a]
  private interface LambdaWithoutParameter {

    void accept();
  }


  // Used in 1.1.b]
  private interface LambdaWithoutParameterAndReturn {

    int accept();
  }

  // Used in 1.2.a]
  private interface LambdaWithParameter {

    void accept(String text);
  }

  // Used in 1.2.b]
  private interface LambdaWithParameters {

    void accept(int number1, int number2);
  }

  // Used in 1.2.c]
  private interface LambdaWithParametersAndReturn {

    int accept(int number1, int number2);
  }


  private static void print(int element) {
    System.out.println(element * 10);
  }


  private static class Stock {

    public String getName() {
      return name;
    }

    public double getPrice() {
      return price;
    }

    public String getExchange() {
      return exchange;
    }

    private final String name;
    private final double price;

    private final String exchange;

    public Stock(String name, double price, String exchange) {
      this.name = name;
      this.price = price;
      this.exchange = exchange;
    }

    @Override
    public String toString() {
      return "Stock{" +
          "name='" + name + '\'' +
          ", price=" + price +
          ", exchange='" + exchange + '\'' +
          '}';
    }
  }

}
