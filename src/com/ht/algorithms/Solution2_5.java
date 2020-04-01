package com.ht.algorithms;

import libs.Node;

public class Solution2_5 {
    private static Node reverse(Node root)  {
        Node head = null;
        while(root != null) {
            Node copyNode = new Node(root.data, null);
            copyNode.next = head;
            head = copyNode;
            root = root.next;
        }
        return head;
    }

    private static Node reverseAndClone(Node root) {
        Node head = null;
        while(root != null) {
            Node copyNode = new Node(root.data, null);
            copyNode.next = head;
            head = copyNode;
            root = root.next;
        }
        return head;
    }

    public static void checkReverse(Node root) {
        Node head = reverse(root);
        while (head != null) {
            System.out.printf("%d ", head.data);
            head = head.next;
        }
    }

    public static int sum(Node list1, Node list2) {
        list1 = reverse(list1);
        list2 = reverse(list2);
        int sum = 0;
        while (list1 != null) {
            sum = sum * 10 + list1.data;
            list1 = list1.next;
        }
        int sum1 = 0;
        while (list2 != null) {
            sum1 = sum1 * 10 + list2.data;
            list2 = list2.next;
        }
        return sum + sum1;
    }
}
