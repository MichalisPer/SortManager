package com.sparta.mp.start;

import com.sparta.mp.logging.ProjectLogger;
import com.sparta.mp.sorters.*;
import org.junit.jupiter.api.ClassOrderer;

import java.lang.invoke.MethodHandles;
import java.util.logging.Level;

public class SortFactory {

    public static Sorter getSorter(int choice) throws RuntimeException {
        ProjectLogger.log(Level.INFO, "Before switch statement for sorter instantiation where " +
                "choice = " + choice);
        switch (choice) {
            case 1 -> {
                ProjectLogger.log(Level.FINE, "Returns BinarySorter");
                return new BinarySorter();
            }
            case 2 -> {
                ProjectLogger.log(Level.FINE, "Returns BubbleSorter");
                return new BubbleSorter();
            }
            case 3 -> {
                ProjectLogger.log(Level.FINE, "Returns InsertionSorter");
                return new InsertionSorter();
            }
            case 4 -> {
                ProjectLogger.log(Level.FINE, "Returns MergeSorter");
                return new MergeSorter();
            }
            case 5 -> {
                ProjectLogger.log(Level.FINE, "Returns QuickSorter");
                return new QuickSorter();
            }
            default -> {
                ProjectLogger.log(Level.WARNING, "Error with validation of user's input in sort selection");
                throw new RuntimeException();
            }
        }
    }
}
