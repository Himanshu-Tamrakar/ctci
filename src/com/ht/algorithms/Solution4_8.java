package com.ht.algorithms;

import edu.princeton.cs.algs4.Queue;

public class Solution4_8 {
    private static Node root;
    private static class Node {
        int item;
        Node left, right, parent;

        public Node(int item) {
            this.item = item;
        }
    }

    public static Node commonAncestorIfParentLinkAvailable(Node p, Node q) {
        int jump = getDepth(p) - getDepth(q);
        Node shallower = jump > 0 ? q : p;
        Node deepter = jump > 0 ? p : q;

        deepter = moveupword(deepter, jump);

        while (shallower.item != deepter.item) {
            shallower = shallower.parent;
            deepter = deepter.parent;
        }

        return shallower;
    }
    private static Node moveupword(Node root, int steps) {
        if(steps <= 0) return root;
        while (steps != 0)
        {
            root = root.parent;
            steps--;
        }
        return root;
    }
    private static int getDepth(Node root) {
        if (root == null) return 0;
        if(root.parent == null) return 1;

        return 1 + getDepth(root.parent);
    }


    /**
     * Handling required for if q == root.left and q = root.left.left; vise versa
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static Node commonAnsestorWithoutParentLink(Node root, Node p, Node q) {
        if(root == null || root.item == p.item || root.item == q.item) {
            return root;
        }
        boolean pPresentInLeft = contains(root.left, p.item);
        boolean qPresentInLeft = contains(root.left, q.item);

        //both present in left and right either where from root
        if(pPresentInLeft != qPresentInLeft) {
            return root;
        }

        Node nextChildRootToSearch = pPresentInLeft ? root.left : root.right;

        return commonAnsestorWithoutParentLink(nextChildRootToSearch, p, q);
    }

    private static boolean contains(Node root, int item) {
        if(root == null) return false;
        if(root.item == item) {
            return true;
        }
        return contains(root.left, item) || contains(root.right, item);

    }


//    public static Node commonAnsestorBFS(Node root, Node p, Node q) {
//        Queue<Node> queue = new Queue<>();
//        queue.enqueue(root);
//        Node currentParent;
//        while (!queue.isEmpty()) {
//            currentParent = queue.dequeue();
//            if(currentParent.left != null && (currentParent.left.item == p.item || currentParent.left.item == q.item)) {
//                return currentParent;
//            }
//            if(currentParent.right != null && (currentParent.right.item == p.item || currentParent.right.item == q.item)) {
//                return currentParent;
//            }
//
//
//            if(currentParent.left != null) queue.enqueue(currentParent.left);
//            if(currentParent.right != null) queue.enqueue(currentParent.right);
//        }
//        return root;
//    }

//    private static class NodeWithParent {
//        int item;
//        NodeWithParent left, right, parent;
//        public NodeWithParent(int item, NodeWithParent left, NodeWithParent right, NodeWithParent parent) {
//            this.left = left;
//            this.right = right;
//            this.parent = parent;
//        }
//    }
//
//    public static Node commonAnsestorBFS(Node root, Node p, Node q) {
//        Queue<Node> queue = new Queue<>();
//        Node current;
//        while (!queue.isEmpty()) {
//            current = queue.dequeue();
//            if(current != null && current.item == q.item || current.item == p.item) {
//
//            }
//
//            if(current.left != null) queue.enqueue(current.left);
//            if(current.right != null) queue.enqueue(current.right);
//        }
//        return root;
//    }


    public static void main() {
        root = new Node(5);
        root.left = new Node(2);
        root.left.parent = root;
        root.right = new Node(7);
        root.right.parent = root;
        root.left.left = new Node(1);
        root.left.left.parent = root.left;
        root.left.right = new Node(3);
        root.left.right.parent = root.left;
        root.right.left = new Node(6);
        root.right.left.parent = root.right;
        root.right.right = new Node(8);
        root.right.right.parent = root.right;

        root.right.left.left = new Node(9);
        root.right.left.left.parent = root.right.left;
        root.right.left.right = new Node(10);
        root.right.left.right.parent = root.right.left;

//        System.out.println(commonAnsestorBFS(root, root.right.left.left, root.right.left.right).item);
//        System.out.println(commonAnsestorBFS(root, root.left, root.left.right).item);
//        System.out.println(commonAnsestorBFS(root, root.left, root.left.left).item);
//        System.out.println(commonAnsestorBFS(root, root.left.left, root.right.left.right).item);
    }

}
