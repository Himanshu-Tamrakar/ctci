package com.ht.algorithms;

public class Solution8_11 {
    public int coins(int n) {
        if(n < 0) return 0;
        if(n == 0) return 1;

        return coins(n-25) + coins(n-10) + coins(n-5) + coins(n-1);
    }

    public static void main() {
        Solution8_11 sol = new Solution8_11();
        System.out.println(sol.coins(100));
        System.out.println(sol.makeChange(100));
    }

    int makeChange(int amount, int[] denoms, int index) {
        if (index >= denoms.length - 1) return 1;
        int denomAmount = denoms[index];

        int ways = 0;

        for (int i = 0; i * denomAmount <= amount; i++) {
            int amountRemaining = amount - i * denomAmount;
            ways += makeChange(amountRemaining, denoms, index + 1);
        }
        return ways;
     }

    int makeChange(int n) {
        int[] denoms = {25, 10,5, 1};
        return makeChange(n, denoms, 0);
        
    }


}
