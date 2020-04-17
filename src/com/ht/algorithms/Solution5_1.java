package com.ht.algorithms;

import sun.awt.X11.XSystemTrayPeer;

public class Solution5_1 {
    public static int insertion(int n, int m, int i, int j) {
        int seed = ~0;
        int left = seed << (j+1);
        int right = ~(seed << i);
        System.out.println(Integer.toBinaryString(left));
        System.out.println(Integer.toBinaryString(right));
        int clear = left | right;
        System.out.println(Integer.toBinaryString(clear));
        n &= clear;
        System.out.println(Integer.toBinaryString(n));
        m = m << i;

        n |= m;
        return n;
    }
    public static void main() {
//        System.out.println(Integer.toBinaryString(insertion(1024, 19, 2, 6)));
//        System.out.println(Integer.toBinaryString(insertion(70, 5, 1, 3)));
    }
}
