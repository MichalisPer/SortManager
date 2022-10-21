package com.sparta.mp.start;

import com.sparta.mp.display.DisplayManager;
import com.sparta.mp.logging.ProjectLogger;
import com.sparta.mp.sorters.Sorter;
import com.sparta.mp.utility.ArrayGenerator;

import java.util.*;
import java.util.logging.Level;
import java.util.regex.Pattern;

public class SortManager {
    private static final int NUMBER_OF_SORTERS = DisplayManager.getAvailableSorters().length;
    public static void start() {
        Scanner in = new Scanner(System.in);
        DisplayManager.displaySortAlgorithms();
        //pattern to match available inputs for the sort algorithm selection
        Pattern pattern = Pattern.compile("[1-" + NUMBER_OF_SORTERS + "]");
        int sorterSelection;
        ProjectLogger.log(Level.INFO, "Do-While loop for sorter input started");
        // loop that ensures user will insert correct input for sort algorithm
        do {
            try {
                sorterSelection = Integer.parseInt(in.next(pattern));
                break;
            } catch (NoSuchElementException e) {
                DisplayManager.printWrongInputMessage(1, NUMBER_OF_SORTERS);
                String wrongInput = in.nextLine();
                ProjectLogger.log(Level.FINE, "User has insert wrong input: '" + wrongInput + "'");
            }
        } while (true);
        ProjectLogger.log(Level.INFO, "Sort algorithm selection: " + sorterSelection);
        Sorter sorter = SortFactory.getSorter(sorterSelection);
        ProjectLogger.log(Level.INFO, "SortFactory returns: " + sorter.getClass().getSimpleName());
        // display the description for user to input the number of elements of the array
        DisplayManager.displayRequestForArraySize();
        //expected pattern for number of elements
        pattern = Pattern.compile("1000|[1-9][0-9]{0,2}");
        int numberOfElements; // the number of elements in the array
        ProjectLogger.log(Level.INFO, "Do-While loop for number of elements input started");
        // loop that ensures that sorterSelection will be in range [1-1000]
        do {
            try {
                numberOfElements = Integer.parseInt(in.next(pattern));
                break;
            } catch (NoSuchElementException e) {
                DisplayManager.printWrongInputMessage(1, 1000);
                String wrongInput = in.nextLine();
                ProjectLogger.log(Level.FINE, "User insert wrong input: '" + wrongInput + "'");
            }
        } while (true);
        ProjectLogger.log(Level.INFO, "Number of elements: " + numberOfElements);
        int[] array = ArrayGenerator.generateRandomArray(numberOfElements);
        DisplayManager.printResults(sorter, array);
        ProjectLogger.log(Level.INFO, "Program terminates");
    }
}
