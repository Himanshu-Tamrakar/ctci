package com.ht.algorithms;

import libs.Node;

public class Solution2_3 {
    public static boolean middle(Node middle) {
        if(middle == null || middle.next == null) return false;
        Node next = middle.next;
        middle.data = next.data;
        middle.next = next.next;
        return true;
    }
}
