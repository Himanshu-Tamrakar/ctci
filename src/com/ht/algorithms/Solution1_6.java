package com.ht.algorithms;

public class Solution1_6 {
    public static String compress_v1(String s) {
        String compressedString = "";
        int index = 0;
        while(index < s.length()) {
            int repeateCount = 1;
            while (index < s.length() -1 && s.charAt(index) == s.charAt(index+1))  {
                repeateCount++;
                index++;
            }
            compressedString += s.charAt(index) + "" + repeateCount + "";
            index++;
        }
        return compressedString;
    }

    public static String compress(String s) {
        StringBuilder compressedString = new StringBuilder();
        int index = 0;
        while(index < s.length()) {
            int repeateCount = 1;
            while (index < s.length() -1 && s.charAt(index) == s.charAt(index+1))  {
                repeateCount++;
                index++;
            }
            compressedString = compressedString.append("" + s.charAt(index) + repeateCount);
            index++;
        }
        return compressedString.toString();
    }


}
