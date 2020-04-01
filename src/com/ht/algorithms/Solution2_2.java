package com.ht.algorithms;

import libs.LinkedList;
import libs.Node;

public class Solution2_2 {
    public static Node generateListAndReturn() {
        LinkedList list = new LinkedList();
        list.add(1); list.add(2); list.add(8); list.add(4); list.add(3);
        list.add(1); list.add(2); list.add(8); list.add(4); list.add(3);
        return list.getList();
    }

    public static Integer kthToLast_v1(int k) {
        Node root = generateListAndReturn();
        Node head = root;
        int n = 0;
        while (head != null) {
            n++; head = head.next;
        }
        Node start = root;
        for (int i = 1; i <= n-k; i++) {
                start = start.next;
        }
        return start == null ? -1 : start.data;
    }

    public static void kthToLast(int k) {
        kthFromLast(generateListAndReturn(), k);
    }
    public static int kthFromLast(Node root, int k) {
        if(root == null) return 0;
        int n = 1 + kthFromLast(root.next, k);
        if(n == k) {
            System.out.println(root.data);
        }
        return n;
    }

    /**
     * Not correct
     * @param k
     * @return
     */
    public static Node kthLast(int k) {
        return null;
    }



    /**
     * Right
     * @param k
     * @return
     */
    public static Node kthFromLast(int k) {
        Node root = generateListAndReturn();
        Node head1 = root;
        Node head2 = root;
        for (int i = 0; i < k; i++) {
            if (head1 == null) return null;
            head1 = head1.next;
        }

        while (head1 != null) {
            head1 = head1.next;
            head2 = head2.next;
        }
        return head2;
    }


}
