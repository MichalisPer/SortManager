package com.sparta.mp.sorters;

import java.util.Arrays;

public class MergeSorter implements Sorter {
    @Override
    public int[] sortArray(int[] array) {
        int[] arr = Arrays.copyOf(array, array.length);
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void mergeSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = (high + low) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    private void merge(int[] array, int low, int mid, int high) {
        int[] leftArr = Arrays.copyOfRange(array, low, mid + 1);
        int[] rightArr = Arrays.copyOfRange(array, mid + 1, high + 1);
        int leftCounter = 0;
        int rightCounter = 0;

        while (leftCounter < leftArr.length && rightCounter < rightArr.length) {
            if (leftArr[leftCounter] < rightArr[rightCounter]) {
                array[low + rightCounter + leftCounter] = leftArr[leftCounter++];
            } else {
                array[low + leftCounter + rightCounter] = rightArr[rightCounter++];
            }
        }

        while (leftCounter < leftArr.length) {
            array[low + rightCounter + leftCounter] = leftArr[leftCounter++];
        }

        while (rightCounter < rightArr.length) {
            array[low + leftCounter + rightCounter] = rightArr[rightCounter++];
        }
    }

    @Override
    public String toString() {
        return "MergeSort algorithm";
    }
}
