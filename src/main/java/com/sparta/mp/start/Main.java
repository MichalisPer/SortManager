package com.sparta.mp.start;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] x = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(Arrays.copyOfRange(x,0,3)));
        SortManager.start();
    }
}
