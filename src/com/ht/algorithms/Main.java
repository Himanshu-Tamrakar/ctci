package com.ht.algorithms;

import libs.LinkedList;
import libs.Node;
import libs.SinglyLinkedList;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        sieveOfEratosthenes(10);
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
