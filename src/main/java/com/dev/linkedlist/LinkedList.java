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

    public Node removeFirst() {
        if(length == 0) {
            System.out.println("Remove First Element not possible, Linked List is empty");
            return null;
        }
        Node temp = head;
        if(length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            temp.next = null;
        }
        length--;
        return temp;
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

    public Node get(int index) {
        if(index < 0 || index >= length) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if(temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if(index < 0 || index > length) {
            System.out.println("Index > Length, Set not possible");
            return false;
        }

        if(index == 0) {
            prepend(value);
            return true;
        }

        if(index == length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;

        length++;
        return true;
    }

    public Node remove(int index) {
        if(index < 0 || index >= length) {
            System.out.println("Remove not possible on this index " + index);
            return null;
        }
        if(index == 0) return removeFirst();
        if(index == length - 1) return removeLast();

        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse() {
        if(length == 0) {
            System.out.println("Reverse not possible : Empty Linked List");
        }
        if(length > 1) {
            Node temp = head;
            head = tail;
            tail = temp;

            Node after = temp.next;
            Node before = null;

            for (int i = 0; i < length; i++) {
                after = temp.next;
                temp.next = before;
                before = temp;
                temp = after;
            }
        }
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

    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", length=" + length +
                '}';
    }

     static class Node {
        private int value;
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
