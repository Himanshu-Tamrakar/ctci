 package com.ht.algorithms;

public class Solution5_4 {
    /**
     * Find rightmost non trailing zero index
     * @param n
     * @return
     */
    public static int nextBig(int n) {
        int c = n;
        int c0 = 0, c1 = 1;
        while (c != 0){
            //When c0th is >= 1 and c1th is 0 then stop
            int checkC0 = c & (1 << c0);
            int checkC1 = c & (1 << c1);
            if(checkC0 >= 1 && checkC1 == 0) {
                break;
            }
            c0++;c1++;
        }

        n = updateBit(n, c0, false);
        n = updateBit(n, c1, true);
        return n;
}

    public static int nextSmall(int n) {
        int c = n;
        int c0 = 0, c1 = 1;
        while (c != 0){
            //When c0th is >= 1 and c1th is 0 then stop
            int checkC0 = c & (1 << c0);
            int checkC1 = c & (1 << c1);
            if(checkC0 == 0 && checkC1 > 1) {
                break;
            }
            c0++;c1++;
        }

        n = updateBit(n, c0, true);
        n = updateBit(n, c1, false);
        return n;
    }

    private static int updateBit(int num, int i, boolean bitlsl) {
        int value = bitlsl ? 1 : 0;
        int mask = ~(1 << i);
        return (num & mask) | (value << i);
    }

    public static void main() {
        System.out.println("Original " + Integer.toBinaryString(13948));
        System.out.println("Next Big " + Integer.toBinaryString(nextBig(13948)));
        System.out.println("Original " + Integer.toBinaryString(13948));
        System.out.println("NextSmall" + Integer.toBinaryString(nextSmall(13948)));
    }
}
