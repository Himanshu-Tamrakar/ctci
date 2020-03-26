package com.ht.algorithms;

/**
 * Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
 * cannot use additional data structures?
 */
public class Solution1_1 {

    /**
     * Considering input string will be ascii char only
     * @param s
     * @return
     */
    public static boolean isUnique_v1(String s) {
        if(s.length() > 255) return false;

        boolean[] ch = new boolean[256];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(ch[c]) return false;

            ch[c] = true;
        }
        return true;
    }

    /**
     * Considering only smaller case
     * @param s
     * @return
     */
    public static boolean isUnique_v2(String s) {
        if(s.length() > 26) return false;

        boolean[] ch = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            int c =  s.charAt(i)-'a';
            if(ch[c]) return false;

            ch[c] = true;
        }
        return true;
    }

    public static boolean isUnique(String s) {
        int checker = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if ((checker & (1 << c)) > 0) {
                return false;
            }
            checker |= (1<<c);
        }
        return true;
    }
}
