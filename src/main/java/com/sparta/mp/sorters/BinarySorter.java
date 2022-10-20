package com.sparta.mp.sorters;

import com.sparta.mp.logging.ProjectLogger;
import com.sparta.mp.sorters.binarytree.BinaryTree;
import com.sparta.mp.sorters.binarytree.BinaryTreeImpl;

import java.util.logging.Level;

public class BinarySorter implements Sorter {
    @Override
    public int[] sortArray(int[] array) {
        ProjectLogger.log(Level.INFO, "Array insertion into binary tree through constructor");
        BinaryTree tree = new BinaryTreeImpl(array);
        ProjectLogger.log(Level.INFO,"Return array created by in-order traversal through the tree");
        return tree.getSortedTreeAsc();
    }

    @Override
    public String toString() {
        return "BinarySort algorithm";
    }
}
