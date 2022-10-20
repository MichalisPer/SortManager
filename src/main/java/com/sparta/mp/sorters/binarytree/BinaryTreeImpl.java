package com.sparta.mp.sorters.binarytree;

import java.util.Arrays;

public class BinaryTreeImpl implements BinaryTree {

    private final Node root;

    private int numOfNodes;

    static class Node {
        private final int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int element) {
            this.value = element;
        }

        public int getValue() {
            return value;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        public boolean hasLeftNode() {
            return leftChild != null;
        }

        public boolean hasRightNode() {
            return rightChild != null;
        }

    }

    public BinaryTreeImpl(int element) {
        this.root = new Node(element);
        this.numOfNodes++;
    }

    public BinaryTreeImpl(int[] array) {
        this.root = new Node(array[0]);
        this.numOfNodes++;
        addElements(Arrays.copyOfRange(array, 1, array.length));
    }

    @Override
    public int getRootElement() {
        return this.root.value;
    }

    @Override
    public void addElement(int element) {
        addNodeToTree(element, root);
        this.numOfNodes++;
    }

    public int getNumOfNodes() {
        return numOfNodes;
    }

    private void addNodeToTree(int element, Node node) {
        if (element < node.value) {
            if (node.hasLeftNode())
                addNodeToTree(element, node.getLeftChild());
            else
                node.setLeftChild(new Node(element));
        } else {
            if (node.hasRightNode())
                addNodeToTree(element, node.getRightChild());
            else
                node.setRightChild(new Node(element));
        }
    }

    @Override
    public void addElements(int[] elements) {
        for (int element : elements) {
            addElement(element);
        }
    }

    @Override
    public boolean findElement(int value) {
        return getElement(value, root) != null;
    }

    private Node getElement(int value, Node node) {
        if (value == node.value) {
            return node;
        } else if (value < node.value) {
            if (node.hasLeftNode()) {
                getElement(value, node.leftChild);
            }
            return null;
        } else {
            if (node.hasRightNode()) {
                getElement(value, node.rightChild);
            }
            return null;
        }
    }


    @Override
    public int getLeftChild(int element) throws RuntimeException {
        Node node = getElement(element, this.root);
        if (node != null && node.hasLeftNode()) {
            return node.getLeftChild().getValue();
        }
        throw new RuntimeException();
    }

    @Override
    public int getRightChild(int element) throws RuntimeException {
        Node node = getElement(element, this.root);
        if (node != null && node.hasRightNode()) {
            return node.getRightChild().getValue();
        }
        throw new RuntimeException();
    }

    @Override
    public int[] getSortedTreeAsc() {
        int[] arr = new int[getNumOfNodes()];
        inOrderTraversal(this.root, arr, 0, true);
        return arr;
    }

    @Override
    public int[] getSortedTreeDesc() {
        int[] arr = new int[getNumOfNodes()];
        inOrderTraversal(this.root, arr, 0, false);
        return arr;
    }

    private int inOrderTraversal(Node node, int[] arr, int counter, boolean isAsc) {
        if (node != null) {
            counter = inOrderTraversal(isAsc ? node.getLeftChild() : node.getRightChild(), arr, counter, isAsc);
            arr[counter++] = node.getValue();
            counter = inOrderTraversal(isAsc ? node.getRightChild() : node.getLeftChild(), arr, counter, isAsc);
            return counter;
        }
        return counter;
    }

}
