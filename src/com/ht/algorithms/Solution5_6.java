package com.ht.algorithms;

public class Solution5_6 {
    public static int bitSwapRequired_v1(int n, int m) {
        int xor = n ^ m;
        int count = 0;
        String binaryRepresentation = Integer.toBinaryString(xor);
        for (int i = 0; i < binaryRepresentation.length(); i++) {
            if(binaryRepresentation.charAt(i) == '1') count++;
        }

        return count;
    }

    public static int bitSwapRequired_v2(int n, int m) {
        int count = 0;
        for (int i = n ^ m; i != 0; i >>= 1) {
            if((i & 1) == 1) count++;
        }
        return count;
    }

    public static int bitSwapRequired(int n, int m) {
        int count = 0;
        for (int i = n ^ m; i != 0; i = i & (i-1)) {
            count++;
        }
        return count;
    }

    public static void main() {
        System.out.println(bitSwapRequired_v1(29, 15));
        System.out.println(bitSwapRequired_v2(29, 15));
        System.out.println(bitSwapRequired(29, 15));
    }
}
