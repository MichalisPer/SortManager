package com.sparta.mp.start;

import com.sparta.mp.sorters.*;

public class SortFactory {

    public static Sorter getSorter(int choice) throws RuntimeException {
        switch (choice) {
            case 1 -> {
                return new BinarySorter();
            }
            case 2 -> {
                return new BubbleSorter();
            }
            case 3 -> {
                return new InsertionSorter();
            }
            case 4 -> {
                return new MergeSorter();
            }
            case 5 -> {
                return new QuickSorter();
            }
            default -> throw new RuntimeException();
        }
    }
}
