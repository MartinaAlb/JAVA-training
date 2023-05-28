package eu.unicorn.tga.javatraining.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;


/*
  1] Write a program to read the contents of a file named "input.txt" and display it on the console using the try-with-resources statement.
     1.1] the "input.txt" will be your defined file outside the project with your content
     1.2] the "input.txt" will be the defined file inside the project in the resources folder
 */

public class Exercise01TryWithResource {

  public static void main(String[] args) {

    try (BufferedReader reader = Files.newBufferedReader(Paths.get("C:\\Users\\user\\Desktop\\MAlbrechtova\\input.txt"))) {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    try (BufferedReader reader = Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource("input.txt").toURI()))) {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException | URISyntaxException e) {
      e.printStackTrace();
    }

  }
}