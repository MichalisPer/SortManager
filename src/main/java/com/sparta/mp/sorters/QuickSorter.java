package com.sparta.mp.sorters;

import com.sparta.mp.logging.ProjectLogger;

import java.util.Arrays;
import java.util.logging.Level;

public class QuickSorter implements Sorter {
    @Override
    public int[] sortArray(int[] array) {
        int[] arr = Arrays.copyOf(array, array.length);
        ProjectLogger.log(Level.INFO, "Quick sort started with array: "
                + Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        ProjectLogger.log(Level.INFO, "Array after quick sort: "
                + Arrays.toString(arr));
        return arr;
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partIndex = partition(arr,low,high);
            ProjectLogger.log(Level.FINE, "Partition index: " + partIndex);
            ProjectLogger.log(Level.FINE, "Original array after partition: " + Arrays.toString(arr));
            ProjectLogger.log(Level.FINE, "Element in correct place: " + arr[partIndex]);

            quickSort(arr,low,partIndex-1);
            quickSort(arr,partIndex+1,high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int smallerLastIndex = low-1;
        ProjectLogger.log(Level.FINER, "Array under partition: "
                + Arrays.toString(Arrays.copyOfRange(arr, low,high+1)));
        for (int i = low; i < high; i++) {
            if (arr[i] < arr[high]) {
                smallerLastIndex++;
                performTriangleSwap(arr, smallerLastIndex, i);
            }
        }
        performTriangleSwap(arr,smallerLastIndex+1,high);
        ProjectLogger.log(Level.FINER, "Array after partition: "
                + Arrays.toString(Arrays.copyOfRange(arr, low,high+1)));
        return smallerLastIndex+1;
    }

    private static void performTriangleSwap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    @Override
    public String toString() {
        return "QuickSort algorithm";
    }
}
