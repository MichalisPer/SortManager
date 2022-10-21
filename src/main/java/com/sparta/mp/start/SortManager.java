package com.sparta.mp.start;

import com.sparta.mp.display.DisplayManager;
import com.sparta.mp.logging.ProjectLogger;
import com.sparta.mp.sorters.Sorter;
import com.sparta.mp.utility.ArrayGenerator;

import java.util.*;
import java.util.logging.Level;
import java.util.regex.Pattern;

public class SortManager {

    public static void start() {
        Scanner in = new Scanner(System.in);
        ProjectLogger.log(Level.INFO, "Display message for sorter selection");
        //prints the request for sorter
        DisplayManager.printRequestForSorter();
        //pattern for expected input for sorter
        Pattern pattern = Pattern.compile("[1-5]");
        int sorterSelection; //the selected sorting algorithm to be used
        ProjectLogger.log(Level.INFO, "Do-While loop for sorter input started");
        // loop that ensures that sorterSelection will be one of [1,2,3,4,5]
        do {
            try {
                ProjectLogger.log(Level.FINE, "Before user's input");
                sorterSelection = Integer.parseInt(in.next(pattern));
                break;
            } catch (NoSuchElementException e) {
                DisplayManager.printWrongInputMessage(1, 5);
                String wrongInput = in.nextLine();
                ProjectLogger.log(Level.FINE, "User insert wrong input: '" + wrongInput + "'");
            }
        } while (true);
        ProjectLogger.log(Level.INFO, "After loop for sorter input where sorter selection = " + sorterSelection);
        ProjectLogger.log(Level.INFO, "Display message for number of elements selection");
        // display the description for user to input the number of elements of the array
        DisplayManager.printRequestForElements();
        //expected pattern for number of elements
        pattern = Pattern.compile("1000|[1-9][0-9]{0,2}");
        int numberOfElements; // the number of elements in the array
        ProjectLogger.log(Level.INFO, "Do-While loop for number of elements input started");
        // loop that ensures that sorterSelection will be in range [1-1000]
        do {
            try {
                ProjectLogger.log(Level.FINE, "Before user's input");
                numberOfElements = Integer.parseInt(in.next(pattern));
                break;
            } catch (NoSuchElementException e) {
                DisplayManager.printWrongInputMessage(1, 1000);
                String wrongInput = in.nextLine();
                ProjectLogger.log(Level.FINE, "User insert wrong input: '" + wrongInput + "'");
            }
        } while (true);
        ProjectLogger.log(Level.INFO, "After loop for number of elements input where " +
                "number of elements =  " + numberOfElements);
        int[] array = ArrayGenerator.generateRandomArray(numberOfElements);
        ProjectLogger.log(Level.INFO, "After random generation of array: "+ Arrays.toString(array));
        Sorter sorter = SortFactory.getSorter(sorterSelection);
        ProjectLogger.log(Level.INFO, "Sort selection: " + sorterSelection +", SortFactory returns: " + sorter.getClass().getSimpleName());
        DisplayManager.displayResults(sorter, array);
        ProjectLogger.log(Level.INFO, "Program terminates");
    }
}
