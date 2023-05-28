package eu.unicorn.tga.javatraining.files;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
  1] Write a Java program that uses BufferedInputStream and BufferedOutputStream to copy a file from one location to another. The program should read the contents of the file using
     BufferedInputStream and write the contents to a new file using BufferedOutputStream.
 */
public class Exercise03BinaryFiles {
  private static void copyFile(String sourceFile, String destFile) throws IOException {

    try (BufferedInputStream inStream = new BufferedInputStream(new FileInputStream(sourceFile)); BufferedOutputStream outStream = new BufferedOutputStream(new FileOutputStream(destFile))) {

      byte[] buffer = new byte[1024];

      int length;
      while ((length = inStream.read(buffer)) > 0) {
        outStream.write(buffer, 0, length);
      }

      System.out.println("File copied successfully!");
    }
  }

  public static void main(String[] args) {
    String sourceFile = "C:\\Users\\user\\Desktop\\MAlbrechtova\\input.txt";
    String destFile = "C:\\Users\\user\\Desktop\\MAlbrechtova\\kopie\\output.txt";

    try {
      copyFile(sourceFile, destFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
