package com.dev.linkedlist;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(5);
        linkedList.append(2);
        linkedList.append(17);
        linkedList.append(20);

        System.out.println("removing " + linkedList.removeLast());
        linkedList.removeLast();
        linkedList.removeLast();
        linkedList.removeLast();
        linkedList.removeLast();
        linkedList.printList();

        linkedList.prepend(100);
        linkedList.printList();
        System.out.println(linkedList);
    }
}
