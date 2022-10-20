package com.sparta.mp.sorters.binarytree;

public interface BinaryTree {
    int getRootElement();

    void addElement(int element);

    void addElements(int[] elements);

    boolean findElement(int value);

    int getLeftChild(int element);

    int getRightChild(int element);

    int[] getSortedTreeAsc();

    int[] getSortedTreeDesc();
}
