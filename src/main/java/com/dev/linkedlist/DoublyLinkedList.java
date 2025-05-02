package com.dev.linkedlist;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList(int value) {
        Node node = new Node(value);
        head = node;
        tail = node;
        length = 1;
    }

    public void append(int value) {
        Node node = new Node(value);
        if(length == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        length++;
    }

    public void printList() {
        if(length == 0) {
            System.out.println("Doubly Linked List Empty");
        }
        Node node = head;
        while(node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    class Node {
        private int value;
        private Node next;
        private Node prev;
        
        Node(int value) {
            this.value = value;
        }
    }
}
