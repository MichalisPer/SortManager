package com.sparta.mp.start;

import com.sparta.mp.display.DisplayManager;
import com.sparta.mp.sorters.Sorter;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class SortManager {

    public static void start() {
        Scanner in = new Scanner(System.in);

        DisplayManager.printRequestForSorter(); //prints the request for sorter

        Pattern pattern = Pattern.compile("[1-5]"); //pattern for expected input for sorter

        int sorterSelection; //the selected sorting algorithm to be used

        // loop that ensures that sorterSelection will be one of [1,2,3,4,5]
        do {
            try {
                sorterSelection = Integer.parseInt(in.next(pattern));
                break;
            } catch (NoSuchElementException e) {
                DisplayManager.printWrongInputMessage(1, 5);

                in.nextLine();
            }
        } while (true);


        // display the description for user to input the number of elements of the array
        DisplayManager.printRequestForElements();

        //expected pattern for number of elements
        pattern = Pattern.compile("1000|[1-9][0-9]{0,2}");

        int numberOfElements; // the number of elements in the array

        // loop that ensures that sorterSelection will be in range [1-1000]
        do {
            try {
                numberOfElements = Integer.parseInt(in.next(pattern));
                break;
            } catch (NoSuchElementException e) {
                DisplayManager.printWrongInputMessage(1, 1000);
                in.nextLine();
            }
        } while (true);

        int[] array = generateRandomArray(numberOfElements);

        Sorter sorter = SortFactory.getSorter(sorterSelection);

        int[] sortedArray = sorter.sortArray(array);

        DisplayManager.displayResults(sorter,array,sortedArray);
    }

    private static int[] generateRandomArray(int numberOfElements) {
        return IntStream.generate(() -> new Random().nextInt(1000))
                .limit(numberOfElements).toArray();
    }
}
