package eu.unicorn.tga.javatraining.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import java.io.BufferedWriter;

/*
  1] Write a program that reads a file named "input.txt" and counts the number of lines in the file using the Files.lines() method.
     The program should use try-with-resources to automatically close the file after reading it.
  2] Write a program that reads a file named "input.txt" and counts the number of lines in the file using the Files.lines() method but only in the case that the line contains the Java word.
     The program should use try-with-resources to automatically close the file after reading it.
  3] Write a program that reads a text file with multiple lines and for each line prepend the line number and write the modified file as a new file.
     Assume that the file being processed may be very large and therefore choose appropriate methods for working with large files.
 */
public class Exercise02TextFiles {

  public static long countLines(String filename) {
    try (Stream<String> stream = new BufferedReader(new InputStreamReader(
        Objects.requireNonNull(Exercise02TextFiles.class.getResourceAsStream(filename))))
        .lines()) {
      return stream.count();
    }
  }

  private static long countLinesContainingJava() {
    try (BufferedReader reader = Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource("input.txt").toURI()))) {
      return reader.lines()
          .filter(line -> line.contains("Java"))
          .count();
    } catch (IOException | URISyntaxException e) {
      e.printStackTrace();
    }
    return 0;
  }

  private static void readWriteAllLines() {
    Path inputFile = Paths.get("C:\\Users\\user\\Desktop\\MAlbrechtova\\input2.txt");
    Path outputFile = Paths.get("C:\\Users\\user\\Desktop\\MAlbrechtova\\output.txt");

    try {
      try (BufferedReader reader = Files.newBufferedReader(inputFile, Charset.defaultCharset());
          BufferedWriter writer = Files.newBufferedWriter(outputFile, Charset.defaultCharset())) {
        String line;
        int lineNumber = 1;
        while ((line = reader.readLine()) != null) {
          StringBuilder outputLine = new StringBuilder();
          outputLine.append(lineNumber).append(" ").append(line);
          writer.write(outputLine.toString());
          writer.newLine();
          lineNumber++;
        }

        writer.write("Number of lines: " + (lineNumber - 1));
        writer.newLine();
        System.out.println("output.txt was successfully created!");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public static void main(String[] args) throws IOException {
    String filename = "/input.txt";
    long numLines = countLines(filename);
    System.out.println("Number of lines: " + numLines);

    long count = countLinesContainingJava();
    System.out.println("Number of lines containing 'Java': " + count);

    readWriteAllLines();


  }

}

