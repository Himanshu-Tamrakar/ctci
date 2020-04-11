package com.ht.algorithms;

public class Solution4_10 {
    private static Node root;
    private static class Node {
        int item;
        Node left, right, parent;

        public Node(int item) {
            this.item = item;
        }
    }

    public static boolean isSubtree_v1(Node t1, Node t2) {
        StringBuilder s1 = new StringBuilder();
        getOrdered(t1, s1);

        StringBuilder s2 = new StringBuilder();
        getOrdered(t2, s2);

        return s1.indexOf(s2.toString()) != -1;
    }
    private static void getOrdered(Node root, StringBuilder s1) {
        if(root == null) {
            s1.append('X');
            return;
        }

        s1.append(root.item);
        getOrdered(root.left, s1);
        getOrdered(root.right, s1);
    }



    public static boolean isSubtree(Node t1, Node t2) {
        if(t1 == null) {
            return false;
        } else if(t1.item == t2.item && matchTree(t1, t2)) {
            return true;
        } else {
            return isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
        }
    }

    private static boolean matchTree(Node t1, Node t2) {
        if(t1 == null && t2 == null) {
            return true;
        } else if(t1 == null || t2 == null) {
            return false;
        } else if(t1.item != t1.item) {
            return false;
        } else {
            return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
        }
    }


    public static void main() {
        Node t1 = new Node(9);
        t1.left = new Node(5);
        t1.left.left = new Node(2);
        t1.left.left.left = new Node(1);
        t1.left.right = new Node(6);
        t1.left.left.right = new Node(3);
        t1.left.left.right.right = new Node(4);
        t1.right = new Node(13);
        t1.right.left = new Node(12);
        t1.right.right = new Node(14);

        Node t2 = t1.left.left.right;

        System.out.println(isSubtree(t1, t2));
    }
}
