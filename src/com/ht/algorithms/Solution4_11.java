package com.ht.algorithms;

import edu.princeton.cs.algs4.BST;

public class Solution4_11 {


    private class BST {
        private class Node {
            int item;
            Node left, right;
            int size;
            public Node(int item, int size) {
                this.item = item;
                this.size = size;
            }

        }

        Node root;
        public int size(Node root) {
            if(root == null) return 0;
            return root.size;
        }

        /**
         * Equally Probability
         * @return
         */
        public Node getRandonNode() {
            return getRandomNode(root, 1, root.size);
        }

        private Node getRandomNode(Node root, int min, int max) {
            int leftNodeSize = this.size(root.left);
            int random = this.random(min, max);
            int rootSize = 1 + this.size(root.left);
            if(random == rootSize) {
                return root;
            } else if(random < rootSize) {
                return getRandomNode(root.left, min, this.size(root.left));
            } else {
                return getRandomNode(root.right, min, this.size(root.right));
            }
        }

        private int random(int min, int max) {
            if (min > max) {
                throw new IllegalArgumentException("Invalid range");
            }

            double rand = Math.random();
            return (int)(rand * ((max - min) + 1)) + min;
        }

        public void put(int item) {
            root = this.put(root, item);
        }

        public Node put(Node root, int item) {
            if(root == null) return new Node(item, 1);
            if(item < root.item) {
                root.left = put(root.left, item);
            } else {
                root.right = put(root.right, item);
            }
            root.size = 1 + this.size(root.left) + this.size(root.right);
            return root;
        }

        public Node get(int key) {
            return get(root, key);
        }

        private Node get(Node root, int key) {
            if(root == null) return null;

            if(root.item == key) {
                return root;
            } else if(root.item > key) {
                return get(root.left, key);
            } else {
                return get(root.right, key);
            }
        }
    }


    public void main() {
        Solution4_11.BST tree = new Solution4_11.BST();
        tree.put(8);
        tree.put(4);
        tree.put(12);
        tree.put(1);
        tree.put(6);
        tree.put(9);
        tree.put(17);


        System.out.println(tree.getRandonNode().item);
    }



}
