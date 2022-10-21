package com.sparta.mp.display;

import com.sparta.mp.logging.ProjectLogger;
import com.sparta.mp.sorters.Sorter;

import java.util.Arrays;
import java.util.logging.Level;

public class DisplayManager {

    public static String[] getAvailableSorters() {
        return new String[]{"BinarySorter", "BubbleSorter", "InsertionSorter",
                "MergeSorter", "QuickSorter"};
    }

    public static void displaySortAlgorithms() {
        System.out.println("Hello there! This is a sorting manager project.\n" +
                "Below you can find some widely used sorting algorithms!");
        String[] sorters = getAvailableSorters();
        for (int i = 0; i < sorters.length; i++) {
            System.out.println(i + 1 + "." + sorters[i]);
        }
        System.out.print("Choose the sorter you wish to use(enter the corresponding number):");
    }

    public static void displayRequestForArraySize() {
        System.out.print("\nPlease insert the number of elements you want to have in your array (max:1000):");
    }

    public static void printWrongInputMessage(int lower, int upper) {
        System.out.printf("Wrong input! Please enter a number within the following range [%d-%d]:",
                lower, upper);
    }

    public static void printResults(Sorter sorter, int[] array) {
        System.out.println("\nUnsorted array:\n" + Arrays.toString(array));
        ProjectLogger.log(Level.INFO, "The unsorted array as parsed in the method: " + Arrays.toString(array));
        System.out.println("\nSorting array using " + sorter.toString() + "...");
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(array);
        long end = System.nanoTime();
        ProjectLogger.log(Level.INFO, "The sorted array as returned from sorter: " + Arrays.toString(sortedArray));
        System.out.println("\nSorted array:\n" + Arrays.toString(sortedArray));
        System.out.println("\nExecution time in nanoseconds: " + (end - start));
    }
}
