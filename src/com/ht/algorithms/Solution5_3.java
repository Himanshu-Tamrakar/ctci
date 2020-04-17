package com.ht.algorithms;

public class Solution5_3 {
    public static int findLogestSequence(int n) {
        if(~n == 0) return Integer.BYTES * 8;
        if(n == 1) return 1;

        char[] binaryArray = Integer.toBinaryString(n).toCharArray();
        int startIndex = 0;
        int logestSequence = Integer.MIN_VALUE;
        for (int i = 0; i < binaryArray.length; i++) {
            if(binaryArray[i] == '0') {

                int tempStartIndex = startIndex;
                startIndex = i;
                if(binaryArray[startIndex] == '0') startIndex++;
                while (i<binaryArray.length-1 && binaryArray[i+1] != '0') {
                    i++;
                }
               int calc = i - tempStartIndex + 1;

               logestSequence = Math.max(logestSequence, calc);
            }
        }

        return logestSequence;
    }

    public static int flipBit(int n) {
        if(~n == 0) return Integer.BYTES * 8;
        if(n == 1) return 1;
        int currentLength = 0;
        int previousLength = 0;
        int maxLength = 1;
        while (n != 0) {
            if((n & 1) == 1) {
                currentLength++;
            } else if((n & 1) == 0) {
                previousLength = (n & 2) == 0 ? 0 : currentLength;
                currentLength = 0;
            }
            maxLength = Math.max(maxLength, currentLength + previousLength + 1);
            n >>>= 1;
        }
        return maxLength;
    }

    public static void main() {
        System.out.println(findLogestSequence(1775));
        System.out.println(findLogestSequence(506));
        System.out.println(findLogestSequence(385));
        System.out.println(findLogestSequence(1));
       System.out.println("-------------");
        System.out.println(flipBit(1775));
        System.out.println(flipBit(506));
        System.out.println(flipBit(385));
        System.out.println(flipBit(1));

    }
}
