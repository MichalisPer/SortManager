package com.sparta.mp.sorters;

import java.util.Arrays;

public class InsertionSorter implements Sorter {
    @Override
    public int[] sortArray(int[] array) {
        int[] arr = Arrays.copyOf(array, array.length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    performTriangleSwap(arr, j);
                } else {
                    break;
                }
            }
        }
        return arr;
    }

    private static void performTriangleSwap(int[] arr, int j) {
        int temp = arr[j];
        arr[j] = arr[j - 1];
        arr[j - 1] = temp;
    }

    @Override
    public String toString() {
        return "InsertionSort algorithm";
    }
}
