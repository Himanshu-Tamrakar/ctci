package com.ht.algorithms;

import edu.princeton.cs.algs4.BST;

import java.util.HashMap;

public class Solution4_12 {
    static Node root;
    private static class Node {
        int item;
        Node left, right;
        public Node(int item) {
            this.item = item;
        }
    }

    public static int countPathWithSum_v1(Node root, int targetSum) {
        if(root == null) return 0;
        int pathsFromRoot = cauntPathsWithSumFromNode(root, targetSum, 0);

        int pathsOnLeft = countPathWithSum_v1(root.left, targetSum);
        int pathsOnRight = countPathWithSum_v1(root.right, targetSum);

        return pathsFromRoot + pathsOnLeft + pathsOnRight;
    }

    private static int cauntPathsWithSumFromNode(Node root, int target, int currentSum) {
        if(root == null) return 0;

        currentSum += root.item;
        int totalPaths = 0;
        if(target == currentSum) totalPaths++;

        totalPaths += cauntPathsWithSumFromNode(root.left, target, currentSum);
        totalPaths += cauntPathsWithSumFromNode(root.right, target, currentSum);
        return totalPaths;
    }

    /**
     *
     * @param root
     * @param targetSum
     * @return
     */
    public static int countPathWithSum(Node root, int targetSum) {
        return countPathWithSum(root, targetSum, 0, new HashMap<>());
    }

    private static int countPathWithSum(Node root, int targetSum, int runningCount,  HashMap<Integer, Integer> pathCount) {
        if(root == null) return 0;
        runningCount += root.item;
        int sum = runningCount - targetSum;
        int totalPath = pathCount.getOrDefault(sum, 0);
        if(runningCount == targetSum) totalPath++;

        incrementHashTable(pathCount, runningCount, 1);
        totalPath += countPathWithSum(root.left, targetSum, runningCount, pathCount);
        totalPath += countPathWithSum(root.right, targetSum, runningCount, pathCount);
        incrementHashTable(pathCount, runningCount, -1);

        return totalPath;
    }

    private static void incrementHashTable(HashMap<Integer, Integer> st, int key, int delta) {
        int newcount = st.getOrDefault(key, 0) + delta;
        if(newcount == 0) st.remove(key);
        else st.put(key, newcount);
    }

    public static void main() {
        root = new Node(10);
        root.left = new Node(5);

        root.left.left = new Node(3);
        root.left.left.left = new Node(3);
        root.left.right = new Node(2);
        root.left.right.right = new Node(1);
        root.left.left.right = new Node(-2);

        root.right = new Node(-3);
        root.right.right = new Node(11);
        System.out.println(countPathWithSum(root, 18));
    }
}
