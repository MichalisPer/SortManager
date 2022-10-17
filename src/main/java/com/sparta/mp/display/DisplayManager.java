package com.sparta.mp.display;

public class DisplayManager {

    public static void printNumberOfElementsDescription() {
        System.out.print("""

                Perfect! Now we are going to generate a random array with elements from [0, 1000]!
                Please insert the number of elements you want to have in your array (max: 1000):""");
    }

    public static void printSortSelectionDescription() {
        System.out.println("""
                Hello there! This is a sorting manager project.
                Below you can find some widely used sorting algorithms!
                """);
        System.out.println("""
                1.BinarySorter
                2.BubbleSorter
                3.InsertionSorter
                4.MergeSorter
                5.QuickSorter""");
        System.out.print("\nChoose the sorter you wish to use " +
                "(enter the corresponding number): ");
    }

}
