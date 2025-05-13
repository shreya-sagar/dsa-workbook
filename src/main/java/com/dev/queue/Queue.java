package com.dev.queue;

import com.dev.linkedlist.Node;

public class Queue {
    Node first;
    Node last;
    int length;

    public Queue(){}

    public Queue(int value) {
        Node node = new Node(value);
        first = node;
        last = node;
        length = 1;
    }

    public void enqueue(int value) {
        // Same as append (add at end) in linked list
        Node node = new Node(value);
        if(length == 0) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;
        length++;
    }

    public Node dequeue() {
        // Same as removeFirst in linked list
        if(length == 0) return null;
        Node node = first;
        if(length == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            node.next = null;
        }
        length--;
        return node;
    }

    public void getFirst() {
        System.out.println("First : " + first);
    }

    public void getLast() {
        System.out.println("Last : " + last);
    }

    public void getLength() {
        System.out.println("Length : " + length);
    }

    public void printQueue() {
        if(length == 0) {
            System.out.println("Queue Empty");
        } else {
           Node node = first;
           while(node != null) {
               System.out.println(node.value);
               node = node.next;
           }
        }
    }

}
