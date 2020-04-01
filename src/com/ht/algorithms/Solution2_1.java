package com.ht.algorithms;

import libs.LinkedList;
import libs.Node;
import libs.SinglyLinkedList;

import java.util.HashSet;

public class Solution2_1 {
    public static Node generateListAndReturn() {
        LinkedList list = new LinkedList();
        list.add(1); list.add(2); list.add(8); list.add(4); list.add(3);
        list.add(1); list.add(2); list.add(8); list.add(4); list.add(3);
        return list.getList();
    }

    public static void removeDuplicate_v1() {
        Node head = generateListAndReturn();
        Node root = head;
        while(root != null && root.next != null) {
            Node nextRoot = root.next;
            Node prev = root;
            while (nextRoot != null) {
                if(nextRoot.data == root.data) {
                    prev.next = nextRoot.next;
                } else {
                    prev = nextRoot;
                }
                nextRoot = nextRoot.next;
            }
            root = root.next;
        }

        Node start = head;
        while (start != null) {
            System.out.println(start.data);
            start = start.next;
        }

    }

//    public static void removeDuplicate_v2() {
//        getRandomList();
//        if(head == null) return;
//        Node prev = null;
//        Node root = head;
//        HashSet<Integer> st = new HashSet<>();
//
//        while (root != null) {
//            if(st.contains(root.data)) {
//                prev.next = root.next;
//            } else {
//                st.add(root.data);
//                prev = root;
//            }
//            root = root.next;
//        }
//
//        Node iterate = head;
//        while(iterate != null) {
//            System.out.println(iterate.data);
//            iterate = iterate.next;
//        }
//
//
//    }
}
