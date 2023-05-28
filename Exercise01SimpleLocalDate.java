package eu.unicorn.tga.javatraining.datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/*
  1] Implement a program that outputs the number of days remaining until the next birthday for a given date of birth.
     The date of birth entered by the user will be in format dd.mm.yyyy where dd = day of the month, mm = month and yyyy = year.
 */
public class Exercise01SimpleLocalDate {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

    System.out.println("Enter your birthday (dd.mm.yyyy)");
    String birthdayStr = in.nextLine();
    LocalDate birthday = LocalDate.parse(birthdayStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    LocalDate today = LocalDate.now();
    LocalDate nextBirthday = birthday.withYear(today.getYear());
    if (nextBirthday.isBefore(today) || nextBirthday.isEqual(today)) {
      nextBirthday = nextBirthday.plusYears(1);
    }
    long daysUntilBirthDay = ChronoUnit.DAYS.between(today, nextBirthday);
    System.out.println("Days until birthday: "+ daysUntilBirthDay);

    // Expected result: depends on date of running the program and user's input :-) For example if we assume that today is 13.3.2023 and user entered 18.3.1990
    // then the program outputs 5 days until next birthday.

  }
}
