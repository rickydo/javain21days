package java21days;

import java.util.BitSet;
import java.util.Arrays;

class MissingNumberInArray {
  public static void main(String args[]) {
    // one missing number
    printMissingNumber(new int[] {1,2,3,4,6}, 6);

    // two missing number
    printMissingNumber(new int[] {1,2,3,4,6,7,9,8,10}, 10);

    // three missing number
    printMissingNumber(new int[] {1,2,3,4,6,9,8}, 10);

    // four missing numbers
    printMissingNumber(new int[] {1,2,3,4,9,8}, 10);

    int[] iArray = new int[]{1, 2, 3,5};
    int missing = getMissingNumber(iArray, 5);
    System.out.printf("Missing number in array %s is %d %n", Arrays.toString(iArray), missing);
  }
  // method to find missing value(s) from an integer array. 
  private static void printMissingNumber(int[] numbers, int count) {
    // get the number of missing numbers from what the array length should be
    int missingCount = count - numbers.length;
    // create new bitset from desired array length, count
    BitSet bitset = new BitSet(count);

    // iterate through numbers array and set booleans to true for appropriate index
    for (int number : numbers) {
      // must subtract number to set appropriate index
      // the number in the array will be represented by the bitset index
      bitset.set(number - 1);
    }

    System.out.printf("Missing numbers in integer array %s, with total number %d is %n", Arrays.toString(numbers), count);
    // start with 0 index
    int lastMissingIndex = 0;
    // loop as many times as there are numbers missing
    for (int i = 0; i < missingCount; i++) {
      // nextclearbit will find the first bit that is set to false that occurs on or after the lastmissingindex
      lastMissingIndex = bitset.nextClearBit(lastMissingIndex);
      // print out the ACTUAL missing number by using prefixed incrementer
      System.out.println(++lastMissingIndex);
    }
  }

  // finding a single missing number in array of size total count containing numbers of 1-100
  // where 1 = missing number
  private static int getMissingNumber(int[] numbers, int totalCount) {
    // arithmetic sum of series 
    int expectedSum = totalCount * ((totalCount + 1) / 2);
    int actualSum = 0;
    for (int i : numbers) {
      actualSum += i;
    }
    return expectedSum - actualSum;
  }
}