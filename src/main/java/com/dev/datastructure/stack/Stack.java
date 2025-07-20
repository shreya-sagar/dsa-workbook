package com.dev.datastructure.stack;

import com.dev.datastructure.linkedlist.Node;

public class Stack {
    Node top;
    int height;

    public Stack() {}

    public Stack(int value) {
        top = new Node(value);
        height = 1;
    }

    public void push(int value) {
        // Same as prepend (add at start) in Linked List
        Node node = new Node(value);
        node.next = top;
        top = node;
        height++;
    }

    public Node pop() {
        // Same as removeFirst in Linked List
        if(height == 0) return null;
        Node node = top;
        top = top.next;
        node.next = null;
        height--;
        return node;
    }

    public void getTop() {
        System.out.println("Top : " + top.value);
    }

    public void getHeight() {
        System.out.println("Height : " + height);
    }

    public void printStack() {
        if(height == 0) {
            System.out.println("Stack Empty");
        } else {
            Node node = top;
            while(node != null) {
                System.out.println(node.value);
                node = node.next;
            }
        }
    }
}
