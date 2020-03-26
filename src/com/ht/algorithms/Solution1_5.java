package com.ht.algorithms;

public class Solution1_5 {
    public static boolean oneEditAway(String str1, String str2) {
        if(str1.length() == str2.length()) {
            return isOnePlaceEdit(str1, str2);
        } else {
            String s1, s2;
            if(str1.length() < str2.length()) {
                s1 = str1; s2=str2;
            }
            else {
                s1 = str2; s2 = str1;
            }
            return isOnePlaceInsert(s1, s2);
        }
    }

    private static boolean isOnePlaceInsert(String str1, String str2) {
        if(str1.length()+1 != str2.length()) return false;
        for (int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isOnePlaceEdit(String str1, String str2) {
        boolean foundDiference = false;
        for (int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                if(foundDiference) return false;
                foundDiference = true;
            }
        }
        return true;
    }
}
