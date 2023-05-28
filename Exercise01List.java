package eu.unicorn.tga.javatraining.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise01List {

  public static void main(String[] args) {
    // 1 Store all the positive integers between 1 and 10 in a List collection
    // and then remove the object with index position 5 from the collection
    List<Integer> myList = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
      myList.add(i);
    }
    myList.remove(Integer.valueOf(5));

    // 2 Then write all values from the List variable to a console
    for (int num : myList) {
      System.out.println(num);
    }

    // 3 Check and write to console if the elements (values) 5 and 50 exist in the List
    System.out.println(myList.contains(5));
    System.out.println(myList.contains(50));

    // 4 Shuffle the List and write to the console
    Collections.shuffle(myList);
    System.out.println(myList);

    // 5 Find min and max values from the list
    int min = Collections.min(myList);
    int max = Collections.max(myList);
    System.out.println("Min value: " + min);
    System.out.println("Max value: " + max);

    // 6 Find the length of the List
    int length = myList.size();
    System.out.println("Length: " + length);

    // 7 Convert List to Array
    Integer[] myArray = myList.toArray(new Integer[0]);

    // 8 Convert Array back to List
    List<Integer> newList = new ArrayList<>();
    Collections.addAll(newList, myArray);
  }
}
