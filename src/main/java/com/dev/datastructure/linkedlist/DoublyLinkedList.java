package com.dev.datastructure.linkedlist;

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

    //Add at start
    public void prepend(int value) {
        Node node = new Node(value);
        if (length == 0) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        length++;
    }

    //Add at end
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


    public Node get(int index) {
        if (index < 0 || index >= length)
            return null;
        Node node = head;
        if (index < length / 2) {
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            System.out.println("*****");
            node = tail;
            for (int i = length - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    public boolean set(int index, int value) {
        Node node = get(index);
        if (node != null) {
            node.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length)
            return false;

        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index == length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node currentNode = get(index);
        Node prevNode = currentNode.prev;
        newNode.prev = prevNode;
        newNode.next = currentNode;
        prevNode.next = newNode;
        currentNode.prev = newNode;
        length++;
        return true;
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

    public Node removeFirst() {
        if (length == 0) {
            System.out.println("Doubly Linked List Empty, Remove First not possible");
            return null;
        }
        Node first = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            first.next = null;
        }
        length--;
        return first;

    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();

        Node node = get(index);
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        node.prev = null;
        node.next = null;
        length--;

        return node;
    }

    public void printList() {
        if (length == 0) {
            System.out.println("Doubly Linked List Empty");
        } else {
            System.out.println("**Printing Doubly Linked List**");
            Node node = head;
            while (node != null) {
                System.out.println(node.value);
                node = node.next;
            }
        }
    }

    @Override
    public String toString() {
        return "DoublyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", length=" + length +
                '}';
    }

    public static class Node {
        private int value;
        private Node next;
        private Node prev;

        Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + (next != null ? next.value : null) +
                    ", prev=" + (prev != null ? prev.value : null) +
                    '}';
        }
    }
}
