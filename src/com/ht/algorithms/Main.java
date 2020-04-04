package com.ht.algorithms;

import libs.LinkedList;
import libs.Node;
import libs.SinglyLinkedList;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Solution3_6.main();

    }

    public static Node generateListAndReturn(int[] arr) {
        libs.LinkedList list = new LinkedList();
        for (int n: arr) {
            list.add(n);
        }
        return list.getList();
    }


}
