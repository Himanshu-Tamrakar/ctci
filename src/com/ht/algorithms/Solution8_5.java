package com.ht.algorithms;

import com.sun.org.apache.regexp.internal.RE;
import edu.princeton.cs.algs4.In;

public class Solution8_5 {
    public int multiply(int a, int b) {
        int OR = a | b;
        int REMAIN = (a*b) - OR;
        return REMAIN + OR;
    }

    /**
     * So many statements Not worth:
     * running time: O(numberofbitsinsmallernumber)
     * @param a
     * @param b
     * @param lengthOfB
     * @param index
     * @param result
     * @return
     */
    public static int recursiveMultiply_v1(int a, int b, int lengthOfB, int index, int result) {
        int newValue;
        if(index >= lengthOfB) {
            return result;
        }

        int nthBit = (b & (1 << index));
        if(nthBit > 0) {
            newValue = a << index;
        } else {
            newValue = 0 << index;
        }
        return recursiveMultiply_v1(a, b, lengthOfB, ++index, result + newValue);

    }

    /**
     * same as v1 but recursive call with less arguments
     * running time: O(numberofbitsinsmallernumber)
     * @param a
     * @param b
     * @param index
     * @return
     */
    public static int recursiveMultiply_v2(int a, int b, int index) {
        if(index < 0) {
            return 0;
        }

        int result = recursiveMultiply_v2(a, b, --index);

        int nthBit = (b & (1 << index));
        if(nthBit > 0) {
            return (a << index) + result;
        }
        return result;

    }

    /**
     * very strange not calling for index value three: i dont know why
     * @param a
     * @param b
     * @param index
     * @return
     */
    public static int recursiveMultiply_v3(int a, int b, int index) {
        if(index <= 0) {
            return 0;
        }

        int result = recursiveMultiply_v3(a, b, --index);

        int nthBit = (b & (1 << index));
        if(nthBit > 0) {
            return (a << index) + result;
        }
        return result;

    }


    private int minProduct(int a, int b) {
        int smaller = a < b ? a : b;
        int bigger = a < b ? b : a;
        int[] mem = new int[smaller+1];
        return minProduct(smaller, bigger, mem);
    }

    private int minProduct(int smaller, int bigger, int[] mem) {
        if(smaller == 0) return 0;
        else if(smaller == 1) return bigger;
        else if(mem[smaller] > 0) return mem[smaller];

        int s = smaller >> 1;
        int side1 = minProduct(s, bigger, mem);
        int side2 = side1;
        if(smaller % 2 == 1) {
            side2 = minProduct(smaller-s, bigger, mem);
        }

        mem[smaller] = side1+side2;
        return mem[smaller];

    }

    /**
     * running time: O(log smaller);
     * @param smaller
     * @param bigger
     * @return
     */
    private int minProduct_optimized(int smaller, int bigger) {
        if(smaller == 0) return 0;
        else if(smaller == 1) return bigger;

        int s = smaller >> 1;
        int halfResult = minProduct_optimized(s, bigger);
        if(smaller % 2 == 1) {
            return halfResult + halfResult + bigger;
        } else {
            return halfResult + halfResult;
        }
    }





    public static void main() {
        Solution8_5 sol = new Solution8_5();
        System.out.println(Solution8_5.recursiveMultiply_v1(23, 11, 4, 0, 0));
        System.out.println(Solution8_5.recursiveMultiply_v2(53, 11, 4));
        System.out.println(Solution8_5.recursiveMultiply_v3(53, 11, 4));
        System.out.println(sol.minProduct(8, 7));
        System.out.println(sol.minProduct_optimized(53, 11));
    }
}
