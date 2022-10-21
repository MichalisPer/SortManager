package com.sparta.mp.sorters;

import com.sparta.mp.logging.ProjectLogger;

import java.util.Arrays;
import java.util.logging.Level;

public class MergeSorter implements Sorter {
    @Override
    public int[] sortArray(int[] array) {
        int[] arr = Arrays.copyOf(array, array.length);
        ProjectLogger.log(Level.INFO, "Merge sort started with array: "
                + Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        ProjectLogger.log(Level.INFO, "Array after merge sort: "
                + Arrays.toString(arr));
        return arr;
    }

    private void mergeSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = (high + low) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            ProjectLogger.log(Level.FINE, "The value of low is " + low
                    +" and the value of high is " + high);
            merge(array, low, mid, high);
        }
    }

    private void merge(int[] array, int low, int mid, int high) {
        ProjectLogger.log(Level.FINER, "Original array before merge: " + Arrays.toString(array));
        int[] leftArr = Arrays.copyOfRange(array, low, mid + 1);
        int[] rightArr = Arrays.copyOfRange(array, mid + 1, high + 1);
        ProjectLogger.log(Level.FINER, "The left array is " + Arrays.toString(leftArr));
        ProjectLogger.log(Level.FINER, "The right array is " + Arrays.toString(rightArr));
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
        ProjectLogger.log(Level.FINER, "Original array after merge: " + Arrays.toString(array));
    }

    @Override
    public String toString() {
        return "MergeSort algorithm";
    }
}
