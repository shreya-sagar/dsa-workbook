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
        if (length == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0) {
            System.out.println("Doubly Linked List Empty, Remove Last not possible");
            return null;
        }
        Node last = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            last.prev = null;
        }
        length--;
        return last;
    }

    public void printList() {
        if (length == 0) {
            System.out.println("Doubly Linked List Empty");
        }
        Node node = head;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    public static class Node {
        private final int value;
        private Node next;
        private Node prev;

        Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    ", prev=" + prev +
                    '}';
        }
    }
}
