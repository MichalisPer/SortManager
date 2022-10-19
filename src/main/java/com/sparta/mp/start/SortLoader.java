package com.sparta.mp.start;

import com.sparta.mp.display.DisplayManager;
import com.sparta.mp.sorters.Sorter;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SortLoader {
    private static final int NUMBER_OF_SORTERS = 5;
    private static final int MAX_NUMBER_OF_ELEMENTS = 1000;

    public static void start() {
        Scanner in = new Scanner(System.in);

        // prints the intro of the SortManager project
        DisplayManager.printSortSelectionDescription();

        int sorterSelection; // the selected sorting algorithm to be used

        /*
          loop that ensures that sorterSelection will be one of [1,2,3,4,5]
          handles cases where input is not an integer
          handles cases where input does not correspond to a specific algorithm
         */
        do {
            try {
                sorterSelection = in.nextInt();
                if (sorterSelection <= 0 || sorterSelection > NUMBER_OF_SORTERS) {
                    System.out.print("\nWrong input! Please give a number that corresponds to one of the sorters: ");
                    continue;
                }
                break;
            } catch (InputMismatchException exp) {
                System.out.print("\nWrong input! Please give an integer number: ");
                in.next();
            }
        } while (true);

        // display the description for user to input the number of elements of the array
        DisplayManager.printNumberOfElementsDescription();

        int numberOfElements; // the number of elements in the array

        /*
          loop that ensures that sorterSelection will be one of [1,2,3,4,5]
          handles cases where input is not an integer
          handles cases where input does not correspond to a specific algorithm
         */
        do {
            try {
                numberOfElements = in.nextInt();
                if (numberOfElements <= 0 || numberOfElements > MAX_NUMBER_OF_ELEMENTS) {
                    System.out.print("\nWrong input! Please give a number within the range of [1, 1000]: ");
                    continue;
                }
                break;
            } catch (InputMismatchException exp) {
                System.out.print("\nWrong input! Please give an integer number: ");
                in.next();
            }
        } while (true);

        int[] array = generateRandomArray(numberOfElements);

        Sorter sorter = SortFactory.getSorter(sorterSelection);

        sorter.sortArray(array);
    }

    private static int[] generateRandomArray(int numberOfElements) {
        return IntStream.generate(() -> new Random().nextInt(1000)).limit(numberOfElements).toArray();
    }
}
