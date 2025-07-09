package com.dev.trees;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(5);
        binarySearchTree.insert(20);
        binarySearchTree.insert(17);
        System.out.println(binarySearchTree);
        System.out.println(binarySearchTree.contains(20));
        System.out.println(binarySearchTree.contains(0));
    }
}
