package com.ht.algorithms;

public class Solution4_6 {
    private static Node root;
    private static class Node {
        int item;
        Node left, right, parent;

        public Node(int item) {
            this.item = item;
        }
    }

    /**
     * Success is smalles element greater than that element.
     * So either in right tree of current node or in parent until current element become left of its parent
     * @param root
     * @return
     */
    public static Node successor(Node root) {
        if(root == null) return null;
        if(root.right == null) {
            Node parent = root.parent;
            while (parent.left != root) {
                root = parent;
                parent = parent.parent;
            }
            return parent;
        } else {
            root = root.right;

            while (root.left != null) {
                root = root.left;
            }
            return root;
        }

    }

    public static void main() {
        root = new Node(5);
        root.left = new Node(2);
        root.left.parent = root;
//        root.right = new Node(7);
//        root.right.parent = root;

        root.left.left = new Node(1);
        root.left.left.parent = root.left;
//        root.left.right = new Node(3);
//        root.left.right.parent = root.left;
//        root.right.left = new Node(6);
//        root.right.left.parent = root.right;
//        root.right.right = new Node(8);
//        root.right.right.parent = root.right;
        System.out.println(successor(root.left.left).item);

    }
}
