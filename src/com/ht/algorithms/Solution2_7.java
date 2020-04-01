package com.ht.algorithms;

import libs.LinkedList;
import libs.Node;

import java.util.HashSet;
import java.util.TreeSet;

public class Solution2_7 {
    private static Node intersecByNode_v1(Node list1, Node list2) {
        TreeSet<Node> st = new TreeSet<>();
        while (list1 != null) {
            st.add(list1);
            list1 = list1.next;
        }

        while (list2 != null) {
            if(st.contains(list2)) {
                return list2;
            }
            list2 = list2.next;
        }
        return null;
    }

    private static Node intersectNode(Node list1, Node list2) {
        Result listR1 = getTailAndSize(list1);
        Result listR2 = getTailAndSize(list2);

        if(listR1.tail.compareTo(listR2.tail) != 0) {
            return null;
        }

        Node sorterNodeRef = listR1.size < listR2.size ? list1 : list2;
        Node longetNodeRef = listR1.size > listR2.size ? list1 : list2;

        longetNodeRef = moveHead(longetNodeRef, Math.abs(listR1.size - listR2.size));

        while (sorterNodeRef != longetNodeRef) {
            sorterNodeRef = sorterNodeRef.next;
            longetNodeRef = longetNodeRef.next;
        }

        return longetNodeRef;
    }

    private static Node moveHead(Node root, int n) {
        while(n > 0 && root != null) {
            n--;
            root = root.next;
        }
        return root;
    }

    private static Result getTailAndSize(Node list) {
        int sz = 0;
        while (list.next != null) {
            list = list.next;
            sz++;
        }

        return new Result(list, sz);
    }

    private static class Result {
        Node tail;
        int size;
        Result(Node tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }


    public static void main() {
        Node one = generateListAndReturn(new int[] {1,3,5,7,9,10});

        Node refOne = one;
        int i = 0;
        while (i < 4) {
            refOne = refOne.next;
            i++;
        }

        Node two = generateListAndReturn(new int[] {2,4});
        Node reTwo = two;
        while (reTwo.next != null) {
            reTwo = reTwo.next;
        }
        reTwo.next = refOne;

        System.out.printf("%d", Solution2_7.intersectNode(one, two).data);
    }

    public static Node generateListAndReturn(int[] arr) {
        libs.LinkedList list = new LinkedList();
        for (int n: arr) {
            list.add(n);
        }
        return list.getList();
    }



}
