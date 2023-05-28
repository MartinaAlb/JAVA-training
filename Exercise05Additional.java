package eu.unicorn.tga.javatraining.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*
  OPTIONAL - THESE EXERCISES ARE NOT MANDATORY (bonus activity):

  Inputs:
  An employee class structure
    id,
    firstName,
    lastName,
    age,
    country
  Always think about what collection is right to use in exercises
*/
public class Exercise05Additional {

  public static void main(String[] args) {
    exercise1();
    exercise2();
    exercise3();
    exercise4();
  }

  private static void exercise1() {
    //Solve a problem where you have to find and store employees aged over 50
    List<Employee> employeesOver50 = employees.stream()
        .filter(employee -> employee.getAge() > 50)
        .collect(Collectors.toList());

    System.out.println("Employees aged over 50:");
    employeesOver50.forEach(System.out::println);
  }

  private static void exercise2() {
    // Solve a problem where you have to sort employees by country (natural and reverse sorting)
    employees.sort(Comparator.comparing(Employee::getCountry));
    System.out.println("\nEmployees sorted by country (natural):");
    employees.forEach(System.out::println);

    employees.sort(Comparator.comparing(Employee::getCountry).reversed());
    System.out.println("\nEmployees sorted by country (reverse):");
    employees.forEach(System.out::println);
  }

  private static void exercise3() {
    // Solve a problem where you have to quickly and effectively find an employees object by a given key id
    Map<Integer, Employee> employeeMap = new HashMap<>();
    for (Employee employee : employees) {
      employeeMap.put(employee.getId(), employee);
    }

    Employee employeeById = employeeMap.get(2);
    System.out.println("\nEmployee by ID: " + employeeById);
  }
  private static void exercise4() {
    Set<String> uniqueFirstNames = new HashSet<>();

    System.out.println("\nEmployees with unique first names:");
    for (Employee employee : employees) {
      if (uniqueFirstNames.add(employee.getFirstName())) {
        System.out.println(employee);
      }
    }
  }

  private static final List<Employee> employees;

  static {
    employees = new ArrayList<>(List.of(
        new Employee(1, "John", "Doe", 55, "USA"),
        new Employee(2, "Jana", "Kralova", 50, "Czech Republic"),
        new Employee(3, "Alice", "Black", 30, "UK"),
        new Employee(4, "Otto", "Albrecht", 5, "Germany"),
        new Employee(5, "Jana", "Novakova", 5, "Italy")

    ));
  }

  private static class Employee {

    private final int id;
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String country;

    public Employee(int id, String firstName, String lastName, int age, String country) {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.age = age;
      this.country = country;
    }

    public int getId() {
      return id;
    }

    public String getFirstName() {
      return firstName;
    }

    public String getLastName() {
      return lastName;
    }

    public int getAge() {
      return age;
    }

    public String getCountry() {
      return country;
    }

    @Override
    public String toString() {
      return "Employee{" +
          "id=" + id +
          ", firstName='" + firstName + '\'' +
          ", lastName='" + lastName + '\'' +
          ", age=" + age +
          ", country='" + country + '\'' +
          '}';
    }
  }
}

