package com.sparta.mp.exceptions;

public class ChildNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "Element requested does not exist in binary tree";
    }
}
