package com.ht.algorithms;

import libs.LinkedList;
import libs.Node;
import libs.SinglyLinkedList;

public class Main {

    public static void main(String[] args) {
       Solution2_8.main();
    }

    public static Node generateListAndReturn(int[] arr) {
        libs.LinkedList list = new LinkedList();
        for (int n: arr) {
            list.add(n);
        }
        return list.getList();
    }


}
