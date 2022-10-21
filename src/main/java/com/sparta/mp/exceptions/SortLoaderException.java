package com.sparta.mp.exceptions;

public class SortLoaderException extends RuntimeException {
    @Override
    public String getMessage() {
        return "The selected sorting algorithm does not exist in the available sorters";
    }
}
