package com.sparta.mp.sorters;

import com.sparta.mp.logging.ProjectLogger;

import java.util.Arrays;
import java.util.logging.Level;

public class BubbleSorter implements Sorter {
    @Override
    public int[] sortArray(int[] array) {
        int[] arr = Arrays.copyOf(array, array.length);
        ProjectLogger.log(Level.INFO, "BubbleSort started with array: "
                + Arrays.toString(arr));
        boolean isSorted;
        do {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                ProjectLogger.log(Level.FINER, "Comparing elements at positions " + i
                        + " and " + (i+1) + ": " + arr[i] + " " + arr[i+1]);
                if (arr[i] > arr[i + 1]) {
                    ProjectLogger.log(Level.FINEST, "Swapping elements");
                    performTriangleSwap(arr, i);
                    isSorted = false;
                }
            }
            ProjectLogger.log(Level.FINE, "Array after one pass: "
                    + Arrays.toString(arr));
        } while (!isSorted);
        ProjectLogger.log(Level.INFO, "Array after BubbleSort: "
                + Arrays.toString(arr));
        return arr;
    }

    private static void performTriangleSwap(int[] sortedArray, int i) {
        int temp = sortedArray[i];
        sortedArray[i] = sortedArray[i + 1];
        sortedArray[i + 1] = temp;
    }

    @Override
    public String toString() {
        return "BubbleSort algorithm";
    }
}
