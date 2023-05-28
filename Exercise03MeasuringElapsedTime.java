package eu.unicorn.tga.javatraining.datetime;

/*
  1] At two specified places in the source code implement measurement of elapsed time of the dummyLongRunningMethod execution.
     Note: execution time may vary so don't be confused when you receive different result between individual program runs.
 */
public class Exercise03MeasuringElapsedTime {
  public static void main(String[] args) {

    long startTimeMillis = System.currentTimeMillis();
    dummyLongRunningMethod();
    long endTimeMillis = System.currentTimeMillis();
    long durationInMilliseconds = endTimeMillis - startTimeMillis;

    System.out.println(durationInMilliseconds);

    long startTimeNanos = System.nanoTime();
    dummyLongRunningMethod();
    long endTimeNanos = System.nanoTime();
    long durationInNanoseconds = endTimeNanos - startTimeNanos;

    System.out.println(durationInNanoseconds);
  }

  private static void dummyLongRunningMethod()
  {
    long objectiveTime = System.currentTimeMillis() + 1234;
    while (System.currentTimeMillis() < objectiveTime);
  }
}
