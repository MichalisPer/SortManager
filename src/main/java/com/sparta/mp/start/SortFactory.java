package com.sparta.mp.start;

import com.sparta.mp.logging.CustomLoggerConfiguration;
import com.sparta.mp.sorters.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SortFactory {
    private static final Logger logger = Logger.getLogger("sortFactory-logger");
    public static Sorter getSorter(int choice) throws RuntimeException {
        CustomLoggerConfiguration.configureLogger(logger);
        logger.log(Level.INFO, "Before switch statement for sorter instantiation where " +
                "choice = " + choice);
        switch (choice) {
            case 1 -> {
                logger.log(Level.FINE, "Returns BinarySorter");
                return new BinarySorter();
            }
            case 2 -> {
                logger.log(Level.FINE, "Returns BubbleSorter");
                return new BubbleSorter();
            }
            case 3 -> {
                logger.log(Level.FINE, "Returns InsertionSorter");
                return new InsertionSorter();
            }
            case 4 -> {
                logger.log(Level.FINE, "Returns MergeSorter");
                return new MergeSorter();
            }
            case 5 -> {
                logger.log(Level.FINE, "Returns QuickSorter");
                return new QuickSorter();
            }
            default -> {
                logger.log(Level.WARNING, "Error with validation of user's input in sort selection");
                throw new RuntimeException();
            }
        }
    }
}
