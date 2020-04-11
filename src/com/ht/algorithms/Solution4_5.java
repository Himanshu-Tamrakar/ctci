package com.ht.algorithms;

import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.In;

public class Solution4_5 {
    private static Node root;
    private static class Node {
        int item;
        Node left, right;
        public Node(int item) {
            this.item = item;
        }
    }

    private static boolean checkBST(Node root, int min, int max) {
        if(root == null) return true;

        if((min != Integer.MIN_VALUE && root.item < min) || (max != Integer.MAX_VALUE && root.item > max)) {
            return false;
        }

        if(!checkBST(root.left, min, root.item) || !checkBST(root.right, root.item, max)) {
            return false;
        }
        return true;
    }

    /**
     * Another solution is do inorder traversal that result sorted array and check whether array is really sorted
     */



    public static void main() {
        root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(34_6);
        root.right.left = new Node(6);
        root.right.right = new Node(8);

        System.out.println(checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}

