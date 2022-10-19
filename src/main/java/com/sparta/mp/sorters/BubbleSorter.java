package com.sparta.mp.sorters;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BubbleSorter implements Sorter {
    @Override
    public int[] sortArray(int[] array) {
        int[] arr = Arrays.copyOf(array, array.length);
        boolean isSorted;
        do {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    performTriangleSwap(arr, i);
                    isSorted = false;
                }
            }
        } while (!isSorted);
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
