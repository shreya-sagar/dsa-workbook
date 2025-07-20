package com.dev.datastructure.graph;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("A","B");
        //graph.removeEdge("A", "C");
        System.out.println(graph);
        graph.removeVertex("B");
        System.out.println(graph);
    }
}
