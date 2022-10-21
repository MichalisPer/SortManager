package com.sparta.mp.sorters;

import java.util.Arrays;

public class SelectionSorter implements Sorter {
    @Override
    public int[] sortArray(int[] array) {
        int[] arr = Arrays.copyOf(array, array.length);
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length ; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            performTriangleSwap(arr, i, minIndex);
        }
        return arr;
    }

    private static void performTriangleSwap(int[] arr, int i, int minIndex) {
        int temp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = temp;
    }

    @Override
    public String toString() {
        return "SelectionSort algorithm";
    }
}
