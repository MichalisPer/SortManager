package com.sparta.mp;

import com.sparta.mp.display.DisplayManager;
import com.sparta.mp.sorters.Sorter;
import com.sparta.mp.start.SortFactory;
import com.sparta.mp.utility.ArrayGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SortTest {

    private static Sorter sorter;

    private int[] unsortedArray;

    public static IntStream getAvailableSorters() {
        return IntStream.rangeClosed(1, DisplayManager.getAvailableSorters().length);
    }

    int[] generateRandomArray(int elements) {
        return ArrayGenerator.generateRandomArray(elements);
    }

    @ParameterizedTest
    @MethodSource("getAvailableSorters")
    @DisplayName("Check that all sorting algorithms sort an even sized random array")
    void checkEvenSizeArray(int value) {
        unsortedArray = generateRandomArray(500);
        sorter = SortFactory.getSorter(value);
        int[] sorted = sorter.sortArray(unsortedArray);
        System.out.println(Arrays.toString(unsortedArray));
        for (int i = 0; i < sorted.length - 1; i++) {
            Assertions.assertTrue(sorted[i] <= sorted[i + 1]);
        }
    }

    @ParameterizedTest
    @MethodSource("getAvailableSorters")
    @DisplayName("Check that all sorting algorithms sort an odd sized random array")
    void checkOddSizeArray(int value) {
        unsortedArray = generateRandomArray(501);
        sorter = SortFactory.getSorter(value);
        int[] sorted = sorter.sortArray(unsortedArray);
        for (int i = 0; i < sorted.length - 1; i++) {
            Assertions.assertTrue(sorted[i] <= sorted[i + 1]);
        }
    }

    @ParameterizedTest
    @MethodSource("getAvailableSorters")
    @DisplayName("Check that all sorting algorithms sort a single element array")
    void checkOneElementArray(int value) {
        unsortedArray = generateRandomArray(1);
        sorter = SortFactory.getSorter(value);
        int[] sorted = sorter.sortArray(unsortedArray);
        for (int i = 0; i < sorted.length - 1; i++) {
            Assertions.assertTrue(sorted[i] <= sorted[i + 1]);
        }
    }

    @ParameterizedTest
    @MethodSource("getAvailableSorters")
    @DisplayName("Check that all sorting algorithms sort an already sorted array")
    void checkAlreadySortedArray(int value) {
        unsortedArray = generateRandomArray(500);
        Arrays.sort(unsortedArray);
        sorter = SortFactory.getSorter(value);
        int[] sorted = sorter.sortArray(unsortedArray);
        for (int i = 0; i < sorted.length - 1; i++) {
            Assertions.assertTrue(sorted[i] <= sorted[i + 1]);
        }
    }

    @ParameterizedTest
    @MethodSource("getAvailableSorters")
    @DisplayName("Check that all sorting algorithms sort an already sorted array")
    void checkMaxSizeArray(int value) {
        unsortedArray = generateRandomArray(1000);
        Arrays.sort(unsortedArray);
        sorter = SortFactory.getSorter(value);
        int[] sorted = sorter.sortArray(unsortedArray);
        for (int i = 0; i < sorted.length - 1; i++) {
            Assertions.assertTrue(sorted[i] <= sorted[i + 1]);
        }
    }
}
