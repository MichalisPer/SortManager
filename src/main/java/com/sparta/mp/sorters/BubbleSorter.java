package com.sparta.mp.sorters;

public class BubbleSorter implements Sorter {
    @Override
    public int[] sortArray(int[] array) {
        boolean isSorted;
        do {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    performTriangleSwap(array, i);
                    isSorted = false;
                }
            }
        } while (!isSorted);
        return array;
    }

    private static void performTriangleSwap(int[] sortedArray, int i) {
        int temp = sortedArray[i];
        sortedArray[i] = sortedArray[i + 1];
        sortedArray[i + 1] = temp;
    }
}
