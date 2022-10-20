package com.sparta.mp.start;

import com.sparta.mp.display.DisplayManager;
import com.sparta.mp.logging.CustomLoggerConfiguration;
import com.sparta.mp.sorters.Sorter;
import com.sparta.mp.utility.ArrayGenerator;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class SortManager {

    private static final Logger logger = Logger.getLogger("sortManager-logger");

    public static void start() {
        CustomLoggerConfiguration.configureLogger(logger);
        Scanner in = new Scanner(System.in);
        logger.log(Level.INFO, "Display message for sorter selection");
        //prints the request for sorter
        DisplayManager.printRequestForSorter();
        //pattern for expected input for sorter
        Pattern pattern = Pattern.compile("[1-5]");
        int sorterSelection; //the selected sorting algorithm to be used
        logger.log(Level.INFO, "Do-While loop for sorter input started");
        // loop that ensures that sorterSelection will be one of [1,2,3,4,5]
        do {
            try {
                logger.log(Level.FINE, "Before user's input");
                sorterSelection = Integer.parseInt(in.next(pattern));
                break;
            } catch (NoSuchElementException e) {
                DisplayManager.printWrongInputMessage(1, 5);
                String wrongInput = in.nextLine();
                logger.log(Level.FINE, "User insert wrong input: '" + wrongInput + "'");
            }
        } while (true);
        logger.log(Level.INFO, "After loop for sorter input where sorter selection = " + sorterSelection);
        logger.log(Level.INFO, "Display message for number of elements selection");
        // display the description for user to input the number of elements of the array
        DisplayManager.printRequestForElements();
        //expected pattern for number of elements
        pattern = Pattern.compile("1000|[1-9][0-9]{0,2}");
        int numberOfElements; // the number of elements in the array
        logger.log(Level.INFO, "Do-While loop for number of elements input started");
        // loop that ensures that sorterSelection will be in range [1-1000]
        do {
            try {
                logger.log(Level.FINE, "Before user's input");
                numberOfElements = Integer.parseInt(in.next(pattern));
                break;
            } catch (NoSuchElementException e) {
                DisplayManager.printWrongInputMessage(1, 1000);
                String wrongInput = in.nextLine();
                logger.log(Level.FINE, "User insert wrong input: '" + wrongInput + "'");
            }
        } while (true);
        logger.log(Level.INFO, "After loop for number of elements input where " +
                "number of elements =  " + numberOfElements);
        int[] array = ArrayGenerator.generateRandomArray(numberOfElements);
        logger.log(Level.INFO, "After random generation of array:\n"+ Arrays.toString(array));
        Sorter sorter = SortFactory.getSorter(sorterSelection);
        logger.log(Level.INFO, "Sort selection: " + sorterSelection +" SortFactory returns: " + sorter.getClass().getSimpleName());
        DisplayManager.displayResults(sorter, array);
        logger.log(Level.INFO, "Program terminates");
    }
}
