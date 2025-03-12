package com.dev.linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        Node node = new Node(value);
        head = node;
        tail = node;
        length = 1;
    }

    public void printList() {
        if(length == 0) {
            System.out.println("Linked List Empty");
            return;
        }
        Node node = head;
        while(node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    public void append(int value) {
        Node node = new Node(value);
        if(length == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        length++;
    }

    public Node removeLast() {
        if(length == 0) {
            System.out.println("Remove Last Element not possible, Linked List is empty");
            return null;
        }
        Node temp = head;
        Node pre = head;
        if(length == 1) {
            head = null;
            tail = null;
        } else {
            while(temp.next!= null) {
                pre = temp;
                temp = temp.next;
            }
            tail = pre;
            tail.next = null;
        }
        length--;
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", length=" + length +
                '}';
    }

     static class Node {
        private final int value;
        private Node next;

         Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}
