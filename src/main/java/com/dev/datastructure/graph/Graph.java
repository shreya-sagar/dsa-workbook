package com.dev.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph {
    private HashMap<String, ArrayList<String>> adjacencyList = new HashMap<>();

    public boolean addVertex(String vertex) {
        if(adjacencyList.get(vertex) == null) {
            adjacencyList.put(vertex, new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean removeVertex(String vertex) {
        if(adjacencyList.get(vertex) != null) {
            // visits all vertices
            //adjacencyList.values().forEach(value -> value.remove(vertex));

            //visit only vertices which are connected through edges
            adjacencyList.get(vertex).stream()
                            .forEach(connected -> {
                                System.out.println(connected);
                                adjacencyList.get(connected).remove(vertex);
                            });

            adjacencyList.remove(vertex);
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertex1, String vertex2) {
        if(adjacencyList.get(vertex1) != null && adjacencyList.get(vertex2) != null) {
            adjacencyList.get(vertex1).add(vertex2);
            adjacencyList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vertex1, String vertex2) {
        if(adjacencyList.get(vertex1) != null && adjacencyList.get(vertex2) != null) {
            adjacencyList.get(vertex1).remove(vertex2);
            adjacencyList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "adjacencyList=" + adjacencyList +
                '}';
    }
}
