package com.dev.queue;

public class QueueMain {
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enqueue(20);
        queue.enqueue(2);
        queue.printQueue();

        System.out.println("Dequeue " + queue.dequeue());
        queue.getFirst();
        queue.getLast();
        queue.getLength();
        queue.printQueue();
    }
}
