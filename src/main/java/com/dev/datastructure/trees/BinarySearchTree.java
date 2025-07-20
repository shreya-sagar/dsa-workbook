package com.dev.datastructure.trees;

public class BinarySearchTree {
    private Node root;

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if(root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while(true) {
            if(value == temp.value) return false;
            if(value < temp.value) {
                if(temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if(temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        if(root == null) return false;
        Node temp = root;
        while(true) {
            if(value == temp.value) return true;
            if(value < temp.value) {
                if(temp.left == null) return false;
                temp = temp.left;
            } else {
                if(temp.right == null) return false;
                temp = temp.right;
            }
        }
    }

    class Node {
        private int value;
        private Node left;
        private Node right;

        Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }
}
