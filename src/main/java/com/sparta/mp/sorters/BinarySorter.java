package com.sparta.mp.sorters;

import com.sparta.mp.sorters.binarytree.BinaryTree;
import com.sparta.mp.sorters.binarytree.BinaryTreeImpl;

public class BinarySorter implements Sorter {

    @Override
    public int[] sortArray(int[] array) {
        BinaryTree tree = new BinaryTreeImpl(array);
        return tree.getSortedTreeAsc();
    }

    @Override
    public String toString() {
        return "BinarySort algorithm";
    }
}
