package com.dev.datastructure.linkedlist;

public class DoublyLinkedListMain {

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(5);
        doublyLinkedList.append(20);
        doublyLinkedList.prepend(2);

//        System.out.println("Removing Last " + doublyLinkedList.removeLast());
//        System.out.println("Removing Last " + doublyLinkedList.removeLast());
//        System.out.println(doublyLinkedList.removeLast());
//        System.out.println("Removing First " + doublyLinkedList.removeFirst());

        doublyLinkedList.append(17);
        doublyLinkedList.append(18);
        doublyLinkedList.append(19);
        System.out.println("GET " + doublyLinkedList.get(3));
        System.out.println(doublyLinkedList);

        doublyLinkedList.set(5, 16);
        doublyLinkedList.insert(1,20);
        doublyLinkedList.printList();

        System.out.println("Removed " + doublyLinkedList.remove(3));
        doublyLinkedList.printList();
    }
}
