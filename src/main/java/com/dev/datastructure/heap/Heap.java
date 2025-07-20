package com.dev.datastructure.heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    public void insert(int value) {
        heap.add(value);
        int current = heap.size() - 1;

        //MAX HEAP
        while(current > 0 && heap.get(current) > heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public Integer remove() {
        if(heap.isEmpty()) return null;
        if(heap.size() == 1) return heap.removeFirst();

        int max = heap.getFirst();
        heap.set(0, heap.removeLast());

        int current = 0;
        while(current < heap.size() && leftChild(current) < heap.size() && rightChild(current) < heap.size()) {
            if(heap.get(leftChild(current)) > heap.get(current)) {
                swap(current, leftChild(current));
                current = leftChild(current);
            } else if(heap.get(rightChild(current)) > heap.get(current)) {
                swap(current, rightChild(current));
                current = rightChild(current);
            }
        }
        return max;
    }

    public int leftChild(int index) {
        return 2 * index + 1;
    }

    public int rightChild(int index) {
        return 2 * index + 2;
    }

    public int parent(int index) {
        return (index - 1)/2;
    }

    public void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    @Override
    public String toString() {
        return "Heap{" +
                "heap=" + heap +
                '}';
    }
}
