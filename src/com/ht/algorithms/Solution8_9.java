package com.ht.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * RED:
 * in time complexity; Due to use of Hashset that check duplicate every time add operation.
 */
public class Solution8_9 {
    private static Set<String> createParanthesis(int n) {
        Set<String> set = new HashSet<>();
        if(n == 1) {
            set.add("()");
            return set;
        }

        Set<String> result = createParanthesis(n-1);

        for (String str: result) {
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '(') {
                    String s = insertBracketAt(str, i);
                    set.add(s);
                }
            }
            set.add(str + "()");

        }
        return set;
    }

    private static String insertBracketAt(String str, int i) {
        String left = str.substring(0, i+1);
        String right  = str.substring(i+1, str.length());
        return left + "()" + right;
    }

    public static void main() {
        Solution8_9 sol = new Solution8_9();

        for (String s: sol.createParanthesis(3)) {
            System.out.println(s);
        }
    }
}
