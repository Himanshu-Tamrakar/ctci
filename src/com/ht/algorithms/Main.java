package com.ht.algorithms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
//    private static final Scanner scanner = new Scanner(System.in);
//
//
//
//    static String[] crosswordPuzzle(String[] crossword, String words) {
//        return null;
//    }
//
//    private static void fullyFitPuzzle(String[] crossword, String words) {
//        HashSet<String> set = new HashSet<>();
//        for (String s: words.split(";")) {
//            set.add(s);
//        }
//
//        for (int i = 0; i < 10; i++) {
//            Position p = firstAndLastPositionOfMinus(crossword[i]);
//            String word = wordWithSize(p.size, set);
//            if(word != null) {
//                for (int j = p.first; j <= p.last; j++) {
//                    StringBuilder sb = new StringBuilder(crossword[i]);
//                    sb.setCharAt(j, word.charAt(j-p.first));
//                    crossword[i] = sb.toString();
//                }
//                set.remove(word);
//            }
//
//        }
//    }
//
//    private static String wordWithSize(int size, HashSet<String> set) {
//        for (String s: set) {
//            if(s.length() == size) return s;
//        }
//        return null;
//    }
//
//    private ArrayList<String> wordsWithSize(int size, String words) {
//        ArrayList<String> list = new ArrayList<>();
//        for (String s: words.split(";")) {
//            if(s.length() == size) list.add(s);
//        }
//        return list;
//    }
//    private static class Position {
//        int first;
//        int last;
//        int size = 0;
//        public Position(int first, int last, int size) {
//            this.first = first;
//            this.last = last;
//            this.size = size;
//        }
//    }
//    private static Position firstAndLastPositionOfMinus(String s) {
//        int lo = 0;
//        int hi = s.length()-1;
//        int first = -1, last = -1;
//        while (lo <= hi) {
//            if(s.charAt(lo) == '-') {
//                first = lo;
//                break;
//            }
//            lo++;
//        }
//        if(lo == hi) last = first;
//        else {
//            while (hi >= lo) {
//                if(s.charAt(hi) == '-' ) {
//                    last = hi;
//                    break;
//                }
//                hi--;
//            }
//        }
//
//        return new Position(first, last, last-first+1);
//    }
//    private static void readInput() throws IOException {
//        String[] crossword = new String[10];
//
//        for (int i = 0; i < 10; i++) {
//            String crosswordItem = scanner.nextLine();
//            crossword[i] = crosswordItem;
//        }
//
//        String words = scanner.nextLine();
//
//        fullyFitPuzzle(crossword, words);
//        scanner.close();
//    }

    public static void main(String[] args) {
//        try {
//            readInput();
//        } catch(IOException ioex) {
//            System.out.println(ioex);
//        }



    }

    public static void sieveOfEratosthenes(int n) {
        boolean[] flags = new boolean[n+1];
        int prime = 2;

        while (prime <= Math.sqrt(n)) {
            crossOff(flags, prime);
            prime = nextPrime(flags, prime);
        }

        for (int i = 0; i < flags.length; i++) {
            if(!flags[i]) System.out.printf("%d ", i);
        }
    }

    private static void crossOff(boolean[] flags, int prime) {
        for (int i = prime * prime; i < flags.length; i += prime) {
            flags[i] = true;
        }
    }

    private static int nextPrime(boolean[] flags, int prime) {
        for (int i = prime+1; i < flags.length; i++) {
            if(!flags[i]) return i;
        }
        return Integer.MAX_VALUE;
    }


}
