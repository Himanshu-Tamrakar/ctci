package com.ht.algorithms;

import libs.Node;

public class Solution2_4 {
    public static Node split_v1(Node root, int n) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        while (root != null) {
            Node next = root.next;
            root.next = null;
            if(root.data < n) {
                if(beforeStart == null) {
                    beforeStart = root;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = root;
                    beforeEnd = root;
                }
            } else {
                if(afterStart == null) {
                    afterStart = root;
                    afterEnd = afterStart;
                } else  {
                    afterEnd.next = root;
                    afterEnd = root;
                }
            }
            root = next;
        }

        beforeEnd.next = afterStart;

        return beforeStart;
    }
}
