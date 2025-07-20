package com.dev.datastructure.heap;

public class Main {
    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(5);
        System.out.println(heap);
        heap.insert(20);
        System.out.println(heap);
        heap.insert(25);
        System.out.println(heap);
        heap.insert(30);
        System.out.println(heap);
        heap.insert(17);
        System.out.println(heap);
        heap.remove();
        System.out.println(heap);
    }
}
