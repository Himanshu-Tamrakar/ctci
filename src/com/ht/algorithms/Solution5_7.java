package com.ht.algorithms;

public class Solution5_7 {
    public static int swapOddEvenBits(int n) {
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString((0xaaaaaaa)));
        System.out.println(Integer.toBinaryString((n & 0xaaaaaaa)));
        return ((n & 0xaaaaaaa) >> 1) | ((n & 0x5555555) << 1);
    }
}
