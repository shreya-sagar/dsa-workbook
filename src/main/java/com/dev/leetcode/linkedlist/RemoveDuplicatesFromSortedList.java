package com.dev.leetcode.linkedlist;

public class RemoveDuplicatesFromSortedList {

      //Definition for singly-linked list.
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head != null) {
            ListNode prevNode = head;
            ListNode currentNode = head.next;
            while (currentNode != null) {
                if(currentNode.val == prevNode.val) {
                    //remove the node
                    prevNode.next = currentNode.next;
                    currentNode.next = null;
                    currentNode = prevNode.next;
                } else {
                    prevNode = prevNode.next;
                    currentNode = currentNode.next;
                }
            }
        }
        return head;
    }

    // Utility to print the list
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print(" -> ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        // Creating the linked list 1 -> 1 -> 2 -> 3 -> 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        // Call deleteDuplicates
        ListNode result = deleteDuplicates(head);
        printList(result);
    }
}
