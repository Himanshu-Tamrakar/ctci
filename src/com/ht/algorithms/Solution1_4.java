package com.ht.algorithms;

/**
 * Given a string, write a function to check if it is a permutation of
 * a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
 * permutation is a rearrangement of letters. The palindrome does not need to be limited to just
 * dictionary words.
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations:"taco cat'; "atco cta '; etc.)
 */
public class Solution1_4 {
    private static int getCharectorNumber(char ch) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(ch);
        if(a <= val && val <= z) return val-a;
        return -1;
    }

    public static boolean isPalindromPermutation_v1(String s) {
        boolean[] ch = new boolean[26];
        int chacterCount = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = getCharectorNumber(s.charAt(i));
            if(c != -1) {
                ch[c] = !ch[c];
                chacterCount++;
            }
        }

        int countTrue = 0;

        for (int i = 0; i < ch.length; i++) {
            if(ch[i]) countTrue++;
            if(countTrue > 1) return false;
        }

        if(chacterCount % 2 == 0 && countTrue > 0) {
            return false;
        }
        if(chacterCount != 0 && countTrue != 1) {
            return false;
        }

        return true;
    }

    public static boolean isPalidropPermutation_v2(String s) {
        int[] table = new int[26];
        int totalCount = 0;
        for (char c: s.toCharArray()) {
            int ch = getCharectorNumber(c);
            if(ch != -1) {
                table[ch]++;
                if(table[ch] % 2 == 1) {
                    totalCount++;
                } else {
                    totalCount--;
                }
            }
        }
        return totalCount <= 1;
    }

    public static boolean isPalidropPermutation(String s) {
        int bitVector = createBitVector(s);
        return bitVector == 0 || checkExcatlyOneBitSet(bitVector);
    }

    private static boolean checkExcatlyOneBitSet(int bitVector) {
        return ((bitVector & (bitVector-1)) == 0);
    }

    private static int createBitVector(String s) {
        int bitVector = 0;
        for (char c: s.toCharArray()) {
            int index = getCharectorNumber(c);
            bitVector = togle(bitVector, index);
        }
        return bitVector;
    }

    private static int togle(int bitVector, int index) {
        if(index < 0) return bitVector;
        int mask = 1 << index;
        return bitVector ^ mask;
    }


}
