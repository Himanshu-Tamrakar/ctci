package com.ht.algorithms;

public class Solution4_2 {
    private Node root;

    public void constructMinimulTree(int[] items) {
        root = minimulTree(items, root, 0, items.length-1);
        System.out.println(root);
    }

    private Node minimulTree(int[] items, Node root, int lo, int hi) {
        if(lo > hi) return null;
        int mid = lo + (hi-lo) / 2;
        root = new Node(items[mid]);
        root.left = minimulTree(items, root.left, lo, mid-1);

        root.right = minimulTree(items, root.right, mid+1, hi);
        return root;
    }

    private class Node {
        private int item;
        private Node left;
        private  Node right;
        public Node(int item) {
            this.item = item;
        }
    }

    public void main() {
        int[] arr = new int[] {1, 2, 3};
        constructMinimulTree(arr);
    }
}
