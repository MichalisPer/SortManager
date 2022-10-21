package com.sparta.mp.sorters;

import com.sparta.mp.logging.ProjectLogger;

import java.util.Arrays;
import java.util.logging.Level;

public class InsertionSorter implements Sorter {
    @Override
    public int[] sortArray(int[] array) {
        int[] arr = Arrays.copyOf(array, array.length);
        ProjectLogger.log(Level.INFO, "Insertion sort started with array: "
                + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            ProjectLogger.log(Level.FINE, "Outer loop counter: " + i);
            for (int j = i; j > 0; j--) {
                ProjectLogger.log(Level.FINER, "Comparing elements at positions " + j
                        + " and " + (j - 1) + ": " + arr[j] + " " + arr[j - 1]);
                if (arr[j] < arr[j - 1]) {
                    performTriangleSwap(arr, j);
                } else {
                    break;
                }
            }
        }
        ProjectLogger.log(Level.INFO, "Array after insertion sort: "
                + Arrays.toString(arr));
        return arr;
    }

    private static void performTriangleSwap(int[] arr, int j) {
        ProjectLogger.log(Level.FINEST, "Swapping elements");
        int temp = arr[j];
        arr[j] = arr[j - 1];
        arr[j - 1] = temp;
    }

    @Override
    public String toString() {
        return "InsertionSort algorithm";
    }
}
