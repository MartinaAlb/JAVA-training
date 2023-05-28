package eu.unicorn.tga.javatraining.generics;

import java.util.ArrayList;
import java.util.List;

public class Exercise01GenericCollectionBasics {

  /*
  1] Declaration of a generic collection
     1.1] Declare a generic collection of type List Integer with name integerList, where in the constructor select the implementing class ArrayList and use the diamond operator for
          automatic type determination,
     1.2] Declare a generic collection of type List Car with name cars, where use the diamond operator to create an instance,
     1.3] Declare a generic collection of type List PersonalCar with name personalCars, where you create an instance using the diamond operator.
  2] Now we'll try to insert different elements into the collection and see if the operation is valid. General instructions - comment out non-valid code for evaluation purposes.
     2.1] Insert an integer number into the integerList collection and then try to insert a data type other than integer. Observe how genericity prevents the insertion of a different data type
          and thus increases protection.
     2.2] Insert the following instances of the Car, PersonalCar, ColorfulPersonalCar and Truck classes into the cars collection. Then print the collection to the console using the forEach and Lambda Expression methods.
          The name will appear in the output, because you will notice that we don't have any other fields available, even though we have different instances of the classes in the collection. We only have the fields of the declared
          type in the collection (Car) and if we needed to work with the fields of a given subtype (PersonalCar, ColorfulPersonalCar, Truck), we would have to use casting and
          type checks (e.g. instanceof operator, or a dynamic variant like the isAssignableFrom method).
     2.3] Insert the following instances of the PersonalCar, Car classes into the personalCars collection and verify in practice that it is not possible to insert the class ancestor into the collection
   */
  public static void main(String[] args) {
    // 1.1]
    List<Integer> integerList = new ArrayList<>();
    // 2.1]
    integerList.add(1);
    // integerList.add("Ahoj"); //error: incompatible types: String cannot be converted to Integer
    System.out.println(integerList);

    // 1.2]
    List<Car> cars = new ArrayList<>();
    // 2.2]
    cars.add(new Car("New car"));
    cars.add(new PersonalCar("New personal car", "Martina"));
    cars.add(new ColorfulPersonalCar("New colofrul personal car", "Jakub", "Red"));
    cars.add(new Truck("New truck", 12));
    cars.forEach(car -> System.out.println(car.name));

    for (Car car : cars) {
      if (car instanceof PersonalCar) {
        PersonalCar personalCar = (PersonalCar) car;
        System.out.println(personalCar.owner);
      }
    }

    cars.forEach(car -> {
      if (car instanceof PersonalCar) {
        PersonalCar personalCar = (PersonalCar) car;
        System.out.println(personalCar.owner);
      }
    });

    // 1.3]
    List <PersonalCar> personalCars = new ArrayList<>();
    // 2.3]
    personalCars.add(new PersonalCar("Second personal car", "Jakub"));
    // personalCars.add(new Car("Second car")); // error: incompatible types: Car cannot be converted to PersonalCar
    personalCars.forEach(personalCar -> System.out.println(personalCar.name));

  }

  public static class Car {
    protected String name;

    public Car(String name) {
      this.name = name;
    }
  }

  public static class PersonalCar extends Car {
    private final String owner;

    public PersonalCar(String name, String owner) {
      super(name);
      this.owner = owner;
    }
  }

  public static class ColorfulPersonalCar extends PersonalCar {
    private final String color;

    public ColorfulPersonalCar(String name, String owner, String color) {
      super(name, owner);
      this.color = color;
    }
  }

  public static class Truck extends Car {
    private final int hp;

    public Truck(String name, int hp) {
      super(name);
      this.hp = hp;
    }
  }

}
