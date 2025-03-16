package com.dev.linkedlist;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(5);
        linkedList.append(2);
        linkedList.append(17);
        linkedList.append(20);

        System.out.println("removing last " + linkedList.removeLast());
//        linkedList.removeLast();
//        linkedList.removeLast();
//        linkedList.removeLast();
//        linkedList.removeLast();
        linkedList.printList();

        linkedList.prepend(100);
        linkedList.printList();
        System.out.println(linkedList);

        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList);

        System.out.println(linkedList.get(2));
        linkedList.insert(0,11);
        System.out.println(linkedList);
        linkedList.insert(4,44);
        System.out.println(linkedList);
        linkedList.insert(2,22);
        System.out.println(linkedList);
        System.out.println(linkedList.insert(7,66));
        System.out.println(linkedList);

        linkedList.set(3, 33);
        System.out.println(linkedList);

        System.out.println("Remove " + linkedList.remove(2));
        System.out.println(linkedList);
        System.out.println(linkedList.remove(-1));
        System.out.println(linkedList.remove(5));
        System.out.println(linkedList.remove(4));
        System.out.println(linkedList);
        System.out.println(linkedList.remove(0));
        System.out.println(linkedList);

        linkedList.reverse();
        System.out.println(linkedList);
        linkedList = new LinkedList(5);
        linkedList.reverse();
        System.out.println(linkedList);
        linkedList.removeLast();
        linkedList.reverse();
        System.out.println(linkedList);
    }
}
