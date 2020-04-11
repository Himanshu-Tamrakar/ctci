package com.ht.algorithms;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

public class Solution4_1 {
    private static class RouteBetweenNodes {
        private boolean[] marked;
        private int[] edgeTo;
        Digraph G;
        public RouteBetweenNodes(Digraph G, int v) {
            this.G = G;
            this.marked = new boolean[G.V()];
            this.edgeTo = new int[G.V()];
            dfs(v);
            edgeTo[v] = v;
        }

        private void dfs(int v) {
            marked[v] = true;
            for (int w: G.adj(v)) {
                if(!marked[w]) {
                    dfs(w);
                    edgeTo[w] = v;
                }
            }
        }

        public boolean connected(int w) {
            return marked[w];
        }

        public Iterable<Integer> pathTo(int w) {
            Stack<Integer> stack = new Stack<>();
            stack.push(w);
            while (edgeTo[w] != w) {
                stack.push(edgeTo[w]);
                w = edgeTo[w];
            }

            return stack;
        }
    }
    public static void main() {
        Digraph G = new Digraph(new In("src/files/tinyDG.txt"));
        RouteBetweenNodes rbn = new RouteBetweenNodes(G, 0);
        for (int i = 0; i < 11; i++) {
            if(rbn.connected(i)) {
                System.out.printf("Path from %d to %d -> ", 0, i);
                for (int w: rbn.pathTo(i)) {
                    System.out.printf("%d ", w);
                }
                System.out.println();
            }

        }

    }
}
