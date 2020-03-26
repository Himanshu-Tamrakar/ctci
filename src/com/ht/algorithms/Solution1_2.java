package com.ht.algorithms;

/**
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the
 * other.
 */
public class Solution1_2 {
    public static boolean isPermutation_v1(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }

        int[] ch = new int[256];

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            ch[c]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            ch[c]--;
        }
        for (int i = 0; i < ch.length; i++) {
            if(ch[i] > 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPermutation(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }

        int[] arr = new int[256];

        for (char c: s1.toCharArray()) {
            arr[c]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            arr[c]--;
            if(arr[c] < 0) {
                return false;
            }
        }

        return true;
    }
}
