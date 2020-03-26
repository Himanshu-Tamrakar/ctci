package com.ht.algorithms;

public class Solution1_3 {
    public static String urlify(char[] chArr) {
        int lastCharIndex = chArr.length-1;
        for (int i = chArr.length-1; i >= 0 ; i--) {
            if(chArr[i] != ' ') {
                lastCharIndex = i;
                break;
            }
        }

        return urlify(chArr, lastCharIndex);
    }

    public static String urlify(char[] ch, int lastCharIndex) {
        int n = ch.length-1;
        for (int i = lastCharIndex; i >= 0 ; i--) {
            if(ch[i] != ' ') {
                ch[n--] = ch[i];
            } else {
                ch[n--] = '0';
                ch[n--] = '2';
                ch[n--] = '%';
            }
        }

        return new String(ch);
    }
}
