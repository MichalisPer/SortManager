package com.sparta.mp.utility;

import java.util.Random;
import java.util.stream.IntStream;

public class ArrayGenerator {
    private static final int MIN_ARRAY_ELEMENT = 0;
    private static final int MAX_ARRAY_ELEMENT = 1000;

    private ArrayGenerator() {}

    public static int[] generateRandomArray(int numberOfElements) {
        return IntStream.generate(() -> new Random().nextInt(MIN_ARRAY_ELEMENT,
                        MAX_ARRAY_ELEMENT + 1)).limit(numberOfElements).toArray();
    }
}
