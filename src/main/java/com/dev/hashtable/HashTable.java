package com.dev.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashTable {
    private int size;
    private Node[] dataMap;

    HashTable(int size) {
        this.size = size;
        dataMap = new Node[size];
    }

    private int hash(String key) {
        int hash = 0;
        char[] chars = key.toCharArray();
        for(int i=0; i < chars.length; i++) {
            int ascii = chars[i];
            hash = (hash + (ascii * 17)) % size;
        }
        return hash;
    }

    public void set(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);
        if(dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key) {
        int index = hash(key);
        Node data = dataMap[index];
        while(data != null) {
            if(data.key.equals(key)) return data.value;
            data = data.next;
        }
        return 0;
    }

    public List<String> keys() {
        List<String> keys = new ArrayList<>();
        for (int i = 0; i < dataMap.length; i++) {
            Node node = dataMap[i];
            while(node != null) {
                keys.add(node.key);
                node = node.next;
            }
        }
        return keys;
    }

    class Node {
        private int value;
        private String key;
        private Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", key='" + key + '\'' +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "size=" + size +
                ", dataMap=" + Arrays.toString(dataMap) +
                '}';
    }
}
