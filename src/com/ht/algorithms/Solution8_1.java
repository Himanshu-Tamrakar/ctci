package com.ht.algorithms;

public class Solution8_1 {
    public int tripalStep(int n) {
        return tripleStep_v4( n);
    }

    private int tripleStep_v1(int currentStep, int n) {
        if(currentStep > n) {
            return 0;
        }
        if(currentStep == n) {
            return 1;
        }
        int a = tripleStep_v1(currentStep+1, n);
        int b = tripleStep_v1(currentStep+2, n);
        int c = tripleStep_v1(currentStep+3, n);
        return a + b + c;
    }

    private int tripleStep_v2(int n) {
        if(n < 0) return 0;
        if(n == 0) return 1;
        return tripleStep_v2(n-1) + tripleStep_v2(n-2) + tripleStep_v2(n-3);
    }

    private int tripleStep_v3(int[] mem,int n) {
        if(n < 0) return 0;
        if(n == 0) return 1;
        if(mem[n] != 0) {
            return mem[n];
        }
        mem[n] =  tripleStep_v3(mem,n-1) + tripleStep_v3(mem, n-2) + tripleStep_v3(mem,n-3);
        return mem[n];
    }


    /**
     * Wrong: This is wrong solution
     * @param n
     * @return
     */
    private int tripleStep_v4(int n) {
        int[] mem = new int[n+1];
        mem[1] = 1;
        mem[2] = 2;
        mem[3] = 3;

        for (int i = 4; i <= n; i++) {
            mem[i] = mem[i-1] + mem[i-2] + mem[i-3] + 1;
        }
        return mem[n];
    }



    public static void main() {
        Solution8_1 sol = new Solution8_1();
        System.out.printf("Totoal nomber of ways %d \n", sol.tripalStep(20));
        System.out.printf("Totoal nomber of ways %d \n", sol.tripleStep_v3(new int[21], 20));
        System.out.printf("Totoal nomber of ways %d", sol.tripleStep_v2(20));
    }
}
