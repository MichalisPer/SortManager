package com.sparta.mp.sorters;

import java.util.Arrays;

public class QuickSorter implements Sorter {
    @Override
    public int[] sortArray(int[] array) {
        int[] arr = Arrays.copyOf(array, array.length);
        quickSort(arr,0,arr.length-1);
        return arr;
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partIndex = partition(arr,low,high);

            quickSort(arr,low,partIndex-1);
            quickSort(arr,partIndex+1,high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int smallerLastIndex = low-1;

        for (int i = low; i < high; i++) {
            if (arr[i] < arr[high]) {
                smallerLastIndex++;
                performTriangleSwap(arr, smallerLastIndex, i);
            }
        }
        performTriangleSwap(arr,smallerLastIndex+1,high);
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
