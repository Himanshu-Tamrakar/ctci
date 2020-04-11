package com.ht.algorithms;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.Topological;

/**
 * Look again
 */
public class Solution4_7 {
    static boolean[] markered;
    static Stack<Integer> stack;
    static int[] indegreeEdgeCount;
    private static Digraph buildGraph(char[] projects, char[][] precedence) {
        Digraph G = new Digraph(projects.length);
        markered = new boolean[projects.length];
        indegreeEdgeCount = new int[projects.length];
        stack = new Stack<>();
        for (int i = 0; i < precedence.length; i++) {
            G.addEdge(precedence[i][0]-'a', precedence[i][1]-'a');
            indegreeEdgeCount[precedence[i][1] - 'a']++;
        }
        return G;
    }

    public static void reverseDFS(Digraph G, int v) {
        markered[v] = true;
        for (int w: G.adj(v)) {
            if(!markered[w]) {
                reverseDFS(G, w);
                stack.push(w);
            }
        }
//        stack.push(v);
    }

    public static void main() {
        char[] projects = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        char[][] precdence = new char[][]{
                {'f', 'c'},
                {'f', 'b'},
                {'f', 'a'},
                {'c', 'a'},
                {'b', 'a'},
                {'a', 'e'},
                {'d', 'g'}
        };

        Digraph G = buildGraph(projects, precdence);

        for (int i = 0; i < indegreeEdgeCount.length; i++) {
            if(indegreeEdgeCount[i] == 0) {
                reverseDFS(G, i);
                stack.push(i);
            }
        }


        for (int w:
             stack) {
            System.out.println(w);
        }

    }
}
