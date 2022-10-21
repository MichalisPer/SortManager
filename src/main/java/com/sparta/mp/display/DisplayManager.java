package com.sparta.mp.display;

import com.sparta.mp.logging.ProjectLogger;
import com.sparta.mp.sorters.Sorter;
import java.util.Arrays;
import java.util.logging.Level;

public class DisplayManager {

    public static void printWrongInputMessage(int lower, int upper) {
        System.out.printf("Wrong input! Please enter a number within the following range [%d-%d]: ",
                lower, upper);
    }

    public static void printRequestForElements() {
        System.out.print("""

                Perfect! Now we are going to generate a random array with elements from [0, 1000]!
                Please insert the number of elements you want to have in your array (max: 1000):""");
    }

    public static void printRequestForSorter() {
        System.out.print("""
                Hello there! This is a sorting manager project.
                Below you can find some widely used sorting algorithms!
                1.BinarySorter
                2.BubbleSorter
                3.InsertionSorter
                4.MergeSorter
                5.QuickSorter
                Choose the sorter you wish to use (enter the corresponding number):\040""");
    }

    public static void displayResults(Sorter sorter, int[] array) {
        System.out.println("\nUnsorted array:\n" + Arrays.toString(array));
        ProjectLogger.log(Level.INFO, "The unsorted array as parsed in the method: " + Arrays.toString(array));
        System.out.println("\nSorting array using " + sorter.toString() + "...");
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(array);
        long end = System.nanoTime();
        ProjectLogger.log(Level.INFO, "The sorted array as returned from sorter: " + Arrays.toString(sortedArray));
        System.out.println("\nSorted array:\n" + Arrays.toString(sortedArray));
        System.out.println("\nTime in nanoseconds: " + (end - start));
    }
}
