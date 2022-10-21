package com.sparta.mp;

import com.sparta.mp.display.DisplayManager;
import com.sparta.mp.sorters.Sorter;
import com.sparta.mp.start.SortFactory;
import com.sparta.mp.utility.ArrayGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PerformanceTest {

    private static Sorter sorter;

    private static int[] unsortedArray10;

    private static int[] unsortedArray500;

    private static int[] unsortedArray1000;

    @BeforeAll
    static void generateRandomArrays() {
        unsortedArray10 = ArrayGenerator.generateRandomArray(10);
        unsortedArray500 = ArrayGenerator.generateRandomArray(500);
        unsortedArray1000 = ArrayGenerator.generateRandomArray(1000);
    }

    public static IntStream getAvailableSorters() {
        return IntStream.rangeClosed(1, DisplayManager.getAvailableSorters().length);
    }

    @ParameterizedTest
    @MethodSource("getAvailableSorters")
    @DisplayName("Check that all sorting algorithms sort an even sized random array")
    void checkPerformanceWithSmallSizeArray(int value) {
        int[] arrayToSort = unsortedArray10.clone();
        sorter = SortFactory.getSorter(value);
        long start = System.nanoTime();
        int[] sorted = sorter.sortArray(arrayToSort);
        long end = System.nanoTime();
        for (int i = 0; i < sorted.length - 1; i++) {
            Assertions.assertTrue(sorted[i] <= sorted[i + 1]);
        }
        printResults(sorted, sorter.toString(), (end - start));
    }

    @ParameterizedTest
    @MethodSource("getAvailableSorters")
    @DisplayName("Check that all sorting algorithms sort an even sized random array")
    void checkPerformanceWithMidSizeArray(int value) {
        int[] arrayToSort = unsortedArray500.clone();
        sorter = SortFactory.getSorter(value);
        long start = System.nanoTime();
        int[] sorted = sorter.sortArray(arrayToSort);
        long end = System.nanoTime();
        for (int i = 0; i < sorted.length - 1; i++) {
            Assertions.assertTrue(sorted[i] <= sorted[i + 1]);
        }
        printResults(sorted, sorter.toString(), (end - start));
    }

    @ParameterizedTest
    @MethodSource("getAvailableSorters")
    @DisplayName("Check that all sorting algorithms sort an even sized random array")
    void checkPerformanceWithLargeSizeArray(int value) {
        int[] arrayToSort = unsortedArray1000.clone();
        sorter = SortFactory.getSorter(value);
        long start = System.nanoTime();
        int[] sorted = sorter.sortArray(arrayToSort);
        long end = System.nanoTime();
        for (int i = 0; i < sorted.length - 1; i++) {
            Assertions.assertTrue(sorted[i] <= sorted[i + 1]);
        }
        printResults(sorted, sorter.toString(), (end - start));
    }

    private void printResults(int[] sortedArray, String algorithm, long executionTime) {
        System.out.format("%-25s %5d elements% 12d ns  %s\n", algorithm, sortedArray.length,
                executionTime, Arrays.toString(sortedArray));

    }

}
