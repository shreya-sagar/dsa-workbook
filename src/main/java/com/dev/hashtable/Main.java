package com.dev.hashtable;

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(5);
        hashTable.set("Dey", 5);
        hashTable.set("Edy", 6);
        hashTable.set("Yde", 7);
        hashTable.set("Sagar", 2);
        System.out.println(hashTable);
        System.out.println(hashTable.get("Yde"));
        System.out.println(hashTable.get("Sagar"));
        System.out.println(hashTable.get("pathak"));

        System.out.println(hashTable.keys());
    }
}
