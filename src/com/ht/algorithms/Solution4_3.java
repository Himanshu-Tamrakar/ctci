package com.ht.algorithms;

import edu.princeton.cs.algs4.Queue;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution4_3 {
    static ArrayList<LinkedList<Integer>> listInDepth = new ArrayList<>();
    static Node root;
    private static class Node {
        int item;
        Node left, right;
        int size;
        public Node(int item, int size) {
            this.item = item;
            this.size = size;
        }
    }

    private static void bfsBinaryTree(Node root, Queue queue) {
        while (!queue.isEmpty()) {
            Node node = (Node) queue.dequeue();
            int depth = node.size;
            if(listInDepth.size() < depth) {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(node.item);
                listInDepth.add(list);
            } else {
                LinkedList<Integer> list = listInDepth.get(depth-1);
                list.add(node.item);
            }
            if(node.left != null) queue.enqueue(node.left);
            if (node.right != null) queue.enqueue(node.right);
        }
    }

    public static void main() {
        Queue<Node> queue = new Queue<>();
        root = new Node(5, 1);
        root.left = new Node(2,2);
        root.right = new Node(7,2);
        root.left.left = new Node(1,3);
        root.left.right = new Node(3, 3);
        root.right.left = new Node(6, 3);
        root.right.right = new Node(8, 3);
        queue.enqueue(root);
        bfsBinaryTree(root, queue);
        int i = 0;
        for (LinkedList<Integer> list: listInDepth) {
            i++;
            for (int item: list) {
                System.out.printf("List %d value %d \n", i, item);
            }
        }
    }
}
